/**
 * 
 */
package com.crafart;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.service.ManageProductService;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Controller("productController")
@RequestMapping("product")
public class ProductController {

	private static final Logger log = Logger.getLogger(SellerController.class);

	@Autowired
	private ManageProductService manageProductServiceImpl;

	@RequestMapping("/addProduct")
	public @ResponseBody
	long addProduct(ProductBO productBO) {
		try {
			manageProductServiceImpl.addProduct(productBO);
		} catch (CrafartServiceException serviceException) {
			log.error("Error while adding product for product_id " + productBO.getProductId(), serviceException);
		}
		return productBO.getProductId();
	}
}
