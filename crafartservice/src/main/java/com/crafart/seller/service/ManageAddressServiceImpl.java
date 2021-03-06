/**
 * 
 */
package com.crafart.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AddressDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AddressDAO;
import com.crafart.inter.service.ManageAddressService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("ManageAddressServiceImpl")
public class ManageAddressServiceImpl implements ManageAddressService {

	@Autowired
	private AddressDAO addressDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addAddress(AddressBO addressBO) throws CrafartServiceException {

		AddressDO addressDO = beanMapper.mapAddressBOToDO(addressBO, new AddressDO(), null, null);
		try {
			addressDAOImpl.addAddress(addressDO);
			addressBO.setAddressId(addressDO.getAddressId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding address" + addressBO.getAddressId());
		}
	}

}
