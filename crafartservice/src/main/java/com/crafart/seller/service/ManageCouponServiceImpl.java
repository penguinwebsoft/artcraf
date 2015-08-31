/**
 * 
 */
package com.crafart.seller.service;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CouponDO;

import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CouponDAO;
import com.crafart.inter.data.GeoZoneDAO;
import com.crafart.inter.service.ManageCouponService;
import com.crafart.service.businessobjects.CouponBO;

import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;


/**
 * @author Deepam
 *
 */
@Service("ManageCouponServiceImpl")
public class ManageCouponServiceImpl implements ManageCouponService{

	
	

		@Autowired
		private BeanMapper beanMapper;

		@Autowired
		private CouponDAO couponDAOImpl;

		/**
		 * add coupon data to persistence, map business object to data object with
		 * identifier as empty or 0 incase of adding new coupon data. <li>
		 * incase of update, check whether {@link Long} couponId is greater than 0,
		 * if so call update method to update coupon for identifier {@link Long}
		 * couponId
		 * 
		 * @param couponBO
		 * @throws CrafartServiceException
		 */
		@Override
		@Transactional(propagation = Propagation.REQUIRED)
		public void addCoupon(CouponBO couponBO) throws CrafartServiceException {
			if (couponBO.getDiscountId() > 0) {
				updateCoupon(couponBO);
			} else {
				CouponDO couponDO = beanMapper.mapCouponBOToDO(couponBO, new CouponDO());
				try {
					couponDAOImpl.addCoupon(couponDO);
					couponBO.setDiscountId(couponDO.getDiscountId());
				} catch (CrafartDataException e) {
					throw new CrafartServiceException("Error while adding Coupon", e);
				}
			}
		}

		/**
		 * update coupon data for {@link Long} identifier discountID
		 * 
		 * @param couponBO
		 * @throws CrafartServiceException
		 */
		@Override
		@Transactional(propagation = Propagation.REQUIRED)
		public void updateCoupon(CouponBO couponBO) throws CrafartServiceException {
			CouponDO couponDO;
			try {
				couponDO = couponDAOImpl.getCoupon(couponBO.getDiscountId());
			} catch (CrafartDataException cDExp) {
				throw new CrafartServiceException("Coupon Update - Error while retrieving geozone data object for geozone id =  " + couponBO.getDiscountId(), cDExp);
			}
			couponDO = beanMapper.mapCouponBOToDO(couponBO, couponDO);
			try {
				couponDAOImpl.addCoupon(couponDO);
			} catch (CrafartDataException e) {
				throw new CrafartServiceException("Error while adding coupon", e);
			}
		}

		/**
		 * getGeoZones() will get all information from table using
		 * {@link GeoZoneDAO} getGeoZoneDetail()
		 */
		@Override
		@Transactional(propagation = Propagation.REQUIRED)
		public Map<Long, CouponBO> getCoupons() throws CrafartServiceException {
			Map<Long, CouponBO> couponBOs = new HashMap<>();
			try {
				List<CouponDO> couponDOs = couponDAOImpl.getCouponDetail();
				for (CouponDO couponDO : couponDOs) {
					CouponBO couponBO = beanMapper.mapCouponDOToBO(couponDO, new CouponBO());
					couponBOs.put(couponBO.getDiscountId(), couponBO);
				}
			} catch (CrafartDataException e) {
				throw new CrafartServiceException("Error while retriveing from DB", e);
			}
			return couponBOs;
		}}
		

		

	