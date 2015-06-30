/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageGeoZoneService {

	public void addGeoZoneDetail(GeoZoneBO geoZoneBO) throws CrafartServiceException;

	public List<GeoZoneBO> getGeoZoneDetail() throws CrafartServiceException;
}
