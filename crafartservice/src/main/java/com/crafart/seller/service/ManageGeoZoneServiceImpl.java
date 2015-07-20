/**
 * 
 */
package com.crafart.seller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.GeoZoneDAO;
import com.crafart.inter.service.ManageGeoZoneService;
import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageGeoZoneServiceImpl")
public class ManageGeoZoneServiceImpl implements ManageGeoZoneService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private GeoZoneDAO geoZoneDAOImpl;

	/**
	 * add geozone data to persistence, map business object to data object with
	 * identifier as empty or 0 incase of adding new geozone data. <li>
	 * incase of update, check whether {@link Long} geoZoneId is greater than 0,
	 * if so call update method to update geoZone for identifier {@link Long}
	 * geoZoneId
	 * 
	 * @param geoZoneBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addGeoZone(GeoZoneBO geoZoneBO) throws CrafartServiceException {
		if (geoZoneBO.getGeoZoneId() > 0) {
			updateGeoZone(geoZoneBO);
		} else {
			GeoZoneDO geoZoneDO = beanMapper.mapGeoZoneBOToDO(geoZoneBO, new GeoZoneDO());
			try {
				geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
				geoZoneBO.setGeoZoneId(geoZoneDO.getGeoZoneId());
			} catch (CrafartDataException e) {
				throw new CrafartServiceException("Error while adding geo zone", e);
			}
		}
	}

	/**
	 * update geozone data for {@link Long} identifier geoZoneId
	 * 
	 * @param geoZoneBO
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateGeoZone(GeoZoneBO geoZoneBO) throws CrafartServiceException {
		GeoZoneDO geoZoneDO;
		try {
			geoZoneDO = geoZoneDAOImpl.getGeoZone(geoZoneBO.getGeoZoneId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Geozone Update - Error while retrieving geozone data object for geozone id =  " + geoZoneBO.getGeoZoneId(), cDExp);
		}
		geoZoneDO = beanMapper.mapGeoZoneBOToDO(geoZoneBO, geoZoneDO);
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("Error while adding geo zone", e);
		}
	}

	/**
	 * getGeoZones() will get all information from table using
	 * {@link GeoZoneDAO} getGeoZoneDetail()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, GeoZoneBO> getGeoZones() throws CrafartServiceException {
		Map<Long, GeoZoneBO> geoZoneBOs = new HashMap<>();
		try {
			List<GeoZoneDO> geoZoneDOs = geoZoneDAOImpl.getGeoZoneDetail();
			for (GeoZoneDO geoZoneDO : geoZoneDOs) {
				GeoZoneBO geoZoneBO = beanMapper.mapGeoZoneDOToBO(geoZoneDO, new GeoZoneBO());
				geoZoneBOs.put(geoZoneBO.getGeoZoneId(), geoZoneBO);
			}
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("Error while retriveing from DB", e);
		}
		return geoZoneBOs;
	}

}
