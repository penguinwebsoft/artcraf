package com.crafart.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * attribute table entity , which holds sub category attributes
 * @author p.periyasamy
 * @version 1.0
 */
@Entity
@Table(name = "ATTRIBUTE")
public class AttributeDO implements Cloneable, Serializable {

	/**
	 * serial id
	 */
	private static final long serialVersionUID = -8629832877426207073L;

	
	@Id
	@Column(name = "attribute_id")
	@SequenceGenerator(name = "seq_attribute", sequenceName = "seq_attribute", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_attribute")
	private long attributeId;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryDO categoryDO;

	@Column(name = "attribute_name")
	private String attributeName;

	@Column(name = "sort_order")
	private int sortOrder;

	public long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}


	public CategoryDO getCategoryDO() {
		return categoryDO;
	}

	public void setCategoryDO(CategoryDO categoryDO) {
		this.categoryDO = categoryDO;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}
