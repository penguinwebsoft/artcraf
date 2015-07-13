/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;

 
public interface BannerGroupDAO {

	public void addBannerGroup(BannerGroupDO bannerGroupDO) throws CrafartDataException;

	public List<BannerGroupDO> getBannerGroups() throws CrafartDataException;
	
	public BannerGroupDO getBannerGroupDO(long bannerGroupId) throws CrafartDataException;

	public void updateBannerGroup(BannerGroupDO bannerGroupDO) throws CrafartDataException;

}
