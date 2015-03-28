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
@Table(name = "PRODUCT_SPECIAL")
public class ProductSpecialDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4407822888163597432L;

	@Id
	@Column(name = "product_special_id")
	@SequenceGenerator(name = "seq_productspecial", sequenceName = "seq_productspecial", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_productspecial")
	private long productSpecialId;

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

	public long getProductSpecialId() {
		return productSpecialId;
	}

	public void setProductSpecialId(long productSpecialId) {
		this.productSpecialId = productSpecialId;
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
