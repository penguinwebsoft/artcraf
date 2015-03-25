/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Deepam
 * 
 */
public class WeightClassBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7489843035954324601L;

	private long weightClassId;

	private float value;

	private double unit;

	private String title;

	public long getWeightClassId() {
		return weightClassId;
	}

	public void setWeightClassId(long weightClassId) {
		this.weightClassId = weightClassId;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
