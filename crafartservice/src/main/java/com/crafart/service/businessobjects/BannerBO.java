/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class BannerBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647978542496012178L;

	private long BannerId;

	private long BannerGroupId;

	private String BannerName;

	private String BannerImage;

	private String bannerUrl;

	private Integer sortOrder;

	public long getBannerId() {
		return BannerId;
	}

	public void setBannerId(long bannerId) {
		BannerId = bannerId;
	}

	public long getBannerGroupId() {
		return BannerGroupId;
	}

	public void setBannerGroupId(long bannerGroupId) {
		BannerGroupId = bannerGroupId;
	}

	public String getBannerImage() {
		return BannerImage;
	}

	public void setBannerImage(String bannerImage) {
		BannerImage = bannerImage;
	}

	public String getBannerName() {
		return BannerName;
	}

	public void setBannerName(String bannerName) {
		BannerName = bannerName;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}