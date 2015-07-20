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

import com.crafart.dataobjects.BannerDO;
import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerDAO;
import com.crafart.inter.data.BannerGroupDAO;
import com.crafart.inter.service.ManageBannerService;
import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageBannerServiceImpl")
public class ManageBannerServiceImpl implements ManageBannerService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private BannerDAO bannerDAOImpl;

	@Autowired
	private BannerGroupDAO bannerGroupDAOImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBanner(BannerBO bannerBO) throws CrafartServiceException {
		BannerDO bannerDO = beanMapper.mapBannerBOToDO(bannerBO, new BannerDO());
		long bannerGroupId = bannerBO.getBannerGroupBO().getBannerGroupId();
		try {
			BannerGroupDO bannerGroupDO = bannerGroupDAOImpl.getBannerGroupDO(bannerGroupId);
			bannerDO.setBannerGroupDO(bannerGroupDO);
		} catch (CrafartDataException cExp) {
			throw new CrafartServiceException("Error while getting banner group for id = " + bannerGroupId, cExp);
		}
		try {
			bannerDAOImpl.addBanner(bannerDO);
			bannerBO.setBannerId(bannerDO.getBannerId());
		} catch (CrafartDataException csExp) {
			throw new CrafartServiceException("Error while adding banner", csExp);
		}
	}

	/**
	 * get all banners
	 * 
	 * @return {@link Map}
	 * @throws CrafartServiceException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, BannerBO> getBanners() throws CrafartServiceException {
		Map<Long, BannerBO> bannerBOs = new HashMap<>();
		try {
			List<BannerDO> bannerDOs = bannerDAOImpl.getBannerDetail();
			for (BannerDO bannerDO : bannerDOs) {
				BannerBO bannerBO = beanMapper.mapBannerDOToBO(bannerDO, new BannerBO());
				bannerBOs.put(bannerBO.getBannerId(), bannerBO);
			}
		} catch (CrafartDataException csExp) {
			throw new CrafartServiceException("Error while retriveing from DB", csExp);
		}
		return bannerBOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBanner(BannerBO bannerBO) throws CrafartServiceException {
		try {
			BannerDO bannerDO = bannerDAOImpl.getBannerDO(bannerBO.getBannerId());
			bannerDO = beanMapper.mapBannerBOToDO(bannerBO, bannerDO);
			long bannerGroupId = bannerBO.getBannerGroupBO().getBannerGroupId();
			try {
				BannerGroupDO bannerGroupDO = bannerGroupDAOImpl.getBannerGroupDO(bannerGroupId);
				bannerDO.setBannerGroupDO(bannerGroupDO);
			} catch (CrafartDataException cExp) {
				throw new CrafartServiceException("Error while getting banner group for id = " + bannerGroupId, cExp);
			}
			bannerDAOImpl.updateBanner(bannerDO);
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while updating banner for banner id = " + bannerBO.getBannerId(), cdExp);
		}

	}

}
