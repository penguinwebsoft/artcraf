/**
 * 
 */
package com.crafart.inter.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.UserGroupDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
@Repository("UserGroupDAO")
public interface UserGroupDAO {

	public void addUserGroup(UserGroupDO userGroupDO) throws CrafartDataException;

}
