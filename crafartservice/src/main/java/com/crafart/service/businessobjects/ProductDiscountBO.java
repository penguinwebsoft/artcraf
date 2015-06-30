/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class ProductDiscountBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3082367956136474674L;

	private long productDiscountId;

	private int quantity;

	private float value;

	private String startDate;

	private String endDate;
	
	private String discountCode;

	private ProductBO productBO;

	private SellerBO sellerBO;

	public long getProductDiscountId() {
		return productDiscountId;
	}

	public void setProductDiscountId(long productDiscountId) {
		this.productDiscountId = productDiscountId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
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

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

}
