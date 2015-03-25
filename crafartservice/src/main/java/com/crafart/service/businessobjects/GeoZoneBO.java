/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class GeoZoneBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647978542496012178L;

	private long geoZoneId;

	private String name;

	private String description;

	public long getGeoZoneId() {
		return geoZoneId;
	}

	public void setGeoZoneId(long geoZoneId) {
		this.geoZoneId = geoZoneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
