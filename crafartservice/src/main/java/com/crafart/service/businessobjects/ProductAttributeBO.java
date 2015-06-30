/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class ProductAttributeBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 333478505619727072L;

	private long attributeId;

	private ProductBO productBO;

	private long attributeGroupId;

	private String text;

	private int sortOrder;

	public long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}

	public ProductBO getProductBO() {
		return productBO;
	}

	public void setProductBO(ProductBO productBO) {
		this.productBO = productBO;
	}

	public long getAttributeGroupId() {
		return attributeGroupId;
	}

	public void setAttributeGroupId(long attributeGroupId) {
		this.attributeGroupId = attributeGroupId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}
