/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageBannerService {

	public void addBanner(BannerBO bannerBO) throws CrafartServiceException;

	public void updateBanner(BannerBO bannerBO) throws CrafartServiceException;

	public Map<Long, BannerBO> getBanners() throws CrafartServiceException;
}
