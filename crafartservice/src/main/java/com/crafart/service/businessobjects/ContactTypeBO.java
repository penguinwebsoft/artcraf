/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class ContactTypeBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6314336641592163127L;

	private long contactTypeId;

	private String contactType;

	public long getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(long contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

}
