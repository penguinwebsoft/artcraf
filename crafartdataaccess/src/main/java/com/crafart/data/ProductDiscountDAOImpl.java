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

import com.crafart.dataobjects.ProductDiscountDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductDiscountDAO;

/**
 * @author Karthi
 * 
 */
@Repository("productDiscountDAOImpl")
public class ProductDiscountDAOImpl extends CommonDAOImpl implements ProductDiscountDAO {


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProductDiscount(List<ProductDiscountDO> productDiscountDOs) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			for (ProductDiscountDO productDiscountDO : productDiscountDOs) {
				session.persist(productDiscountDO);
			}
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while adding product discount ", hExp);
		}
	}

}
