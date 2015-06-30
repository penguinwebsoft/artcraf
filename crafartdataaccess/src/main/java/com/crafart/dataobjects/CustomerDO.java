/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "CUSTOMER")
public class CustomerDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1064061202955515426L;

	@Id
	@Column(name = "customer_id")
	@SequenceGenerator(name = "seq_customer", sequenceName = "seq_customer", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_customer")
	private long customerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private int gender;

	@Column(name = "dob")
	private String dateOfBirth;

	@Column(name = "password")
	private String password;

	@Column(name = "ip")
	private String ip;

	@Column(name = "status")
	private int status;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "CUSTOMER_CONTACT", joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, inverseJoinColumns = { @JoinColumn(name = "CONTACT_ID") })
	private List<ContactDO> contactDOs = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "CUSTOMER_ADDRESS", joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	private List<AddressDO> addressDOs = new ArrayList<>();

	public List<AddressDO> getAddressDOs() {
		return addressDOs;
	}

	public void setAddressDOs(List<AddressDO> addressDOs) {
		this.addressDOs = addressDOs;
	}

	public List<ContactDO> getContactDOs() {
		return contactDOs;
	}

	public void setContactDOs(List<ContactDO> contactDOs) {
		this.contactDOs = contactDOs;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
