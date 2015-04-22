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

import com.crafart.dataobjects.TaxRuleDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.TaxRuleDAO;

/**
 * @author Karthi
 * 
 */
@Repository("taxRuleDAOImpl")
public class TaxRuleDAOImpl implements TaxRuleDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaxRule(List<TaxRuleDO> taxRuleDOs) throws CrafartDataException {

		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			for (TaxRuleDO taxRuleDO : taxRuleDOs) {
				session.persist(taxRuleDO);
			}
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while adding tax rule n db", hExp);
		}

	}

}
