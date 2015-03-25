/**
 * 
 */
package com.crafart.service;

import java.util.List;

import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.GeoZoneBO;

/**
 * @author Karthi
 * 
 */
public interface ManageGeoZoneService {

	public void addGeoZoneDetail(GeoZoneBO geoZoneBO) throws CrafartDataException;

	public List<GeoZoneBO> getGeoZoneDetail() throws CrafartDataException;
}
