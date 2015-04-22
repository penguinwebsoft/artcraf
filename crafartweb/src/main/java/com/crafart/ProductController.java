/**
 * 
 */
package com.crafart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.inter.service.ManageProductService;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Controller("productController")
@RequestMapping("product")
public class ProductController {

	private static final Logger log = Logger.getLogger(ProductController.class);

	@Autowired
	private ManageProductService manageProductServiceImpl;

	@RequestMapping("/addProduct")
	public @ResponseBody
	long addProduct(@RequestBody ProductBO productBO, HttpServletRequest httpServletRequest, HttpSession httpSession) {
		try {
			SellerBO sellerBO = (SellerBO) httpSession.getAttribute("sellerprofile");
			productBO.setSellerId(sellerBO.getSellerId());
			manageProductServiceImpl.addProduct(productBO);
		} catch (CrafartServiceException serviceException) {
			log.error("Application-error while adding product for product_id " + productBO.getProductId(), serviceException);
		}
		return productBO.getProductId();
	}

}
