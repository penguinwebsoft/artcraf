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

import com.crafart.dataobjects.OrderStatusDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.OrderStatusDAO;

/**
 * @author
 * 
 */
@Repository("orderStatusDAOImpl")
public class OrderStatusDAOImpl extends CommonDAOImpl implements OrderStatusDAO {


	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addOrderStatusDetail(OrderStatusDO orderStatusDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(orderStatusDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding orderStatus details in table", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<OrderStatusDO> getOrderStatusDetail() throws CrafartDataException {
		List<OrderStatusDO> orderStatusDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			orderStatusDOs = session.createQuery("from OrderStatusDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving GeoZone details", hExp);
		}
		return orderStatusDOs;
	}

}
