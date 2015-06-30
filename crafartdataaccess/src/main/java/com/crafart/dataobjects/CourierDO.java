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
 * @author Karthi
 *
 */
@Entity
@Table(name = "COURIER")
public class CourierDO implements Serializable,Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7728594258611347137L;

	@Id
	@Column(name = "courier_id")
	@SequenceGenerator(name = "seq_courier", sequenceName = "seq_courier", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_courier")
	private long courierId;

	@Column(name = "courier_name")
	private String courierName;

	@Column(name = "image")
	private String image;

	@Column(name = "estimated_delivery_time")
	private String estimatedDeliveryTime;

	@Column(name = "sort_order")
	private Integer sortOrder;

	public long getCourierId() {
		return courierId;
	}

	public void setCourierId(long courierId) {
		this.courierId = courierId;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEstimatedDeliveryTime() {
		return estimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
		this.estimatedDeliveryTime = estimatedDeliveryTime;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}