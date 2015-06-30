/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageBannerService {

	public void addBannerDetail(BannerBO bannerBO) throws CrafartServiceException;

	public List<BannerBO> getBannerDetail() throws CrafartServiceException;
}
