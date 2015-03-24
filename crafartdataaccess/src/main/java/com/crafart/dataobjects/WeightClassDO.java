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
 * @author Deepam
 *
 */
@Entity
@Table(name = "WEIGHT_CLASS")
public class WeightClassDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6812525102583993420L;

	@Id
	@Column(name = "weight_class_id")
	@SequenceGenerator(name = "seq_weightclass", sequenceName = "seq_weightclass", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_weightclass")
	private long weightClassId;
	
	@Column(name = "value")
	private float value;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "unit")
	private double unit;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getUnit() {
		return unit;
	}

	public void setUnit(double unit) {
		this.unit = unit;
	}
}
