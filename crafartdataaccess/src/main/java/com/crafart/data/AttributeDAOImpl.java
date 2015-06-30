package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AttributeDO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeDAO;
import com.crafart.inter.data.CategoryDAO;

/**
 * Manage attributes which takes attribute entity object and persist into
 * hibernate session.
 * 
 * @author p.periyasamy
 *
 */
@Repository("attributeDAOImpl")
public class AttributeDAOImpl extends CommonDAOImpl implements AttributeDAO {

	private static final Logger log = Logger.getLogger(AttributeDAOImpl.class);
	
	@Autowired
	private CategoryDAO categoryDAOImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AttributeDO getAttributeDO(long attributeId) throws CrafartDataException {
		Session session = this.getSessionFactory().getCurrentSession();
		AttributeDO attributeDO = (AttributeDO) session.get(AttributeDO.class, attributeId);

		
		// remove category association
		/*CategoryDO categoryDO = attributeDO.getCategoryDOs().get(0);
		categoryDAOImpl.getCategory(categoryDO.getCategoryId());*/
		attributeDO.getCategoryDOs().remove(0);
		session.update(attributeDO);
		return attributeDO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addAttribute(AttributeDO attributeDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(attributeDO);
			CategoryDO categoryDO = attributeDO.getCategoryDOs().get(0);
			categoryDO = (CategoryDO) session.get(CategoryDO.class, categoryDO.getCategoryId());
			// creating bi directional relation ship between attribute -->
			// category table. (category --> attribute cause unidirectional
			// relation)
			List<AttributeDO> attributeDOs = categoryDO.getAttributeDOs();
			attributeDOs.add(attributeDO);
			categoryDO.setAttributeDOs(attributeDOs);
			session.save(categoryDO);
			log.info("added attribute for attribute name -" + attributeDO.getAttributeName());
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while adding attribute", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttributeDO> getAllAttributes() throws CrafartDataException {
		List<AttributeDO> attributeDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			attributeDOs = session.createQuery("from AttributeDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving data from attribute table", hExp);
		}
		return attributeDOs;

	}

	@Override
	public void updateAttribute(AttributeDO attributeDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			//CategoryDO subCategoryDO = attributeDO.getCategoryDOs().get(0);
			/*
			 * List<AttributeDO> attributeDOs = categoryDO.getAttributeDOs();
			 * AttributeDO toUpdateAttributeDO = attributeDOs.get(0);
			 * attributeDOs.add(attributeDO);
			 */
			// categoryDO.setAttributeDOs(attributeDOs);
			//
			session.save(attributeDO);
			CategoryDO categoryDO = attributeDO.getCategoryDOs().get(0);
			categoryDO = (CategoryDO) session.get(CategoryDO.class, categoryDO.getCategoryId());
			// creating bi directional relation ship between attribute -->
			// category table. (category --> attribute cause unidirectional
			// relation)
			List<AttributeDO> attributeDOs = categoryDO.getAttributeDOs();
			attributeDOs.add(attributeDO);
			categoryDO.setAttributeDOs(attributeDOs);
			
			session.save(categoryDO);
			log.info("updated attribute for attribute name -" + attributeDO.getAttributeId());
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while updating attribute for attribute id - " + attributeDO.getAttributeId(), hExp);
		}

	}

}
