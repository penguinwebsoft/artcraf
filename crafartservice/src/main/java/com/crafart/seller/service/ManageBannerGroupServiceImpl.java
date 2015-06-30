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
	public void addBannerGroupDetail(BannerGroupBO bannerGroupBO) throws CrafartServiceException {
		BannerGroupDO bannerGroupDO = beanMapper.mapBannerGroupBOToDO(bannerGroupBO, new BannerGroupDO());
		try {
			bannerGroupDAOImpl.addBannerGroupDetail(bannerGroupDO);
			bannerGroupBO.setBannerGroupId(bannerGroupDO.getBannerGroupId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding bannerGroup", cdExp);
		}
	}

	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<BannerGroupBO> getBannerGroupDetail() throws CrafartServiceException {
		List<BannerGroupBO> bannerGroupBOs = new ArrayList<>();
		try {
			List<BannerGroupDO> bannerGroupDOs = bannerGroupDAOImpl.getBannerGroupDetail();
			for (BannerGroupDO bannerGroupDO : bannerGroupDOs) {
				BannerGroupBO bannerGroupBO = beanMapper.mapGeoZoneDOToBO(bannerGroupDO, new BannerGroupBO());
				bannerGroupBOs.add(bannerGroupBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriveing from DB", cdExp);
		}
		return bannerGroupBOs;
	}

}
