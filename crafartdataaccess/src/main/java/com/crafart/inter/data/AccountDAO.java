/**
 * 
 */
package com.crafart.inter.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.AccountDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
@Repository("accountDAO")
public interface AccountDAO {

	public void addBankAccountDetail(AccountDO accountDO) throws CrafartDataException;
}
