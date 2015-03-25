package com.crafart.service;

import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * 
 * @author karthi
 *
 */
public interface ManageAddressService {

	public void addAddress(AddressBO addressBO)throws CrafartServiceException;
}
