/**
 * 
 */
package com.crafart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.AddressDAO;
import com.crafart.data.SellerDAO;
import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Service("manageSellerServiceImpl")
public class ManageSellerServiceImpl implements ManageSellerService {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ManageSellerServiceImpl.class);

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private SellerDAO sellerDAOImpl;
	
	@Autowired
	private AddressDAO addressDAOImpl;

	/**
	 * mapping is done from BO to DO by mappSellerBOToDO method after mapping BO
	 * to DO we are calling dataaccess addSeller method using sellerDO
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addSeller(SellerBO sellerBO) throws CrafartServiceException {

		try {

			SellerDO sellerDO = beanMapper.mapSellerBOToDO(sellerBO, new SellerDO());
			AddressDO addressDO = beanMapper.mapAddressBOToDO(sellerBO.getAddressBO(), new AddressDO(), sellerDO);
			StoreDO storeDO = beanMapper.mapStoreBOToDO(sellerBO.getStoreBO(), new StoreDO(), sellerDO);
			// List<StoreDO> storeDOLst = new ArrayList<>();
			// sellerDO.setStoreDOs(storeDOs);
			sellerDO.setStoreDO(storeDO);
			List<AddressDO> addressDOs = new ArrayList<>();
			addressDOs.add(addressDO);
			sellerDO.setAddressDOs(addressDOs);
			sellerDAOImpl.addSeller(sellerDO);
			sellerBO.getStoreBO().setStoreId(sellerDO.getStoreDO().getStoreId());
			//assuming the seller having one address, hence getting first element from the address list
			sellerBO.getAddressBO().setAddressId(sellerDO.getAddressDOs().get(0).getAddressId());
			sellerBO.setSellerId(sellerDO.getSellerId());
		} catch (CrafartDataException uExp) {
			throw new CrafartServiceException("Adding new seller failed whose sellerid is ", uExp);
		}
	}

	/**
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSeller(SellerBO sellerBO) throws CrafartServiceException {

		try {

			SellerDO sellerDO = beanMapper.mapSellerBOToDO(sellerBO, new SellerDO());
			AddressDO addressDO = beanMapper.mapAddressBOToDO(sellerBO.getAddressBO(), new AddressDO(), sellerDO);
			StoreDO storeDO = beanMapper.mapStoreBOToDO(sellerBO.getStoreBO(), new StoreDO(), sellerDO);
			// List<StoreDO> storeDOLst = new ArrayList<>();
			// sellerDO.setStoreDOs(storeDOs);
			sellerDO.setStoreDO(storeDO);
			List<AddressDO> addressDOs = new ArrayList<>();
			addressDOs.add(addressDO);
			sellerDO.setAddressDOs(addressDOs);
			sellerDAOImpl.updateSeller(sellerDO);
			sellerBO.setSellerId(sellerDO.getSellerId());
		} catch (CrafartDataException uExp) {
			throw new CrafartServiceException("updating new seller failed from service is ", uExp);
		}
	}
}