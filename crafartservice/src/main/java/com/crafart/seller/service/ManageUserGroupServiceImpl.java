/**
 * 
 */
package com.crafart.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.UserGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.UserGroupDAO;
import com.crafart.inter.service.ManageUserGroupService;
import com.crafart.service.businessobjects.UserGroupBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author 
 * 
 */
@Service("manageUserGroupServiceImpl")
public class ManageUserGroupServiceImpl implements ManageUserGroupService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private UserGroupDAO userGroupDAOImpl;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUserGroupDetail(UserGroupBO userGroupBO) throws CrafartServiceException {
		UserGroupDO userGroupDO = beanMapper.mapUserGroupBOToDO(userGroupBO, new UserGroupDO());
		try {
			userGroupDAOImpl.addUserGroup(userGroupDO);
			userGroupBO.setUserGroupId(userGroupDO.getUserGroupId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding geo zone", cdExp);
		}
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserGroupBO> getUserGroupDetail() throws CrafartServiceException {
		List<UserGroupBO> userGroupBOs = new ArrayList<>();
		try {
			List<UserGroupDO> userGroupDOs = userGroupDAOImpl.getUserGroupDetail();
			for (UserGroupDO userGroupDO : userGroupDOs) {
				UserGroupBO userGroupBO = beanMapper.mapUserGroupDOToBO(userGroupDO, new UserGroupBO());
				userGroupBOs.add(userGroupBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriveing from DB", cdExp);
		}
		return userGroupBOs;
	}

}
