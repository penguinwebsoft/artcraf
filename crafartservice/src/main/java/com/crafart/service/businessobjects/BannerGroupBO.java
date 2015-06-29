/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

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

	public long getBannerGroupId() {
		return bannerGroupId;
	}

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
