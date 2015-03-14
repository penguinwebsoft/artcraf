/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author karthi
 * @version 1.0
 * 
 */
public class StoreBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1697059816322625592L;

	private long storeId;

	private SellerBO sellerBO;

	private String name;

	private String storeUrl;

	private String storeDescription;

	private String storeReturn;

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	/*
	 * public long getSellerId() { return sellerId; }
	 * 
	 * public void setSellerId(long sellerId) { this.sellerId = sellerId; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public SellerBO getSellerBO() {
		return sellerBO;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}

	public String getStoreReturn() {
		return storeReturn;
	}

	public void setStoreReturn(String storeReturn) {
		this.storeReturn = storeReturn;
	}

	public void setSellerBO(SellerBO sellerBO) {
		this.sellerBO = sellerBO;
	}

}
