/**
 * 
 */
package com.crafart.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.ContactDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ContactDAO;
import com.crafart.inter.data.CustomerDAO;
import com.crafart.inter.service.ManageCustomerService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("ManageCustomerServiceImpl")
public class ManageCustomerServiceImpl implements ManageCustomerService {

	@Autowired
	private CustomerDAO customerDAOImpl;

	@Autowired
	private ContactDAO contactDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addCustomerDetail(CustomerBO customerBO) throws CrafartServiceException {

		CustomerDO customerDO = beanMapper.mapCustomerBOToDO(customerBO, new CustomerDO());
		AddressBO addressBO = customerBO.getAddressBO();
		AddressDO addressDO = beanMapper.mapAddressBOToDO(addressBO, new AddressDO(), null, customerDO);
		List<AddressDO> addressDOs = new ArrayList<>();
		addressDOs.add(addressDO);
		customerDO.setAddressDOs(addressDOs);
		List<ContactBO> contactBOs = customerBO.getContactBOs();
		List<ContactDO> contactDOs = new ArrayList<>();
		for (ContactBO contactBO : contactBOs) {
			ContactDO contactDO = beanMapper.mapContactBOToDO(contactBO, new ContactDO(), customerDO, null);
			contactDOs.add(contactDO);
			customerDO.setContactDOs(contactDOs);
		}
		try {
			customerDAOImpl.addCustomer(customerDO);
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding customer detail", cdExp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ContactBO findByEmailId(String eMailId) throws CrafartServiceException {
		ContactBO contactBO = new ContactBO();
		try {
			ContactDO contactDO = contactDAOImpl.findByEmailId(eMailId);
			if (contactDO == null)
				return null;
			List<CustomerDO> customerDOs = contactDO.getCustomerDOs();
			CustomerBO customerBO = new CustomerBO();
			for (CustomerDO customerDO : customerDOs) {
				customerBO = beanMapper.mapCustomerDOToBO(customerDO, new CustomerBO());
			}
			contactBO = beanMapper.mapContactDOToBO(contactDO, new ContactBO(), customerBO, null);
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while Getting emailId", cdExp);
		}
		return contactBO;
	}

}
