/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class AccountDAOImpl extends CommonDAOImpl implements AccountDAO {

	/**
	 * adding bank account details to account table
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBankAccountDetail(AccountDO accountDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(accountDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding new bank account details", hExp);
		}
	}

}
