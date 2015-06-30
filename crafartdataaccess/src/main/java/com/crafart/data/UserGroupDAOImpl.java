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

import com.crafart.dataobjects.UserGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.UserGroupDAO;

/**
 * @author
 *
 */
@Repository("userGroupDAOImpl")
public class UserGroupDAOImpl extends CommonDAOImpl implements UserGroupDAO {



	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUserGroup(UserGroupDO userGroupDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(userGroupDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error in adding User Group Detail", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserGroupDO> getUserGroupDetail() throws CrafartDataException {
		List<UserGroupDO> userGroupDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			userGroupDOs = session.createQuery("from UserGroupDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving UserGroup details", hExp);
		}
		return userGroupDOs;
	}
}
