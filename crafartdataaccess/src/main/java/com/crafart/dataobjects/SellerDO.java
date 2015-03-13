/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * seller entity data object maps to seller table in crafart database. Property
 * belongs to seller table and seller_id is primary key which is generated by db
 * sequence <blockquote>seq_seller<blockquote>
 * 
 * @author karthi
 * @version 1.0
 */
@Entity
@Table(name = "SELLER")
public class SellerDO implements Serializable, Cloneable {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = 2950842206999695829L;

	@Id
	@Column(name = "seller_id")
	@SequenceGenerator(name = "seq_seller", sequenceName = "seq_seller")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seller")
	private long sellerId;

	@OneToOne(mappedBy = "sellerDO", cascade = CascadeType.ALL)
	private StoreDO storeDO;

	@Column(name = "first_Name")
	private String firstName;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "SELLER_ADDRESS", joinColumns = { @JoinColumn(name = "SELLER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	private Set<AddressDO> addressDOs = new HashSet<AddressDO>();

	public Set<AddressDO> getAddressDOs() {
		return addressDOs;
	}

	public void setAddressDOs(Set<AddressDO> addressDOs) {
		this.addressDOs = addressDOs;
	}

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "gender")
	private int gender;

	@Column(name = "dob")
	private String dateOfBirth;

	private int tin_no;

	@Column(name = "company_Name")
	private String companyName;

	@Column(name = "company_Logo")
	private String companyLogo;

	private String epch_no;

	private String vat_no;

	private String cst_no;

	private String commission;

	private int status;

	private int approved;

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
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

	public int getTin_no() {
		return tin_no;
	}

	public void setTin_no(int tin_no) {
		this.tin_no = tin_no;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	public String getEpch_no() {
		return epch_no;
	}

	public void setEpch_no(String epch_no) {
		this.epch_no = epch_no;
	}

	public String getVat_no() {
		return vat_no;
	}

	public void setVat_no(String vat_no) {
		this.vat_no = vat_no;
	}

	public String getCst_no() {
		return cst_no;
	}

	public void setCst_no(String cst_no) {
		this.cst_no = cst_no;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public StoreDO getStoreDO() {
		return storeDO;
	}

	public void setStoreDO(StoreDO storeDO) {
		this.storeDO = storeDO;

	}

}