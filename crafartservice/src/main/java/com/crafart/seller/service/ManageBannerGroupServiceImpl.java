/**
 * 
 */
package com.crafart.seller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerGroupDAO;
import com.crafart.inter.service.ManageBannerGroupService;
import com.crafart.service.businessobjects.BannerGroupBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author
 * 
 */
@Service("manageBannerGroupServiceImpl")
public class ManageBannerGroupServiceImpl implements ManageBannerGroupService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private BannerGroupDAO bannerGroupDAOImpl;

	@Transactional(propagation = Propagation.REQUIRED)
	public void addBannerGroup(BannerGroupBO bannerGroupBO) throws CrafartServiceException {
		BannerGroupDO bannerGroupDO = beanMapper.mapBannerGroupBOToDO(bannerGroupBO, new BannerGroupDO());
		try {
			bannerGroupDAOImpl.addBannerGroup(bannerGroupDO);
			bannerGroupBO.setBannerGroupId(bannerGroupDO.getBannerGroupId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding bannerGroup", cdExp);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, BannerGroupBO> getBannerGroups() throws CrafartServiceException {
		Map<Long, BannerGroupBO> bannerGroupBOs = new HashMap<>();
		try {
			List<BannerGroupDO> bannerGroupDOs = bannerGroupDAOImpl.getBannerGroups();
			for (BannerGroupDO bannerGroupDO : bannerGroupDOs) {
				BannerGroupBO bannerGroupBO = beanMapper.mapBannerGroupDOToBO(bannerGroupDO);
				bannerGroupBOs.put(bannerGroupBO.getBannerGroupId(), bannerGroupBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriveing from DB", cdExp);
		}
		return bannerGroupBOs;
	}

	/**
	 * update banner group for an identifier
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateBannerGroup(BannerGroupBO bannerGroupBO) throws CrafartServiceException {
		try {
			BannerGroupDO bannerGroupDO = bannerGroupDAOImpl.getBannerGroupDO(bannerGroupBO.getBannerGroupId());
			bannerGroupDO = beanMapper.mapBannerGroupBOToDO(bannerGroupBO, bannerGroupDO);
			bannerGroupDAOImpl.updateBannerGroup(bannerGroupDO);
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while updating bannerGroup for bannergroup id = " + bannerGroupBO.getBannerGroupId(), cdExp);
		}

	}

	@Override
	public void getBannerGroup(long bannerGroupId) throws CrafartServiceException {
		try {
			bannerGroupDAOImpl.getBannerGroupDO(bannerGroupId);
		} catch (CrafartDataException cExp) {
			throw new CrafartServiceException("Error while retrieving banner group for id = " + bannerGroupId, cExp);
		}

	}

}
