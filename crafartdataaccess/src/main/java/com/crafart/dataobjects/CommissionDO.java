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
 * @author Karthi
 *
 */
@Entity
@Table(name = "COMMISSION")
public class CommissionDO implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1508931011562716578L;
	
	@Id
	@Column(name = "commission_id")
	@SequenceGenerator(name = "seq_commission", sequenceName = "seq_commission", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_commission")
	private long commissionId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "value")
	private float value;
	
	@Column(name = "sort_order")
	private int sortOrder;

	public long getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(long commissionId) {
		this.commissionId = commissionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}
