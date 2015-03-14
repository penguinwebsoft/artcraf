/**
 * 
 */
package com.crafart;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.service.ManageAddressService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Controller
@RequestMapping("address")
public class AddressController {

	public static final Logger log = Logger.getLogger(AddressController.class);

	@Autowired
	private ManageAddressService manageAddressServiceImpl;

	@RequestMapping(value = { "/addAddress" }, method = RequestMethod.POST)
	@ResponseBody
	public ModelMap addAddress(@RequestBody AddressBO addressBO, HttpServletRequest httpServletRequest) {
		ModelMap modelMap = new ModelMap();
		try {
			manageAddressServiceImpl.addAddress(addressBO);
		} catch (CrafartServiceException crafartServiceException) {
			log.error("Error while adding address detail from controller, AccoundId is " + addressBO.getAddressId(), crafartServiceException);
		}
		return modelMap;
	}
}
