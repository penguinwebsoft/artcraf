package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("sellerDAOImpl")
public class SellerDAOImpl implements SellerDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add seller details to database and returns with generated primary key. if
	 * error during the DB insertion all other related transactions are rolled
	 * back.
	 * 
	 * <li>{@link CrafartDataException} thrown back to caller method if there
	 * are any error while adding the database. <li>caller method have to handle
	 * the exception and appropriate implementation measures to be taken based
	 * on the error.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeller(SellerDO sellerDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(sellerDO);
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding new seller details", hExp);
		}

	}

}
