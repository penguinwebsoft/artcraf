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

	private long sellerId;

	private String name;

	private String storeUrl;

	private String store_Description;

	private String store_Return;

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

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

	public String getStore_Description() {
		return store_Description;
	}

	public void setStore_Description(String store_Description) {
		this.store_Description = store_Description;
	}

	public String getStore_Return() {
		return store_Return;
	}

	public void setStore_Return(String store_Return) {
		this.store_Return = store_Return;
	}

}
