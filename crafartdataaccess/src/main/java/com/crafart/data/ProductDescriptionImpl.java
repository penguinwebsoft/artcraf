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

import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 *
 */
@Repository("productDescriptionImpl")
public class ProductDescriptionImpl implements ProductDescriptionDAO{
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * adding product description and seo details to table product_description
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addDescription(ProductDescriptionDO productDescriptionDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.save(productDescriptionDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding product description and seo details details", hExp);
		}
	}

}
