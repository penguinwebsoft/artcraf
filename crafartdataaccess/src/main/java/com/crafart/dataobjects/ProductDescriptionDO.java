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
@Table(name = "PRODUCT_DESCRIPTION")
public class ProductDescriptionDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6518789311819049853L;

	@Id
	@Column(name = "product_description_id")
	@SequenceGenerator(name = "seq_productdesc", sequenceName = "seq_productdesc", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_productdesc")
	private long productDescriptionId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "meta_description")
	private String metaDescription;

	@Column(name = "meta_keyword")
	private String metaKeyword;

	@Column(name = "tag")
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
