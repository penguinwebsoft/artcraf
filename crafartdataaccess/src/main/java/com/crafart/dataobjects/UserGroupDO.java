/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author karthi
 *
 */
@Entity
@Table(name = "USER_GROUP")
public class UserGroupDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7594360205189527334L;

	@Id
	@Column(name = "user_group_id")
	@SequenceGenerator(name = "seq_user_group", sequenceName = "seq_user_group", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_group")
	private long userGroupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "permission")
	private String permission;
	@Column(name = "sort_order")
	private Integer sortOrder;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "userGroupDO", cascade = CascadeType.ALL)
	private List<CrafartUserDO> crafartUserDOs = new ArrayList<>();

	public long getUserGroupId() {
		return userGroupId;
	}

	public List<CrafartUserDO> getCrafartUserDOs() {
		return crafartUserDOs;
	}

	public void setCrafartUserDOs(List<CrafartUserDO> crafartUserDOs) {
		this.crafartUserDOs = crafartUserDOs;
	}

	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}

	

	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	
}
