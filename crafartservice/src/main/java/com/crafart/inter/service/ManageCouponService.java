package com.crafart.inter.service;

import java.util.Map;

import com.crafart.service.businessobjects.CouponBO;

import com.crafart.service.exception.CrafartServiceException;

public interface ManageCouponService {
	public void addCoupon(CouponBO couponBO)throws CrafartServiceException;
	public void updateCoupon(CouponBO couponBO) throws CrafartServiceException;
	public Map<Long, CouponBO> getCoupons() throws CrafartServiceException;

}
