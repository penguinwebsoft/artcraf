/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class SeoDAOImpl extends CommonDAOImpl implements SeoDAO {


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeo(SeoDO seoDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(seoDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while addind in SEO table", hExp);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	@Override
	public void updateSeo(SeoDO seoDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.update(seoDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while addind in SEO table", hExp);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
	}

}
