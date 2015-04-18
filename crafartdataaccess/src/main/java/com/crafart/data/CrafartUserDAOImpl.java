/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.CrafartUserDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CrafartUserDAO;

/**
 * @author Karthi
 * 
 */
@Repository("crafartUserDAOImpl")
public class CrafartUserDAOImpl implements CrafartUserDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCrafartUser(CrafartUserDO crafartUserDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(crafartUserDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding CrafartUser details in table", hExp);
		}
	}

}
