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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "PRODUCT_SHIPPING")
public class ProductShippingDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5472019204436005603L;

	@Id
	@Column(name = "product_shipping_id")
	@SequenceGenerator(name = "seq_productshipping", sequenceName = "seq_productshipping", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_productshipping")
	private long productShippingId;

	@Column(name = "shipping_rate")
	private float shippingRate;

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductDO productDO;

	@Column(name = "courier_id")
	private long courierId;

	@Column(name = "geo_zone_id")
	private long geoZoneId;

	public long getProductShippingId() {
		return productShippingId;
	}

	public void setProductShippingId(long productShippingId) {
		this.productShippingId = productShippingId;
	}

	public float getShippingRate() {
		return shippingRate;
	}

	public void setShippingRate(float shippingRate) {
		this.shippingRate = shippingRate;
	}

	public ProductDO getProductDO() {
		return productDO;
	}

	public void setProductDO(ProductDO productDO) {
		this.productDO = productDO;
	}

	public long getCourierId() {
		return courierId;
	}

	public void setCourierId(long courierId) {
		this.courierId = courierId;
	}

	public long getGeoZoneId() {
		return geoZoneId;
	}

	public void setGeoZoneId(long geoZoneId) {
		this.geoZoneId = geoZoneId;
	}
}
