package com.crafart.service;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */

@Service("manageSellerService")
public interface ManageSellerService {

	public void addSeller(SellerBO sellerBO) throws CrafartServiceException;
}
