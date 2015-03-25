/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
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
}
