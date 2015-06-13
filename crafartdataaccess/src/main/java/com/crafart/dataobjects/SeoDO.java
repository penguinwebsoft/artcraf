package com.crafart.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "SEO")
public class SeoDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8735333863089991546L;

	@Id
	@Column(name = "seo_id")
	@SequenceGenerator(name = "seq_seo", sequenceName = "seq_seo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seo")
	private long seo_id;

	@Column(name = "meta_title")
	private String metaTitle;

	@Column(name = "meta_desc")
	private String metaDesc;

	@Column(name = "meta_keyword")
	private String metaKeyword;

	public long getSeo_id() {
		return seo_id;
	}

	public void setSeo_id(long seo_id) {
		this.seo_id = seo_id;
	}

	public String getMetaTitle() {
		return metaTitle;
	}

	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}

	public String getMetaDesc() {
		return metaDesc;
	}

	public void setMetaDesc(String metaDesc) {
		this.metaDesc = metaDesc;
	}

	public String getMetaKeyword() {
		return metaKeyword;
	}

	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}

}
