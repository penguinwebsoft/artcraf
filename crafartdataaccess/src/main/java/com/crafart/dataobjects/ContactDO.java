/**
 * 
 */
package com.crafart.dataobjects;

/**
 * @author karthi
 * 
 */
public class ContactDO {

	private long contactId;

	private String contactType;

	private String contact_Value;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContact_Value() {
		return contact_Value;
	}

	public void setContact_Value(String contact_Value) {
		this.contact_Value = contact_Value;
	}

}
