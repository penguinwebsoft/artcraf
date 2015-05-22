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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ProductReviewDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductReviewDAO;

/**
 * @author Karthi
 * 
 */
@Repository("ProductReviewDAOImpl")
public class ProductReviewDAOImpl implements ProductReviewDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProductReview(ProductReviewDO productReviewDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(productReviewDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding product review details in table", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProductReviewDO> getProductReview(long customerId) throws CrafartDataException {
		List<ProductReviewDO> productReviewDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from ProductReviewDO where customer_id = :customer_id");
			query.setLong("customer_id", customerId);
			productReviewDOs = (List<ProductReviewDO>) query.list();
			session.getTransaction().commit();
			session.close();
		} catch (EmptyResultDataAccessException hExp) {
			return null;
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving product review details", hExp);
		}
		return productReviewDOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProductReviewDO> getSingleProductReviews(long productId) throws CrafartDataException {
		List<ProductReviewDO> productReviewDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("from ProductReviewDO where product_id = :product_id");
			query.setLong("product_id", productId);
			productReviewDOs = (List<ProductReviewDO>) query.list();
			session.getTransaction().commit();
			session.close();
		} catch (EmptyResultDataAccessException hExp) {
			return null;
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving product review details", hExp);
		}
		return productReviewDOs;
	}

}
