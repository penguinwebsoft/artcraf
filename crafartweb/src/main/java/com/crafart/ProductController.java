/**
 * 
 */
package com.crafart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.inter.service.ManageProductRatingService;
import com.crafart.inter.service.ManageProductReviewService;
import com.crafart.inter.service.ManageProductService;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductReviewBO;
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

	@Autowired
	private ManageProductReviewService manageProductReviewServiceImpl;

	@Autowired
	private ManageProductRatingService manageProductRatingServiceImpl;

	@RequestMapping("/addProduct")
	public @ResponseBody
	long addProduct(@RequestBody ProductBO productBO, HttpServletRequest httpServletRequest, HttpSession httpSession) {
		try {
			SellerBO sellerBO = (SellerBO) httpSession.getAttribute("sellerprofile");
			productBO.setSellerBO(sellerBO);
			manageProductServiceImpl.addProduct(productBO);
		} catch (CrafartServiceException serviceException) {
			log.error("Application-error while adding product for product_id " + productBO.getProductId(), serviceException);
		}
		return productBO.getProductId();
	}

	@RequestMapping("/getProductDetails")
	public @ResponseBody
	ModelMap getProductDetails(@RequestParam(value = "productId") long productId, HttpSession httpSession) {
		ModelMap modelMap = new ModelMap();
		try {
			ProductBO productBO = manageProductServiceImpl.getProductDetail(productId);
			modelMap.addAttribute("productBO", productBO);
		} catch (CrafartServiceException csExp) {
			log.error("Application-error while gettting product details", csExp);
		} catch (Exception exp) {
			log.error("Exception while getting product details");
		}
		return modelMap;
	}

	@RequestMapping("/getProductReviewDetails")
	public @ResponseBody
	ModelMap getProductReviewDetails(@RequestParam(value = "productId") long productId, HttpSession httpSession) {
		ModelMap modelMap = new ModelMap();
		try {
			List<ProductReviewBO> productReviewBOs = manageProductReviewServiceImpl.getSingleProductReviews(productId);
			modelMap.addAttribute("productReviewBOs", productReviewBOs);
		} catch (CrafartServiceException csExp) {
			log.error("Application-error while getting single product review", csExp);
		} catch (Exception exp) {
			log.error("Eception while geting product review");
		}
		return modelMap;
	}

	@RequestMapping("/getAllProduct")
	public @ResponseBody
	ModelMap getAllProduct(HttpSession httpSession) {
		ModelMap modelMap = new ModelMap();
		try {
			List<ProductBO> productBOs = manageProductServiceImpl.getAllProduct();
			modelMap.addAttribute("productBOs", productBOs);
		} catch (CrafartServiceException csExp) {
			log.error("Application-error while getting all product", csExp);
		} catch (Exception exp) {
			log.error("Exception occured in getting products list");
		}
		return modelMap;

	}
}
