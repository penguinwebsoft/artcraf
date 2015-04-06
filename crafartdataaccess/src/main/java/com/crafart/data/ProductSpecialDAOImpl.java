/**
 * 
 */
package com.crafart.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductSpecialDAOImpl implements ProductSpecialDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * adding list of product_special details to productSpecial Table
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProductSpecial(List<ProductSpecialDO> productSpecialDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			for (ProductSpecialDO productSpecialDO2 : productSpecialDO) {
				session.persist(productSpecialDO2);
			}
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error occured while adding productspecial", hExp);
		}

	}

}
