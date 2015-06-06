/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.SeoDAO;

/**
 * @author Karthi
 *
 */
@Repository("SeoDAOImpl")
public class SeoDAOImpl implements SeoDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeo(SeoDO seoDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.save(seoDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while addind in SEO table", hExp);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
