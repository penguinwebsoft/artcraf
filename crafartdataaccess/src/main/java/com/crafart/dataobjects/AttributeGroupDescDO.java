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
@Table(name = "ATTRIBUTE_GROUP_DESC")
public class AttributeGroupDescDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 932358113353471420L;

	@Id
	@Column(name = "attribute_group_id")
	@SequenceGenerator(name = "seq_attributegroupdesc", sequenceName = "seq_attributegroupdesc", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_attributegroupdesc")
	private long atrributeGroupDescId;

	@Column(name = "attribute_group_name")
	private String attributeGroupName;

	@Column(name = "sort_order")
	private int sortOrder;

	public long getAtrributeGroupDescId() {
		return atrributeGroupDescId;
	}

	public void setAtrributeGroupDescId(long atrributeGroupDescId) {
		this.atrributeGroupDescId = atrributeGroupDescId;
	}

	public String getAttributeGroupName() {
		return attributeGroupName;
	}

	public void setAttributeGroupName(String attributeGroupName) {
		this.attributeGroupName = attributeGroupName;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

}
