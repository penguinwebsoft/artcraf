package com.crafart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crafart.service.ManageSellerService;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.UserServiceException;

/**
 * Hello world!
 * 
 */
@Controller("sellerController")
@RequestMapping("seller")
public class SellerController {

	private static final Logger log = Logger.getLogger(SellerController.class);
	
	@Autowired
	private ManageSellerService manageSellerServiceImpl;
	
	@RequestMapping(value = {"/addSeller"}, method = RequestMethod.POST)
	public ModelAndView addSeller(@ModelAttribute("sellerBO")SellerBO sellerBO, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)  {
		try {
			manageSellerServiceImpl.addSeller(sellerBO);
		} catch (UserServiceException uExp) {
			log.info("Error while adding seller",uExp );
		}
		return null;
		
		
	}
}
