/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.UserGroupBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@Service
public interface ManageUserGroupService {

	public void addUserGroupDetail(UserGroupBO userGroupBO) throws CrafartServiceException;

	public List<UserGroupBO> getUserGroupDetail() throws CrafartServiceException;
}
