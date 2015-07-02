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
@Table(name = "TAX_CLASS")
public class TaxClassDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5937396232704434612L;

	@Id
	@Column(name = "tax_class_id")
	@SequenceGenerator(name = "seq_taxclass", sequenceName = "seq_taxclass", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_taxclass")
	private long taxClassId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "is_active")
	private Integer isActive;
	
	@Column(name = "sort_order")
	private Integer sortOrder;

	public long getTaxClassId() {
		return taxClassId;
	}

	public void setTaxClassId(long taxClassId) {
		this.taxClassId = taxClassId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}
