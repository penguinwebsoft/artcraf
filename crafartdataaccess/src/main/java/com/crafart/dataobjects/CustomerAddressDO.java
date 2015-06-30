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
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddressDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7160987099944327416L;

	@Id
	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "address_id")
	private long addressId;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

}
