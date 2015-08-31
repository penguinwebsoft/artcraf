/**
 * 
 */
package com.crafart.service.businessobjects;
import java.io.Serializable;

/**
 * @author Deepam
 *
 */
public class CouponBO implements Serializable {

	

	
		private static final long serialVersionUID = 2647978542496012178L;

		private long discountId;
		
		private int code;

		private int type;

		private Integer value;
		
		private Integer usesPerCoupon;

		private Integer usesPerCustomer;
		
		private String startDate;
		
		private String endDate;

		private int status;
		
		public long getDiscountId() {
			return discountId;
		}

		public void setDiscountId(long discountId) {
			this.discountId = discountId;
		}
		
		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}


		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
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
			this.status= status;
		}



	}
