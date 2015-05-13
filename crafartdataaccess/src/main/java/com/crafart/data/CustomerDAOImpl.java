/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CustomerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CustomerDAO;

/**
 * @author Karthi
 * 
 */
@Repository("customerDAOImpl")
public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCustomer(CustomerDO customerDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.save(customerDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding customer detail", hExp);
	}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CustomerDO getCustomerDetails(long customerId) throws CrafartDataException {
		CustomerDO customerDO = new CustomerDO();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from CustomerDO where customer_id = :customer_id");
			query.setLong("customer_id", customerId);
			customerDO = (CustomerDO) query.uniqueResult();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving customer details", hExp);
		}
		return customerDO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCustomerDetails(CustomerDO customerDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.update(customerDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Erroe while updating customer details", hExp);
		}
	}
}
