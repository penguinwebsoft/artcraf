/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CommissionDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;

/**
 * @author Karthi
 * 
 */
@Repository("commissionDAOImpl")
public class CommissionDAOImpl extends CommonDAOImpl implements CommissionDAO {


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCommission(CommissionDO commissionDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(commissionDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding commission detail", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CommissionDO> getCommission() throws CrafartDataException {
		List<CommissionDO> commissionDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			commissionDOs = session.createQuery("from CommissionDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving details from commission table", hExp);
		}
		return commissionDOs;
	}

}
