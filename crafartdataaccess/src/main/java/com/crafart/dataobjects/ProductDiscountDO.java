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
@Table(name = "PRODUCT_DISCOUNT")
public class ProductDiscountDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6243149010595510147L;

	@Id
	@Column(name = "product_discount_id")
	@SequenceGenerator(name = "seq_productdiscount", sequenceName = "seq_productdiscount", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_productdiscount")
	private long productDiscountId;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductDO productDO;

	@Column(name = "seller_id")
	private long SellerId;

	public long getProductDiscountId() {
		return productDiscountId;
	}

	public void setProductDiscountId(long productDiscountId) {
		this.productDiscountId = productDiscountId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public ProductDO getProductDO() {
		return productDO;
	}

	public void setProductDO(ProductDO productDO) {
		this.productDO = productDO;
	}

	public long getSellerId() {
		return SellerId;
	}

	public void setSellerId(long sellerId) {
		SellerId = sellerId;
	}

}
