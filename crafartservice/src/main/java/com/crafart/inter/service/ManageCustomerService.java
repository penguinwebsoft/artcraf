/**
 * 
 */
package com.crafart.inter.service;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service("ManageCustomerService")
public interface ManageCustomerService {

	public void addCustomerDetail(CustomerBO customerBO) throws CrafartServiceException;

	public ContactBO findByEmailId(String eMailId) throws CrafartServiceException;

	public CustomerBO getCustomerDetails(long customerId) throws CrafartServiceException;

	public void updateCustomerDetail(CustomerBO customerBO) throws CrafartServiceException;

}
