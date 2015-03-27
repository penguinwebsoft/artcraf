/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author karthi
 * 
 */
public class ProductSpecialBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380158522586666335L;

	private long productSpecialId;

	private float price;

	private String startDate;

	private String endDate;

	private ProductBO productBO;

	private SellerBO sellerBO;

	public long getProductSpecialId() {
		return productSpecialId;
	}

	public void setProductSpecialId(long productSpecialId) {
		this.productSpecialId = productSpecialId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ProductBO getProductBO() {
		return productBO;
	}

	public void setProductBO(ProductBO productBO) {
		this.productBO = productBO;
	}

	public SellerBO getSellerBO() {
		return sellerBO;
	}

	public void setSellerBO(SellerBO sellerBO) {
		this.sellerBO = sellerBO;
	}

}
