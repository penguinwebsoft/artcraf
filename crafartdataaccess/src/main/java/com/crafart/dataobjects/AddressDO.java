/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "ADDRESS")
public class AddressDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3536569824542091062L;

	@Id
	@Column(name = "address_id")
	@SequenceGenerator(name = "seq_address", sequenceName = "seq_address", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
	private long addressId;

	@ManyToMany(mappedBy = "addressDOs")
	private Set<SellerDO> sellerDOs = new HashSet<>();

	public Set<SellerDO> getSellerDOs() {
		return sellerDOs;
	}

	public void setSellerDOs(Set<SellerDO> sellerDOs) {
		this.sellerDOs = sellerDOs;
	}

	@Column(name = "street")
	private String street;

	@Column(name = "state_Id")
	private long stateId;

	@Column(name = "city_Id")
	private long cityId;

	@Column(name = "pin_code")
	private String pinCode;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
