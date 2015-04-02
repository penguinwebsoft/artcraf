/**
 * 
 */
package com.crafart.inter.service;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Service("ManageAccountService")
public interface ManageAccountService {

	public void addBankAccountDetail(AccountBO accountBO) throws CrafartServiceException;
}
