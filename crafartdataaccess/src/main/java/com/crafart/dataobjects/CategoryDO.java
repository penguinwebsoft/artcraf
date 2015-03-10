/**
 * 
 */
package com.crafart.dataobjects;

/**
 * @author Karthi
 * 
 */
public class CategoryDO {

	private long categoryId;

	private String imageLocation;

	private long categoryColumn;

	private long parentId;

	private int sortOrder;

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
