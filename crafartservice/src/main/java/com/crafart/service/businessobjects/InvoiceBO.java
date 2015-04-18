/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class InvoiceBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5846091378731715516L;

	private long invoiceId;

	private String invoiceNo;

	private char invoicePrefix;

	private CustomerBO customerBO;

	private SellerBO sellerBO;

	private String invoiceDate;

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public char getInvoicePrefix() {
		return invoicePrefix;
	}

	public void setInvoicePrefix(char invoicePrefix) {
		this.invoicePrefix = invoicePrefix;
	}

	public CustomerBO getCustomerBO() {
		return customerBO;
	}

	public void setCustomerBO(CustomerBO customerBO) {
		this.customerBO = customerBO;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public SellerBO getSellerBO() {
		return sellerBO;
	}

	public void setSellerBO(SellerBO sellerBO) {
		this.sellerBO = sellerBO;
	}

}
