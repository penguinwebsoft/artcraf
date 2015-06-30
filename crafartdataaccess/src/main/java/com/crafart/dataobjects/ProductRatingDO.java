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
@Table(name = "PRODUCT_RATING")
public class ProductRatingDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 701306116369825411L;

	@Id
	@Column(name = "product_rating_id")
	@SequenceGenerator(name = "seq_rating", sequenceName = "seq_rating", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rating")
	private long productRatingId;

	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductDO productDO;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerDO customerDO;

	@Column(name = "points")
	private int points;

	public long getProductRatingId() {
		return productRatingId;
	}

	public void setProductRatingId(long productRatingId) {
		this.productRatingId = productRatingId;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
