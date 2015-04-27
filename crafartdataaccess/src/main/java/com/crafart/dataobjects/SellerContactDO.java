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
@Table(name = "SELLER_CONTACT")
public class SellerContactDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196492356714062396L;

	@Id
	@Column(name = "seller_id")
	private long customerId;

	@Column(name = "contact_id")
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
