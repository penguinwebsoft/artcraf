/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author
 * 
 */
@Entity
@Table(name = "BANNER")
public class BannerDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -870423497459160593L;

	@Id
	@Column(name = "banner_id")
	@SequenceGenerator(name = "seq_banner", sequenceName = "seq_banner", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_banner")
	private long bannerId;
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "banner_group_id", nullable=false)
	private BannerGroupDO bannerGroupDO;

	@Column(name = "banner_name")
	private String bannerName;

	@Column(name = "banner_image")
	private String bannerImage;

	@Column(name = "banner_url")
	private String bannerUrl;

	@Column(name = "sort_order")
	private Integer sortOrder;
	
	

    public long getBannerId() {
		return bannerId;
	}

	public void setBannerId(long bannerId) {
		this.bannerId = bannerId;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}
	

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
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

	public BannerGroupDO getBannerGroupDO() {
		return bannerGroupDO;
	}

	public void setBannerGroupDO(BannerGroupDO bannerGroupDO) {
		this.bannerGroupDO = bannerGroupDO;
	}
	
}
