/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
public class SellerBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3856310385699735633L;

	private long sellerId;

	private String firstName;

	private String lastName;

	private String gender;

	private String dateOfBirth;

	private int tinNo;

	private String companyName;

	private String companyLogo;

	private String epchNo;

	private String vatNo;

	private String cstNo;

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

	public int getTinNo() {
		return tinNo;
	}

	public void setTinNo(int tin_no) {
		this.tinNo = tin_no;
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

	public String getEpchNo() {
		return epchNo;
	}

	public void setEpchNo(String epch_no) {
		this.epchNo = epch_no;
	}

	public String getVatNo() {
		return vatNo;
	}

	public void setVatNo(String vat_no) {
		this.vatNo = vat_no;
	}

	public String getCstNo() {
		return cstNo;
	}

	public void setCstNo(String cst_no) {
		this.cstNo = cst_no;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
