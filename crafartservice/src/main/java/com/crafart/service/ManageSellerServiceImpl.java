/**
 * 
 */
package com.crafart.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.SellerDAO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.ManageSellerService;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Service("manageSellerServiceImpl")
public class ManageSellerServiceImpl implements ManageSellerService {

	private static final Logger log = Logger.getLogger(ManageSellerServiceImpl.class);

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeller(SellerBO sellerBO) throws CrafartServiceException {

		try {
			SellerDO sellerDO = beanMapper.mapSellerBOToDO(sellerBO, new SellerDO());
			sellerDAOImpl.addSeller(sellerDO);
			sellerBO.setSellerId(sellerDO.getSellerId());
		} catch (CrafartDataException uExp) {
			throw new CrafartServiceException("add new seller failed", uExp);
		}
	}

}
