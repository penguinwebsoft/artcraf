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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "INVOICE")
public class InvoiceDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3656486193071968233L;

	@Id
	@Column(name = "invoice_id")
	@SequenceGenerator(name = "seq_invoice", sequenceName = "seq_invoice", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_invoice")
	private long invoiceId;

	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "invoice_prefix")
	private char invoicePrefix;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerDO customerDO;

	@OneToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private SellerDO sellerDO;

	@Column(name = "invoice_date")
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

	public CustomerDO getCustomerDO() {
		return customerDO;
	}

	public void setCustomerDO(CustomerDO customerDO) {
		this.customerDO = customerDO;
	}

	public SellerDO getSellerDO() {
		return sellerDO;
	}

	public void setSellerDO(SellerDO sellerDO) {
		this.sellerDO = sellerDO;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
}
