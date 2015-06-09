/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 *
 */
public class SeoBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8661188086860064096L;

	private long seo_id;

	private String metaTitle;

	private String metaDesc;

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
