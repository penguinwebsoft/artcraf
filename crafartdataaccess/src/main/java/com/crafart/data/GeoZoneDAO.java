/**
 * 
 */
package com.crafart.data;

import java.util.List;

import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface GeoZoneDAO {

	public void addGeoZoneDetail(GeoZoneDO geoZoneDO) throws CrafartDataException;

	public List<GeoZoneDO> getGeoZoneDetail() throws CrafartDataException;
}
