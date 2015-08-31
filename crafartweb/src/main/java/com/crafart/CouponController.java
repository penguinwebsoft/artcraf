/**
 * 
 */
package com.crafart;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crafart.inter.service.ManageCouponService;
import com.crafart.seller.service.ManageCouponServiceImpl;
import com.crafart.service.businessobjects.CouponBO;
import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.exception.CrafartServiceException;



/**
 * @author Deepam
 *
 */
@Controller("couponController")
@RequestMapping("coupon")
public class CouponController {
	
	
		private static final Logger log = Logger.getLogger(CouponController.class);

		@Autowired
		private ManageCouponService manageCouponServiceImpl;

		
	
		/**
		 * add coupon data
		 * @param CouponBO
		 * @param session
		 * @return {@link ModelMap}
		 */
		@RequestMapping(value = { "/addCoupon" }, method = RequestMethod.POST)
		public @ResponseBody ModelMap addCoupon(@RequestBody CouponBO CouponBO, HttpSession session) {
			ModelMap modelMap = new ModelMap();
			try {
				manageCouponServiceImpl.addCoupon(CouponBO);
				modelMap.addAttribute("couponBO", CouponBO);
				modelMap.addAttribute("result", true);
			} catch (CrafartServiceException crafartServiceException) {
				log.error("Application-error while adding to DB", crafartServiceException);
				modelMap.addAttribute("result", false);
			}
			return modelMap;
		}
		

		/**
		 * update couponBO
		 * @param session
		 * @return {@link ModelMap}
		 */
		@RequestMapping(value = { "/updateCoupon" }, method = RequestMethod.POST)
		public @ResponseBody ModelMap updateCoupon(@RequestBody CouponBO couponBO, HttpSession session) {
			ModelMap modelMap = new ModelMap();
			try {
				manageCouponServiceImpl.updateCoupon(couponBO);
				modelMap.addAttribute("result", true);
			} catch (CrafartServiceException crafartServiceException) {
				log.error("Application-error while updating length class data", crafartServiceException);
				modelMap.addAttribute("result", false);
			}
			return modelMap;
		}

		/**
		 * redirect to edit coupon view to update coupon data
		 * @param discountId
		 * @param session
		 * @return {@link ModelAndView}
		 */
		@RequestMapping(value = { "/editcoupon" }, method = RequestMethod.GET)
		public @ResponseBody ModelAndView editCoupon(@RequestParam(value = "discountId") long discountId, HttpSession session) {
			ModelMap modelMap = new ModelMap();
			@SuppressWarnings("unchecked")
			Map<Long, CouponBO> couponBOs = (Map<Long, CouponBO>) session.getAttribute("couponBOs");
			CouponBO couponBO = couponBOs.get(discountId);
			modelMap.addAttribute("couponBO", couponBO);
			return new ModelAndView("editCoupon", modelMap);
		}

}
