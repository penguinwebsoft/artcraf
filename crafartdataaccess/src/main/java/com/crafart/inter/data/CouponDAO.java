/**
 * 
 */
package com.crafart.inter.data;


import java.util.List;

import com.crafart.dataobjects.CouponDO;

import com.crafart.exception.CrafartDataException;


/**
 * @author Deepam
 *
 */

public interface CouponDAO {
	public CouponDO getCoupon(long CODE) throws CrafartDataException;
	public void addCoupon(CouponDO couponDO)throws CrafartDataException;
	public List<CouponDO> getCouponDetail() throws CrafartDataException;
}
