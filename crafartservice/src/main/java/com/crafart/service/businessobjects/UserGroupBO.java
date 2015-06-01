/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Deepam
 *
 */
public class UserGroupBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5564652466043833768L;

	private long userGroupId;

	private String name;

	private String permission;

	public long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
