/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ProductAttributeDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductAttributeDAO;

/**
 * @author Karthi
 * 
 */
@Repository("productAttributeDAOImpl")
public class ProductAttributeDAOImpl extends CommonDAOImpl implements ProductAttributeDAO {


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProductAttribute(List<ProductAttributeDO> productAttributeDOs) throws CrafartDataException {
		List<ProductAttributeDO> productAttributeDOs2 = productAttributeDOs;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			for (ProductAttributeDO productAttributeDO : productAttributeDOs2) {
				session.persist(productAttributeDO);
			}
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding product-attribute", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProductAttributeDO> getProductAttribute(long productId) throws CrafartDataException {
		List<ProductAttributeDO> productAttributeDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from ProductAttributeDO where product_id = :product_id");
			query.setLong("product_id", productId);
			productAttributeDOs = query.list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while retriving data from product_attribute", hExp);
		}
		return productAttributeDOs;
	}
}
