/**
 * 
 */
package com.crafart.data;

import com.crafart.dataobjects.AccountDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface AccountDAO {

	public void addBankAccountDetail(AccountDO accountDO) throws CrafartDataException;
}
