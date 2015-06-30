/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.BannerDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
@Repository("bannerDAO")
public interface BannerDAO {

	public void addBannerDetail(BannerDO bannerDO) throws CrafartDataException;

	public List<BannerDO> getBannerDetail() throws CrafartDataException;
}
