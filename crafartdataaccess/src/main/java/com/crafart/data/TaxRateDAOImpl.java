/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.TaxRateDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.TaxRateDAO;

/**
 * @author Karthi
 * 
 */
@Repository("taxRateDAOImpl")
public class TaxRateDAOImpl implements TaxRateDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaxRate(TaxRateDO taxRateDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(taxRateDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding tax rate details", hExp);
		}

	}
}
