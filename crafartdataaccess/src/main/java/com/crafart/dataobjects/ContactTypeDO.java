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
@Table(name = "CONTACT_TYPE")
public class ContactTypeDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5309238181445343524L;
	
	@Id
	@Column(name = "contact_type_id")
	private long contactTypeId;

	@Column(name = "contact_type")
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
