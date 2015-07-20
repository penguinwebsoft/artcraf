/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
@Transactional
public class CourierDAOImpl extends CommonDAOImpl implements CourierDAO {

	/**
	 * adding courier details to courier table by addCourierDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCourier(CourierDO courierDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(courierDO);
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
	public List<CourierDO> getCouriers() throws CrafartDataException {
		List<CourierDO> courierDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			courierDOs = session.createQuery("from CourierDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving courier details", hExp);
		}
		return courierDOs;
	}

	/**
	 * retrieve courier data object from persistence for the identifier {@link Long} courierId
	 */
	@Override
	public CourierDO getCourier(long courierId) throws CrafartDataException {
		CourierDO courierDO = (CourierDO) this.getSessionFactory().getCurrentSession().get(CourierDO.class, courierId);
		return courierDO;
	}

}
