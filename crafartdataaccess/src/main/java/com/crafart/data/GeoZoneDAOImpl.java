/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
@Repository("geoZoneDAOImpl")
public class GeoZoneDAOImpl implements GeoZoneDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * adding GeoZoneDetail details to geo_zone table by addGeoZoneDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addGeoZoneDetail(GeoZoneDO geoZoneDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(geoZoneDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			hExp.printStackTrace();
			throw new CrafartDataException("DB Error while adding geo zone details in table", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GeoZoneDO> getGeoZoneDetail() throws CrafartDataException {
		List<GeoZoneDO> geoZoneDOs = new ArrayList<>();
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			geoZoneDOs = session.createQuery("from GeoZoneDO").list();
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			hExp.printStackTrace();
			throw new CrafartDataException("DB Error while reteriving GeoZone details", hExp);
		}
		return geoZoneDOs;
	}

}
