/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import com.crafart.service.businessobjects.CrafartOrderBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageCrafartOrderService {

	public List<CrafartOrderBO> getCrafartOrder(SellerBO sellerBO) throws CrafartServiceException;

	public List<CrafartOrderBO> getCustomerOrder(long customerId) throws CrafartServiceException;

}
