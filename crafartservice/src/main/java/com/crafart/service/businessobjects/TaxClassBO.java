/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class TaxClassBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5616751248850306851L;

	private long taxClassId;

	private String title;

	private String description;
	
	private int sortOrder;
    
	private String isActive;
	public long getTaxClassId() {
		return taxClassId;
	}

	public void setTaxClassId(long taxClassId) {
		this.taxClassId = taxClassId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}



}
