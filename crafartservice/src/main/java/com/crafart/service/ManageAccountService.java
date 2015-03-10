/**
 * 
 */
package com.crafart.service;

import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
public interface ManageAccountService {

	public void addBankAccountDetail(AccountBO accountBO) throws CrafartServiceException;
}
