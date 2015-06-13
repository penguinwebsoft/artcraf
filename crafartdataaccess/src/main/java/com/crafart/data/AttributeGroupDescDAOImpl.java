/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeGroupDescDAO;

/**
 * @author Karthi
 * 
 */
@Repository("attributeGroupDescDAOImpl")
public class AttributeGroupDescDAOImpl extends CommonDAOImpl implements AttributeGroupDescDAO {


	/**
	 * Method to add attribute group description
	 */
	@Override
	public void addAttributeGroupDesc(AttributeGroupDescDO attributeGroupDescDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(attributeGroupDescDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding attributegroup", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttributeGroupDescDO> getAttributeGroupDesc() throws CrafartDataException {
		List<AttributeGroupDescDO> attributeGroupDescDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			attributeGroupDescDOs = session.createQuery("from AttributeGroupDescDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving data from attribute_group_desc", hExp);
		}
		return attributeGroupDescDOs;
	}

}
