/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CourierDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CourierDAO;

/**
 * @author Karthi
 * 
 */
@Repository("courierDAOImpl")
public class CourierDAOImpl implements CourierDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * adding courier details to courier table by addCourierDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCourierDetail(CourierDO courierDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(courierDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding Courier details in table", hExp);
		}
	}

	/**
	 * here getCourierDetail will get all courier detail from courier table as
	 * list object using CreateQuery()
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CourierDO> getCourierDetail() throws CrafartDataException {
		List<CourierDO> courierDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			courierDOs = session.createQuery("from CourierDO").list();
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving courier details", hExp);
		}
		return courierDOs;
	}

}
