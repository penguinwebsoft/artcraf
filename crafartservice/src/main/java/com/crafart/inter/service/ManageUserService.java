/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.UserBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author
 * 
 */
@Service
public interface ManageUserService {

	public void addUserDetail(UserBO userBO) throws CrafartServiceException;

	public List<UserBO> getUserDetail() throws CrafartServiceException;
}
