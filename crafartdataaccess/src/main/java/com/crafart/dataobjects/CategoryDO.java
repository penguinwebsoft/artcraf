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
@Table(name = "CATEGORY")
public class CategoryDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -870423497459160593L;

	@Id
	@Column(name = "category_id")
	@SequenceGenerator(name = "seq_category", sequenceName = "seq_category", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
	private long categoryId;

	@Column(name = "image_location")
	private String imageLocation;

	@Column(name = "category_column")
	private long categoryColumn;

	@Column(name = "parent_id")
	private long parentId;

	@Column(name = "sort_order")
	private int sortOrder;

	@Column(name = "status")
	private int status;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public long getCategoryColumn() {
		return categoryColumn;
	}

	public void setCategoryColumn(long categoryColumn) {
		this.categoryColumn = categoryColumn;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
