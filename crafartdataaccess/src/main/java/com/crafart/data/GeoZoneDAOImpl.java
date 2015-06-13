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

import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.GeoZoneDAO;

/**
 * @author Karthi
 * 
 */
@Repository("geoZoneDAOImpl")
public class GeoZoneDAOImpl extends CommonDAOImpl implements GeoZoneDAO {


	/**
	 * adding GeoZoneDetail details to geo_zone table by addGeoZoneDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addGeoZoneDetail(GeoZoneDO geoZoneDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(geoZoneDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding geo zone details in table", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GeoZoneDO> getGeoZoneDetail() throws CrafartDataException {
		List<GeoZoneDO> geoZoneDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			geoZoneDOs = session.createQuery("from GeoZoneDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving GeoZone details", hExp);
		}
		return geoZoneDOs;
	}

}
