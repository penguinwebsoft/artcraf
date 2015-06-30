/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "CUSTOMER_CONTACT")
public class CustomerContactDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7746436154520961825L;

	@Id
	@Column(name = "customer_contact_id")
	@SequenceGenerator(name = "seq_customercontact", sequenceName = "seq_customercontact", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_customercontact")
	private long customerContactId;

	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "contact_id")
	private long contactId;

	public long getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(long customerContactId) {
		this.customerContactId = customerContactId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

}
