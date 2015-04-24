/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private List<SellerDO> sellerDOs = new ArrayList<>();

	@ManyToMany(mappedBy = "contactDOs")
	private List<CustomerDO> customerDOs = new ArrayList<>();

	@Column(name = "street")
	private String street;

	@Column(name = "state_Id")
	private long stateId;

	@Column(name = "city_Id")
	private long cityId;

	@Column(name = "pin_code")
	private String pinCode;

	public List<SellerDO> getSellerDOs() {
		return sellerDOs;
	}

	public void setSellerDOs(List<SellerDO> sellerDOs) {
		this.sellerDOs = sellerDOs;
	}

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

	public List<CustomerDO> getCustomerDOs() {
		return customerDOs;
	}

	public void setCustomerDOs(List<CustomerDO> customerDOs) {
		this.customerDOs = customerDOs;
	}

}
