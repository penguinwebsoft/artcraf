/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Deepam
 * 
 */
@Entity
@Table(name = "GEO_ZONE")
public class GeoZoneDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2915519088075708109L;

	@Id
	@Column(name = "geo_zone_id")
	@SequenceGenerator(name = "seq_geozone", sequenceName = "seq_geozone", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_geozone")
	private long geoZoneId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
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
