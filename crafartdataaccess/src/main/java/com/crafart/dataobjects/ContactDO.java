/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author karthi
 * 
 */
@Entity
@Table(name = "CONTACT")
public class ContactDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3665583120350528768L;

	@Id
	@Column(name = "contact_id")
	@SequenceGenerator(name = "seq_contact", sequenceName = "seq_contact", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contact")
	private long contactId;

	@Column(name = "contact_type_id")
	private long contactTypeId;

	@Column(name = "contact_value")
	private String contactValue;

	@ManyToMany(mappedBy = "contactDOs", fetch = FetchType.EAGER)
	private List<CustomerDO> customerDOs = new ArrayList<>();

	@ManyToMany(mappedBy = "contactDOs")
	private List<SellerDO> sellerDOs = new ArrayList<>();

	public List<SellerDO> getSellerDOs() {
		return sellerDOs;
	}

	public void setSellerDOs(List<SellerDO> sellerDOs) {
		this.sellerDOs = sellerDOs;
	}

	public List<CustomerDO> getCustomerDOs() {
		return customerDOs;
	}

	public void setCustomerDOs(List<CustomerDO> customerDOs) {
		this.customerDOs = customerDOs;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getContactValue() {
		return contactValue;
	}

	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	public long getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(long contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

}
