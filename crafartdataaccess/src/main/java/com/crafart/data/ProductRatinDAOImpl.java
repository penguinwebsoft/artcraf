/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ProductRatingDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductRatingDAO;

/**
 * @author Karthi
 * 
 */
@Repository("productRatinDAOImpl")
public class ProductRatinDAOImpl extends CommonDAOImpl implements ProductRatingDAO {


	@Override
	public void addProductRating(ProductRatingDO productRatingDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(productRatingDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding Rating in table", hExp);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProductRatingDO> getProductRating(long customerId) throws CrafartDataException {
		List<ProductRatingDO> productRatingDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from ProductRatingDO where customer_id = :customer_id");
			query.setLong("customer_id", customerId);
			productRatingDOs = (List<ProductRatingDO>) query.list();
		} catch (EmptyResultDataAccessException hExp) {
			return null;
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving product ratings details", hExp);
		}
		return productRatingDOs;
	}

}
