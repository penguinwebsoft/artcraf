/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class ProductShippingBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2491490871364786209L;

	private long productShippingId;

	private float shippingRate;

	private ProductBO productBO;

	private long courierId;

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

	public ProductBO getProductBO() {
		return productBO;
	}

	public void setProductBO(ProductBO productBO) {
		this.productBO = productBO;
	}

}
