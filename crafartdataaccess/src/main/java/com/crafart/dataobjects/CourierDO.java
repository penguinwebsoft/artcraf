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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "product_limit")
	private int productLimit;
	
	@Column(name = "sort_order")
	private int sortOrder;

	public long getCourierId() {
		return courierId;
	}

	public void setCourierId(long courierId) {
		this.courierId = courierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProductLimit() {
		return productLimit;
	}

	public void setProductLimit(int productLimit) {
		this.productLimit = productLimit;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
}
