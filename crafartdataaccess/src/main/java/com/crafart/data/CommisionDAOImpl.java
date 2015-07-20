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

import com.crafart.dataobjects.CommisionDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;

/**
 * @author Karthi
 * 
 */
@Repository("commissionDAOImpl")
public class CommisionDAOImpl extends CommonDAOImpl implements CommissionDAO {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCommision(CommisionDO commisionDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(commisionDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding commission detail", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CommisionDO> getCommisions() throws CrafartDataException {
		List<CommisionDO> commissionDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			commissionDOs = session.createQuery("from CommisionDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving details from commission table", hExp);
		}
		return commissionDOs;
	}

	/**
	 * Retrieve commission data for identifier {@link Long} commisionId
	 * @return {@link CommisionDO}
	 * @throws CrafartDataException
	 */
	@Override
	public CommisionDO getCommision(long commisionId) throws CrafartDataException {
		CommisionDO commisionDO = (CommisionDO) this.getSessionFactory().getCurrentSession().get(CommisionDO.class, commisionId);
		return commisionDO;
	}

}
