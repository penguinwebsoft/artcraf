/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author
 * 
 */
public class InformationBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647978542496012178L;

	private long informationId;
	
	private String informationTitle;
	
	private String description;
	
	private SeoBO seoBO;
	
	private int isActive;
	
	private Integer sortOrder;

	public long getInformationId() {
		return informationId;
	}

	public void setInformationId(long informationId) {
		this.informationId = informationId;
	}

	public String getInformationTitle() {
		return informationTitle;
	}

	public void setInformationTitle(String informationTitle) {
		this.informationTitle = informationTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SeoBO getSeoBO() {
		return seoBO;
	}

	public void setSeoBO(SeoBO seoBO) {
		this.seoBO = seoBO;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}
