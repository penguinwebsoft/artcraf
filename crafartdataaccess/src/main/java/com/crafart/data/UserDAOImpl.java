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

import com.crafart.dataobjects.UserDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.UserDAO;

/**
 * @author
 * 
 */
@Repository("userDAOImpl")
public class UserDAOImpl extends CommonDAOImpl implements UserDAO {


	/**
	 * adding UserDetail details to UserDetail table by addUserDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUserDetail(UserDO userDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(userDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding user details in table", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserDO> getUserDetail() throws CrafartDataException {
		List<UserDO> userDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			userDOs = session.createQuery("from UserDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving user details", hExp);
		}
		return userDOs;
	}

}
