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
 * @author 
 * 
 */
@Repository("informationDAOImpl")
public class InformationDAOImpl extends CommonDAOImpl implements InformationDAO {


	/**
	 * adding informationDetail details to information table by addGeoZoneDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addInformationDetail(InformationDO informationDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(informationDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding information details in table", hExp);
		}
	}
	
	
	
	
  @Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<InformationDO> getInformationDetail() throws CrafartDataException {
		List<InformationDO> informationDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			informationDOs = session.createQuery("from InformationDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving Information details", hExp);
		}
		return informationDOs;
	}

}
