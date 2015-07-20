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
@Table(name = "INFORMATION")
public class InformationDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2915519088075708109L;

	@Id
	@Column(name = "information_id")
	@SequenceGenerator(name = "seq_information", sequenceName = "seq_information", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_information")
	private long informationId;

	@Column(name = "information_title")
	private String informationTitle;

	@Column(name = "description")
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seo_id", nullable = true)
	private SeoDO seoDO;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "sort_order")
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

	public SeoDO getSeoDO() {
		return seoDO;
	}

	public void setSeoDO(SeoDO seoDO) {
		this.seoDO = seoDO;
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