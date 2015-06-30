/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class OrderStatusBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647978542496012178L;

	private long orderStatusId;

	private String orderStatusTitle;
	
	private String orderStatusSubject;

	private String description;
	
	private int sortOrder;

	public long getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatusTitle() {
		return orderStatusTitle;
	}

	public void setOrderStatusTitle(String orderStatusTitle) {
		this.orderStatusTitle = orderStatusTitle;
	}

	public String getOrderStatusSubject() {
		return orderStatusSubject;
	}

	public void setOrderStatusSubject(String orderStatusSubject) {
		this.orderStatusSubject = orderStatusSubject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	
	}
	
