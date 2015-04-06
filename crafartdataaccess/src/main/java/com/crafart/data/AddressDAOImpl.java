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

import com.crafart.dataobjects.AddressDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AddressDAO;

/**
 * @author Karthi
 * 
 */
@Repository("AddressDAOImpl")
public class AddressDAOImpl implements AddressDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * creating DB connection and inserting values through persist(),after
	 * inserting Committing the transaction by commit()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addAddress(AddressDO addressDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(addressDO);
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding new address details", hExp);
		}

	}

}
