/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.UserDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author 
 * 
 */
public interface UserDAO {

	public void addUserDetail(UserDO userDO) throws CrafartDataException;

	public List<UserDO> getUserDetail() throws CrafartDataException;
}
