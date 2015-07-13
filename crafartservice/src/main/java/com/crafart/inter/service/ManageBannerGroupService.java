/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.BannerGroupBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageBannerGroupService {

	public void addBannerGroup(BannerGroupBO bannerGroupBO) throws CrafartServiceException;

	public void updateBannerGroup(BannerGroupBO bannerGroupBO) throws CrafartServiceException;
	
	public void getBannerGroup(long bannerGroupId) throws CrafartServiceException;
	
	public Map<Long, BannerGroupBO> getBannerGroups() throws CrafartServiceException;
}
