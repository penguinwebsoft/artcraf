/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeGroupDescDAO;

/**
 * @author Karthi
 * 
 */
@Repository("attributeGroupDescDAOImpl")
public class AttributeGroupDescDAOImpl implements AttributeGroupDescDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addAttributeGroupDesc(AttributeGroupDescDO attributeGroupDescDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(attributeGroupDescDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding attributegroup", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttributeGroupDescDO> getAttributeGroupDesc() throws CrafartDataException {
		List<AttributeGroupDescDO> attributeGroupDescDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			attributeGroupDescDOs = session.createQuery("from AttributeGroupDescDO").list();
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving data from attribute_group_desc", hExp);
		}
		return attributeGroupDescDOs;
	}

}
