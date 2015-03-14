/**
 * 
 */
package com.crafart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crafart.data.AddressDAO;
import com.crafart.dataobjects.AddressDO;
import com.crafart.exception.CrafartDataException;
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
	public void addAddress(AddressBO addressBO) throws CrafartServiceException {

		AddressDO addressDO = beanMapper.mapAddressBOToDO(addressBO, new AddressDO(), null);
		try {
			addressDAOImpl.addAddress(addressDO);
			addressBO.setAddressId(addressDO.getAddressId());
		} catch (CrafartDataException crafartDataException) {
			crafartDataException.printStackTrace();
		}
	}

}
