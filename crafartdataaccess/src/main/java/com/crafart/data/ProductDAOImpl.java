/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ProductDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductDAO;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("ProductDAOImpl")
public class ProductDAOImpl extends CommonDAOImpl implements ProductDAO {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ProductDAOImpl.class);

	
	/**
	 * adding product details to product table productId is generated by seq
	 * automatically
	 * 
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProduct(ProductDO productDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.saveOrUpdate(productDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while adding product ", hExp);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ProductDO getProductDetail(long productId) throws CrafartDataException {
		ProductDO productDO = new ProductDO();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from ProductDO where product_id = :product_id");
			query.setLong("product_id", productId);
			productDO = (ProductDO) query.uniqueResult();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving product details", hExp);
		}
		return productDO;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProductDO> getAllProduct() throws CrafartDataException {
		List<ProductDO> productDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			productDOs = session.createQuery("from ProductDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving courier details", hExp);
		}
		return productDOs;
	}

}
