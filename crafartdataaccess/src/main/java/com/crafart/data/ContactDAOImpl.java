/**
 * 
 */
package com.crafart.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ContactDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ContactDAO;

/**
 * @author Karthi
 * 
 */
@Repository("contactDAOImpl")
public class ContactDAOImpl extends CommonDAOImpl implements ContactDAO {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addContact(List<ContactDO> contactDOs) throws CrafartDataException {
		List<ContactDO> contactDOs2 = contactDOs;
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			for (ContactDO contactDO : contactDOs2) {
				session.save(contactDO);
			}
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while adding list of contacts to contact table", hExp);
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ContactDO findByEmailId(String eMailId) throws CrafartDataException {
		ContactDO contactDO = new ContactDO();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from ContactDO where contact_value = :contact_value");
			query.setString("contact_value", eMailId);
			contactDO = (ContactDO) query.uniqueResult();
		} catch (EmptyResultDataAccessException hExp) {
			return null;
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while finding customer id", hExp);
		}
		return contactDO;
	}

}
