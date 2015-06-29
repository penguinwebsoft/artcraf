/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.BannerGroupBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageBannerGroupService {

	public void addBannerGroupDetail(BannerGroupBO bannerGroupBO) throws CrafartServiceException;

	public List<BannerGroupBO> getBannerGroupDetail() throws CrafartServiceException;
}
