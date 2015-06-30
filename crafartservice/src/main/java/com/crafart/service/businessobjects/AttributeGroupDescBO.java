/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class AttributeGroupDescBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8851709913179818276L;

	private long atrributeGroupDescId;

	private String attributeGroupName;

	private int sortOrder;

	public long getAtrributeGroupDescId() {
		return atrributeGroupDescId;
	}

	public void setAtrributeGroupDescId(long atrributeGroupDescId) {
		this.atrributeGroupDescId = atrributeGroupDescId;
	}

	public String getAttributeGroupName() {
		return attributeGroupName;
	}

	public void setAttributeGroupName(String attributeGroupName) {
		this.attributeGroupName = attributeGroupName;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}
