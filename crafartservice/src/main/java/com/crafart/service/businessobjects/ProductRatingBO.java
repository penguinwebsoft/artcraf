/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class ProductRatingBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3603635077947707590L;

	private long productRatingId;

	private ProductBO productBO;

	private CustomerBO customerBO;

	private int points;

	public long getProductRatingId() {
		return productRatingId;
	}

	public void setProductRatingId(long productRatingId) {
		this.productRatingId = productRatingId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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

}
