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
@Table(name = "CRAFART_ORDER")
public class CrafartOrderDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1285692975898471062L;

	@Id
	@Column(name = "order_id")
	@SequenceGenerator(name = "seq_order", sequenceName = "seq_order", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order")
	private long orderId;

	@OneToOne
	@JoinColumn(name = "invoice_id", nullable = false)
	private InvoiceDO invoiceDO;

	@OneToOne
	@JoinColumn(name = "store_id", nullable = false)
	private StoreDO storeDO;

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductDO productDO;

	@OneToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerDO customerDO;

	@OneToOne
	@JoinColumn(name = "courier_id", nullable = false)
	private CourierDO courierDO;

	@OneToOne
	@JoinColumn(name = "tax_rate_id", nullable = false)
	private TaxRateDO taxRateDO;

	@OneToOne
	@JoinColumn(name = "currency_id", nullable = false)
	private CurrencyDO currencyDO;

	@OneToOne
	@JoinColumn(name = "commision_id", nullable = false)
	private CommisionDO commisionDO;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private CrafartUserDO crafartUserDO;

	@Column(name = "comment")
	private String comment;

	@Column(name = "total")
	private float total;

	@Column(name = "oreder_status_id")
	private int orderStatusId;

	@Column(name = "order_ip")
	private String orderIp;

	@Column(name = "forwarded_ip")
	private String forwardedIp;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public InvoiceDO getInvoiceDO() {
		return invoiceDO;
	}

	public void setInvoiceDO(InvoiceDO invoiceDO) {
		this.invoiceDO = invoiceDO;
	}

	public StoreDO getStoreDO() {
		return storeDO;
	}

	public void setStoreDO(StoreDO storeDO) {
		this.storeDO = storeDO;
	}

	public ProductDO getProductDO() {
		return productDO;
	}

	public void setProductDO(ProductDO productDO) {
		this.productDO = productDO;
	}

	public CustomerDO getCustomerDO() {
		return customerDO;
	}

	public void setCustomerDO(CustomerDO customerDO) {
		this.customerDO = customerDO;
	}

	public CourierDO getCourierDO() {
		return courierDO;
	}

	public void setCourierDO(CourierDO courierDO) {
		this.courierDO = courierDO;
	}

	public TaxRateDO getTaxRateDO() {
		return taxRateDO;
	}

	public void setTaxRateDO(TaxRateDO taxRateDO) {
		this.taxRateDO = taxRateDO;
	}

	public CurrencyDO getCurrencyDO() {
		return currencyDO;
	}

	public void setCurrencyDO(CurrencyDO currencyDO) {
		this.currencyDO = currencyDO;
	}

	public CommisionDO getCommisionDO() {
		return commisionDO;
	}

	public void setCommisionDO(CommisionDO commisionDO) {
		this.commisionDO = commisionDO;
	}

	public CrafartUserDO getCrafartUserDO() {
		return crafartUserDO;
	}

	public void setCrafartUserDO(CrafartUserDO crafartUserDO) {
		this.crafartUserDO = crafartUserDO;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderIp() {
		return orderIp;
	}

	public void setOrderIp(String orderIp) {
		this.orderIp = orderIp;
	}

	public String getForwardedIp() {
		return forwardedIp;
	}

	public void setForwardedIp(String forwardedIp) {
		this.forwardedIp = forwardedIp;
	}

}
