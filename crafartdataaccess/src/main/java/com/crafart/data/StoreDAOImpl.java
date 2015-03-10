/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("StoreDAOImpl")
public class StoreDAOImpl implements StoreDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * adding store detail to store table {@link CrafartDataException} will
	 * throws to caller method if any exception occurred storeId is generated by
	 * seq automatically
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addStoreDetail(StoreDO storeDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(storeDO);
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			hExp.printStackTrace();
			throw new CrafartDataException("DB Error while adding new store details", hExp);
		}

	}
}
