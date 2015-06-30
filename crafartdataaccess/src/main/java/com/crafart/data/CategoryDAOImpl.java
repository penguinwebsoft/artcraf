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

import com.crafart.dataobjects.CategoryDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CategoryDAO;

/**
 * @author Karthi
 * 
 */
@Repository("categoryDAOImpl")
public class CategoryDAOImpl extends CommonDAOImpl implements CategoryDAO {

	
	@Override
	public CategoryDO getCategoryeDO(long categoryId) throws CrafartDataException {
		Session session = this.getSessionFactory().getCurrentSession();
		CategoryDO categoryDO = (CategoryDO) session.get(CategoryDO.class, categoryId);
		return categoryDO;
	}
	
	/**
	 * getCategory() will get all details from Category table by createQery and
	 * storing it in list
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CategoryDO> getCategories() throws CrafartDataException {
		List<CategoryDO> categoryDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			categoryDOs = session.createQuery("from CategoryDO where parent_id=0").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving category details", hExp);
		}
		return categoryDOs;
	}

	/**
	 * fetch category do for category id passed from hibernate session
	 * 
	 * @return {@link CategoryDO}
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CategoryDO getCategory(long categoryId) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			CategoryDO categoryDO = (CategoryDO) session.get(CategoryDO.class, categoryId);
			return categoryDO;
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving category for category id - " + categoryId, hExp);
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCategory(CategoryDO categoryDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(categoryDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding category details", hExp);
		}
	}

	/**
	 * update category for identifier category.categoryId
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCategory(CategoryDO categoryDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(categoryDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding category details", hExp);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CategoryDO> getSubCategory(long categoryId) throws CrafartDataException {
		List<CategoryDO> categoryDOs = new ArrayList<CategoryDO>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from CategoryDO where parent_id = :parent_id");
			query.setLong("parent_id", categoryId);
			categoryDOs = (List<CategoryDO>) query.list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while fetching sub-category details", hExp);
		} catch (Exception exp) {
			exp.printStackTrace();
		}

		return categoryDOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CategoryDO> getAllSubCategories() throws CrafartDataException {
		List<CategoryDO> categoryDOs = new ArrayList<CategoryDO>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from CategoryDO where parent_id != :parent_id");
			query.setLong("parent_id", 0);
			categoryDOs = (List<CategoryDO>) query.list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while fetching sub-category details", hExp);
		} catch (Exception exp) {
			throw new CrafartDataException("DB Error while fetching sub-category details", exp);
		}

		return categoryDOs;
	}

}
