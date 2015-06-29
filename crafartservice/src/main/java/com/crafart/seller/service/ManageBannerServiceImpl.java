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

import com.crafart.dataobjects.BannerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerDAO;
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

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBannerDetail(BannerBO bannerBO) throws CrafartServiceException {
		BannerDO bannerDO = beanMapper.mapBannerBOToDO(bannerBO, new BannerDO());
		try {
			bannerDAOImpl.addBannerDetail(bannerDO);
			bannerBO.setBannerId(bannerDO.getBannerId());
		} catch (CrafartDataException csExp) {
			throw new CrafartServiceException("Error while adding banner", csExp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<BannerBO> getBannerDetail() throws CrafartServiceException {
		List<BannerBO> bannerBOs = new ArrayList<>();
		try {
			List<BannerDO> bannerDOs = bannerDAOImpl.getBannerDetail();
			for (BannerDO bannerDO : bannerDOs) {
				BannerBO bannerBO = beanMapper.mapBannerDOToBO(bannerDO, new BannerBO());
				bannerBOs.add(bannerBO);
			}
		} catch (CrafartDataException  csExp) {
			throw new CrafartServiceException("Error while retriveing from DB",  csExp);
		}
		return bannerBOs;
	}


	
	

}
