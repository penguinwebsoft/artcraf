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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "PRODUCT_ATTRIBUTE")
public class ProductAttributeDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -958168780101325507L;

	@Id
	@Column(name = "attribute_id")
	@SequenceGenerator(name = "seq_productattribute", sequenceName = "seq_productattribute", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_productattribute")
	private long attributeId;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductDO productDO;

	@Column(name = "text")
	private String text;

	@Column(name = "attribute_group_id")
	private long attributeGroupId;

	@Column(name = "sort_order")
	private int sortOrder;

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public ProductDO getProductDO() {
		return productDO;
	}

	public long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}

	public void setProductDO(ProductDO productDO) {
		this.productDO = productDO;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getAttributeGroupId() {
		return attributeGroupId;
	}

	public void setAttributeGroupId(long attributeGroupId) {
		this.attributeGroupId = attributeGroupId;
	}
}
