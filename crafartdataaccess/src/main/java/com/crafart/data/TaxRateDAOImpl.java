/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
public class TaxRateDAOImpl extends CommonDAOImpl implements TaxRateDAO {



	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaxRate(TaxRateDO taxRateDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(taxRateDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding tax rate details", hExp);
		}

	}
}
