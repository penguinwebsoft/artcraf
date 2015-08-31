 /**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageGeoZoneService {

	public void addGeoZone(GeoZoneBO geoZoneBO) throws CrafartServiceException;

	public void updateGeoZone(GeoZoneBO geoZoneBO) throws CrafartServiceException;

	public Map<Long, GeoZoneBO> getGeoZones() throws CrafartServiceException;
}
