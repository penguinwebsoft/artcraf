/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class ProductDescriptionBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2607635413627631416L;

	private long productDescriptionId;
	
	private ProductBO productBO;

	private String name;

	private String description;

	private String metaDescription;

	private String metaKeyword;

	private String tag;

	public long getProductDescriptionId() {
		return productDescriptionId;
	}

	public void setProductDescriptionId(long productDescriptionId) {
		this.productDescriptionId = productDescriptionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public ProductBO getProductBO() {
		return productBO;
	}

	public void setProductBO(ProductBO productBO) {
		this.productBO = productBO;
	}

}
