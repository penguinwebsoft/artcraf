/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.CrafartUserDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CrafartUserDAO;

/**
 * @author Karthi
 * 
 */
@Repository("crafartUserDAOImpl")
public class CrafartUserDAOImpl extends CommonDAOImpl implements CrafartUserDAO {


	@Override
	public void addCrafartUser(CrafartUserDO crafartUserDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().openSession();
			session.beginTransaction();
			session.persist(crafartUserDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding CrafartUser details in table", hExp);
		}
	}

}
