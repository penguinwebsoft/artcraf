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

import com.crafart.dataobjects.AccountDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AccountDAO;

/**
 * @author Karthi
 * 
 */
@Repository("accountDAOImpl")
public class AccountDAOImpl implements AccountDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * adding bank account details to account table
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBankAccountDetail(AccountDO accountDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(accountDO);
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding new bank account details", hExp);
		}
	}

}
