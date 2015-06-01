/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CrafartOrderDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CrafartOrderDAO;

/**
 * @author Karthi
 * 
 */
@Repository("crafartOrderDAOImpl")
public class CrafartOrderDAOImpl implements CrafartOrderDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCrafartOrder(CrafartOrderDO crafartOrderDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(crafartOrderDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error in adding Crafart Order Detail", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CrafartOrderDO> getCrafartOrder() throws CrafartDataException {
		List<CrafartOrderDO> crafartOrderDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			crafartOrderDOs = session.createQuery("from CrafartOrderDO").list();
			//session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving from DB", hExp);
		}
		return crafartOrderDOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCrafartOrder(CrafartOrderDO crafartOrderDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.update(crafartOrderDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while updating Crafart order", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CrafartOrderDO> getCustomerOrder(long customerId) throws CrafartDataException {
		List<CrafartOrderDO> crafartOrderDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from CrafartOrderDO where customer_id = :customer_id");
			query.setLong("customer_id", customerId);
			crafartOrderDOs = (List<CrafartOrderDO>) query.list();
			session.getTransaction().commit();
			session.close();
		} catch (EmptyResultDataAccessException hExp) {
			return null;
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving order details", hExp);
		}
		return crafartOrderDOs;
	}
}
