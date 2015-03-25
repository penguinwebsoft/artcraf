/**
 * 
 */
package com.crafart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.GeoZoneDAO;
import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.GeoZoneBO;
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
	 * addGeoZoneDetail() will add details to the database by using
	 * {@link GeoZoneDAO} addGeoZoneDetail()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addGeoZoneDetail(GeoZoneBO geoZoneBO) throws CrafartDataException {
		GeoZoneDO geoZoneDO = beanMapper.mapGeoZoneBOToDO(geoZoneBO, new GeoZoneDO());
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
		} catch (CrafartDataException e) {
			e.printStackTrace();
		}
	}

	/**
	 * getGeoZoneDetail() will get all information from table using
	 * {@link GeoZoneDAO} getGeoZoneDetail()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<GeoZoneBO> getGeoZoneDetail() throws CrafartDataException {
		List<GeoZoneBO> geoZoneBOs = new ArrayList<>();
		try {
			List<GeoZoneDO> geoZoneDOs = geoZoneDAOImpl.getGeoZoneDetail();
			for (GeoZoneDO geoZoneDO : geoZoneDOs) {
				GeoZoneBO geoZoneBO = beanMapper.mapGeoZoneDOToBO(geoZoneDO, new GeoZoneBO());
				geoZoneBOs.add(geoZoneBO);
			}
		} catch (CrafartDataException e) {
			e.printStackTrace();
		}
		return geoZoneBOs;
	}

}
