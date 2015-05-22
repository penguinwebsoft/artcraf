/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductAttributeDAOImpl implements ProductAttributeDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProductAttribute(List<ProductAttributeDO> productAttributeDOs) throws CrafartDataException {
		List<ProductAttributeDO> productAttributeDOs2 = productAttributeDOs;
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			for (ProductAttributeDO productAttributeDO : productAttributeDOs2) {
				session.persist(productAttributeDO);
			}
			session.getTransaction().commit();
			session.close();
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
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from ProductAttributeDO where product_id = :product_id");
			query.setLong("product_id", productId);
			productAttributeDOs = query.list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while retriving data from product_attribute", hExp);
		}
		return productAttributeDOs;
	}
}
