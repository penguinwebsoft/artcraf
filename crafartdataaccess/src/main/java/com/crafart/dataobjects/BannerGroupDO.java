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


@Entity
@Table(name = "BANNER_GROUP")
public class BannerGroupDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2915519088075708109L;

	@Id
	@Column(name = "banner_group_id")
	@SequenceGenerator(name = "seq_banner_group", sequenceName = "seq_banner_group", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_banner_group")
	private long bannerGroupId;

	@Column(name = "banner_group_name")
	private String bannerGroupName;

	@Column(name = "banner_size")   
	private String bannerSize;
	
	@Column(name = "sort_order")    
	private Integer sortOrder;

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

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	
	

	}