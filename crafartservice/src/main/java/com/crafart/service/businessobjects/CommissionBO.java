/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class CommissionBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3431499249878702481L;

	private long commissionId;

	private String name;

	private String type;

	private float value;

	private int sortOrder;

	public long getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(long commissionId) {
		this.commissionId = commissionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}
