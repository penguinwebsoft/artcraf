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
@Table(name = "LENGTH_CLASS")
public class LengthClassDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3843184233068803901L;

	@Id
	@Column(name = "length_class_id")
	@SequenceGenerator(name = "seq_lengthclass", sequenceName = "seq_lengthclass", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lengthclass")
	private long lengthClassId;

	@Column(name = "title")
	private String title;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "sort_order")
	private Integer sortorder;

	@Column(name = "unit")
	private String unit;

	public long getLengthClassId() {
		return lengthClassId;
	}

	public void setLengthClassId(long lengthClassId) {
		this.lengthClassId = lengthClassId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}
}