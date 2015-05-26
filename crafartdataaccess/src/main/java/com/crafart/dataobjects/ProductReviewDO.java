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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "PRODUCT_REVIEW")
public class ProductReviewDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2594825885264135840L;

	@Id
	@Column(name = "product_review_id")
	@SequenceGenerator(name = "seq_review", sequenceName = "seq_review", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_review")
	private long productReviewId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductDO productDO;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerDO customerDO;

	@Column(name = "authour")
	private String authour;

	@Column(name = "text")
	private String text;

	@Column(name = "rating")
	private int rating;

	@Column(name = "status")
	private int status;

	public long getProductReviewId() {
		return productReviewId;
	}

	public void setProductReviewId(long productReviewId) {
		this.productReviewId = productReviewId;
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

	public String getAuthour() {
		return authour;
	}

	public void setAuthour(String authour) {
		this.authour = authour;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
