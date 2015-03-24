/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CategoryDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 * 
 */
@Repository("categoryDAOImpl")
public class CategoryDAOImpl implements CategoryDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * getCategory() will get all details from Category table by createQery and
	 * storing it in list
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CategoryDO> getCategory() throws CrafartDataException {
		List<CategoryDO> categoryDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			categoryDOs = session.createQuery("from CategoryDO").list();
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			hExp.printStackTrace();
			throw new CrafartDataException("DB Error while reteriving category details", hExp);
		}
		return categoryDOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCategory(CategoryDO categoryDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(categoryDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			hExp.printStackTrace();
			throw new CrafartDataException("DB Error while adding category details", hExp);
		}
	}

}
