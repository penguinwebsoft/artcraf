/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class LengthClassBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1514782769886640135L;

	private long lengthClassId;

	private String title;
	
	private String unit;

	private Integer isActive;
	
	private Integer sortorder;
	
	

	public long getLengthClassId() {
		return lengthClassId;
	}

	public void setLengthClassId(long lengthClassId) {
		this.lengthClassId = lengthClassId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getSortorder() {
		return sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

}
