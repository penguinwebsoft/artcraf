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

import com.crafart.dataobjects.UserDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.UserDAO;
import com.crafart.inter.service.ManageUserService;
import com.crafart.service.businessobjects.UserBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author 
 * 
 */
@Service("manageUserServiceImpl")
public class ManageUserServiceImpl implements ManageUserService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private UserDAO userDAOImpl;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUserDetail(UserBO userBO) throws CrafartServiceException {
		UserDO userDO = beanMapper.mapUserBOToDO(userBO, new UserDO());
		try {
			userDAOImpl.addUserDetail(userDO);
			userBO.setUserId(userDO.getUserId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding userDetail", cdExp);
		}
	}

	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserBO> getUserDetail() throws CrafartServiceException {
		List<UserBO> userBOs = new ArrayList<>();
		try {
			List<UserDO> userDOs = userDAOImpl.getUserDetail();
			for (UserDO userDO : userDOs) {
				UserBO userBO = beanMapper.mapUserDOToBO(userDO, new UserBO());
				userBOs.add(userBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriveing from  user DB", cdExp);
		}
		return userBOs;
	}

}
