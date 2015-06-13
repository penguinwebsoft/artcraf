/**
 * 
 */
package com.crafart.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.TaxRuleDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.TaxRuleDAO;

/**
 * @author Karthi
 * 
 */
@Repository("taxRuleDAOImpl")
public class TaxRuleDAOImpl extends CommonDAOImpl implements TaxRuleDAO {



	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaxRule(List<TaxRuleDO> taxRuleDOs) throws CrafartDataException {

		try {
			Session session = this.getSessionFactory().getCurrentSession();
			for (TaxRuleDO taxRuleDO : taxRuleDOs) {
				session.persist(taxRuleDO);
			}
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while adding tax rule n db", hExp);
		}

	}

}
