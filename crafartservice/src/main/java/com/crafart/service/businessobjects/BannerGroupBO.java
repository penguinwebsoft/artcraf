/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Required;

/**
 * @author
 * 
 */
public class BannerGroupBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647978542496012178L;

	private long bannerGroupId;

	private String bannerGroupName;

	private String bannerSize;

	private int sortOrder;

	public BannerGroupBO() {
	}

	public BannerGroupBO(long bannerGroupId, String bannerGroupName, String bannerSize, int sortOrder) {
		this.bannerGroupId = bannerGroupId;
		this.bannerGroupName = bannerGroupName;
		this.bannerSize = bannerSize;
		this.sortOrder = sortOrder;

	}

	public long getBannerGroupId() {
		return bannerGroupId;
	}

	@Required
	public void setBannerGroupId(long bannerGroupId) {
		this.bannerGroupId = bannerGroupId;
	}

	public String getBannerGroupName() {
		return bannerGroupName;
	}

	public void setBannerGroupName(String bannerGroupName) {
		this.bannerGroupName = bannerGroupName;
	}

	public String getBannerSize() {
		return bannerSize;
	}

	public void setBannerSize(String bannerSize) {
		this.bannerSize = bannerSize;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}
