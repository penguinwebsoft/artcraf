/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.UserGroupDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author 
 *
 */
@Repository("UserGroupDAO")
public interface UserGroupDAO {

	public void addUserGroup(UserGroupDO userGroupDO) throws CrafartDataException;

	public List<UserGroupDO> getUserGroupDetail() throws CrafartDataException;

}
