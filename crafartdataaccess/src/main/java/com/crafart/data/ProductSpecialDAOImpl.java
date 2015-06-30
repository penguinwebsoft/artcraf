/**
 * 
 */
package com.crafart.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ProductSpecialDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductSpecialDAO;

/**
 * @author Karthi
 * 
 */
@Repository("productSpecialDAOImpl")
public class ProductSpecialDAOImpl extends CommonDAOImpl implements ProductSpecialDAO {


	/**
	 * adding list of product_special details to productSpecial Table
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProductSpecial(List<ProductSpecialDO> productSpecialDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			for (ProductSpecialDO productSpecialDO2 : productSpecialDO) {
				session.persist(productSpecialDO2);
			}
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error occured while adding productspecial", hExp);
		}

	}

}
