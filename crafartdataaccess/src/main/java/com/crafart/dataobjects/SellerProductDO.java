/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "SELLER_PRODUCT")
public class SellerProductDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8380474141516895950L;

	@Id
	@Column(name = "product_id")
	private long productId;

	@Column(name = "seller_id")
	private long sellerId;

	@Column(name = "sku")
	private String sku;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}
