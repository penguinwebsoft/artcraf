package com.crafart.service.businessobjects;

import java.io.Serializable;

public class ProductReviewBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2137634215837690217L;

	private long productReviewId;

	private ProductBO productBO;

	private CustomerBO customerBO;

	private String authour;

	private String text;

	private int rating;

	private int status;

	public long getProductReviewId() {
		return productReviewId;
	}

	public void setProductReviewId(long productReviewId) {
		this.productReviewId = productReviewId;
	}

	public ProductBO getProductBO() {
		return productBO;
	}

	public void setProductBO(ProductBO productBO) {
		this.productBO = productBO;
	}

	public CustomerBO getCustomerBO() {
		return customerBO;
	}

	public void setCustomerBO(CustomerBO customerBO) {
		this.customerBO = customerBO;
	}

	public String getAuthour() {
		return authour;
	}

	public void setAuthour(String authour) {
		this.authour = authour;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
