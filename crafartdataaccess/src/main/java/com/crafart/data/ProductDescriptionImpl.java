/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductDescriptionDAO;

/**
 * @author Deepam
 *
 */
@Repository("productDescriptionImpl")
public class ProductDescriptionImpl extends CommonDAOImpl implements ProductDescriptionDAO{
	
	
	/**
	 * adding product description and seo details to table product_description
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addDescription(ProductDescriptionDO productDescriptionDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(productDescriptionDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding product description and seo details details", hExp);
		}
	}

}
