/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class CrafartOrderBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8303517298384531391L;

	private long orderId;

	private InvoiceBO invoiceBO;

	private StoreBO storeBO;

	private ProductBO productBO;

	private CustomerBO customerBO;

	private CourierBO courierBO;

	private TaxRateBO taxRateBO;

	private CurrencyBO currencyBO;

	private CommisionBO commissionBO;

	private CrafartUserBO crafartUserBO;

	private String comment;

	private float total;

	private int orderStatusId;

	private String orderIp;

	private String forwardedIp;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public InvoiceBO getInvoiceBO() {
		return invoiceBO;
	}

	public void setInvoiceBO(InvoiceBO invoiceBO) {
		this.invoiceBO = invoiceBO;
	}

	public StoreBO getStoreBO() {
		return storeBO;
	}

	public void setStoreBO(StoreBO storeBO) {
		this.storeBO = storeBO;
	}

	public ProductBO getProductBO() {
		return productBO;
	}

	public void setProductBO(ProductBO productBO) {
		this.productBO = productBO;
	}

	public CustomerBO getCustomerBO() {
		return customerBO;
	}

	public void setCustomerBO(CustomerBO customerBO) {
		this.customerBO = customerBO;
	}

	public CourierBO getCourierBO() {
		return courierBO;
	}

	public void setCourierBO(CourierBO courierBO) {
		this.courierBO = courierBO;
	}

	public TaxRateBO getTaxRateBO() {
		return taxRateBO;
	}

	public void setTaxRateBO(TaxRateBO taxRateBO) {
		this.taxRateBO = taxRateBO;
	}

	public CurrencyBO getCurrencyBO() {
		return currencyBO;
	}

	public void setCurrencyBO(CurrencyBO currencyBO) {
		this.currencyBO = currencyBO;
	}

	public CommisionBO getCommissionBO() {
		return commissionBO;
	}

	public void setCommissionBO(CommisionBO commissionBO) {
		this.commissionBO = commissionBO;
	}

	public CrafartUserBO getCrafartUserBO() {
		return crafartUserBO;
	}

	public void setCrafartUserBO(CrafartUserBO crafartUserBO) {
		this.crafartUserBO = crafartUserBO;
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
