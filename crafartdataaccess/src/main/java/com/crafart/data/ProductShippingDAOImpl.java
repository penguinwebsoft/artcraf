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

import com.crafart.dataobjects.ProductShippingDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductShippingDAO;

/**
 * @author Karthi
 * 
 */
@Repository("productShippingDAOImpl")
public class ProductShippingDAOImpl extends CommonDAOImpl implements ProductShippingDAO {



	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProductShipping(List<ProductShippingDO> productShippingDOs) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			for (ProductShippingDO productShippingDO : productShippingDOs) {
				session.persist(productShippingDO);
			}
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while adding to DB", hExp);
		}
	}

}
