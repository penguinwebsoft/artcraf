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

import com.crafart.dataobjects.InformationDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.InformationDAO;

/**
 * data layer which manages information data
 * 
 * @author
 * 
 */
@Repository("informationDAOImpl")
public class InformationDAOImpl extends CommonDAOImpl implements InformationDAO {

	/**
	 * Get information object for identifier {@link Long} informationId
	 * 
	 * @return {@link InformationDO}
	 * @throws CrafartDataException
	 */
	@Override
	public InformationDO getInformation(long inforamtionId) throws CrafartDataException {
		InformationDO informationDO = (InformationDO) this.getSessionFactory().getCurrentSession().get(InformationDO.class, inforamtionId);
		return informationDO;
	}

	/**
	 * adding informationDetail details to information table by
	 * addGeoZoneDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addInformation(InformationDO informationDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(informationDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding information details", hExp);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<InformationDO> getInformations() throws CrafartDataException {
		List<InformationDO> informationDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			informationDOs = session.createQuery("from InformationDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving Information details", hExp);
		}
		return informationDOs;
	}

	/**
	 * updates information data for an identifier information id
	 * @param informationDO
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateInformation(InformationDO informationDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(informationDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while updating information details for information id =" + informationDO.getInformationId(), hExp);
		}
	}

}
