/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class ContactBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5630094794801262495L;

	private long contactId;

	private long contactTypeId;

	private String contactValue;

	private CustomerBO customerBO;

	private SellerBO sellerBO;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public long getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(long contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public String getContactValue() {
		return contactValue;
	}

	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	public CustomerBO getCustomerBO() {
		return customerBO;
	}

	public void setCustomerBO(CustomerBO customerBO) {
		this.customerBO = customerBO;
	}

	public SellerBO getSellerBO() {
		return sellerBO;
	}

	public void setSellerBO(SellerBO sellerBO) {
		this.sellerBO = sellerBO;
	}

}
