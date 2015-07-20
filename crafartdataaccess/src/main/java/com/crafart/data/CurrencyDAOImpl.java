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

import com.crafart.dataobjects.CurrencyDO;
import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CurrencyDAO;

/**
 * @author Karthi
 * 
 */
@Repository("currencyDAOImpl")
public class CurrencyDAOImpl extends CommonDAOImpl implements CurrencyDAO {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCurrency(CurrencyDO currencyDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(currencyDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding Currency details in table", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CurrencyDO> getCurrencyDetail() throws CrafartDataException {
		List<CurrencyDO> currencyDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			currencyDOs = session.createQuery("from CurrencyDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving detail from DB", hExp);
		}
		return currencyDOs;
	}

	/**
	 * get geozone data object for identifier id {@link Long} geoZoneId
	 * 
	 * @param geoZoneId
	 * @return {@link GeoZoneDO}
	 */
	@Override
	public CurrencyDO getCurrency(long currenyId) throws CrafartDataException {
		CurrencyDO currencyDO = (CurrencyDO) this.getSessionFactory().getCurrentSession().get(CurrencyDO.class, currenyId);
		return currencyDO;
	}

}
