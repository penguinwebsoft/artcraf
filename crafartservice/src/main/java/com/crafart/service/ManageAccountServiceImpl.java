/**
 * 
 */
package com.crafart.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.AccountDAO;
import com.crafart.dataobjects.AccountDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Service("ManageAccountService")
public class ManageAccountServiceImpl implements ManageAccountService {

	public static final Logger log = Logger.getLogger(ManageAccountServiceImpl.class);

	@Autowired
	private AccountDAO accountDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	/**
	 * mapping from BO to Do is done by mapAccountBOToDO(accountBO, new
	 * AccountDO()) calling dataaccess addBankAccountDetail method
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBankAccountDetail(AccountBO accountBO) throws CrafartServiceException {

		AccountDO accountDO = beanMapper.mapAccountBOToDO(accountBO, new AccountDO());
		try {
			accountDAOImpl.addBankAccountDetail(accountDO);
			accountBO.setAccountId(accountDO.getAccountId());
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Exception while adding AccountId" + accountBO.getAccountId());
		}
	}

}
