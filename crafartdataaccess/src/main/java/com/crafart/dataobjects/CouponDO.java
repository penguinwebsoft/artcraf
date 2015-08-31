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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Deepam
 *
 */
@Entity
@Table(name = "discount")
public class CouponDO implements Serializable, Cloneable {
	/**
	 * serial id
	 */
	private static final long serialVersionUID = 2915519088075708109L;
	
	@Id
	@Column(name = "discount_Id")
	@SequenceGenerator(name = "seq_discount", sequenceName = "seq_discount", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_discount")
	private long discountId;
	
	@Column(name="CODE")
	private int code;

	@Column(name = "TYPE")
	private int type;

	@Column(name = "VALUE")
	private Integer value;

	@Column(name = "USES_PER_COUPON")
	private Integer usesPerCoupon;

	@Column(name = "USES_PER_CUSTOMER")
	private Integer usesPerCustomer;

	@Column(name = "START_DATE")
	private String startDate;

	@Column(name = "END_DATE")
	private String endDate;

	@Column(name = "STATUS")
	private int status;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(long discountId) {
		this.discountId = discountId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getUsesPerCoupon() {
		return usesPerCoupon;
	}

	public void setUsesPerCoupon(Integer usesPerCoupon) {
		this.usesPerCoupon = usesPerCoupon;
	}

	public Integer getUsesPerCustomer() {
		return usesPerCustomer;
	}

	public void setUsesPerCustomer(Integer usesPerCustomer) {
		this.usesPerCustomer = usesPerCustomer;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}




	
}