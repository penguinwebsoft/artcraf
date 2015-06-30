/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;

 
public interface BannerGroupDAO {

	public void addBannerGroupDetail(BannerGroupDO bannerGroupDO) throws CrafartDataException;

	public List<BannerGroupDO> getBannerGroupDetail() throws CrafartDataException;
}
