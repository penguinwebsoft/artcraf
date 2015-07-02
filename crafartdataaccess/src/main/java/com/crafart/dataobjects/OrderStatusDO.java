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
 * @author 
 * 
 */
@Entity
@Table(name = "ORDER_STATUS")
public class OrderStatusDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2915519088075708109L;

	@Id
	@Column(name = "order_status_id")
	@SequenceGenerator(name = "seq_order_status", sequenceName = "seq_order_status", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order_status")
	private long orderStatusId;

	@Column(name = "order_status_title")
	private String orderStatusTitle;

	@Column(name = "order_status_subject")
	private String orderStatusSubject;
	
	@Column(name = "description")   
	private String description;
	
	@Column(name = "sort_order")    
	private Integer sortOrder;

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

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	

	}