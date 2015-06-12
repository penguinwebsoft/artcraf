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
import com.crafart.inter.data.CrafartOrderDAO;
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
	private CrafartOrderDAO crafartOrderDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
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
			customerBO.setCustomerId(customerDO.getCustomerId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding customer detail", cdExp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ContactBO findByEmailId(String eMailId) throws CrafartServiceException {
		ContactBO contactBO = new ContactBO();
		try {
			ContactDO contactDO = contactDAOImpl.findByEmailId(eMailId);
			if (contactDO == null)
				return null;
			List<CustomerDO> customerDOs = contactDO.getCustomerDOs();
			CustomerBO customerBO = new CustomerBO();
			for (CustomerDO customerDO : customerDOs) {

				AddressBO addressBO = new AddressBO();
				for (AddressDO addressDO : customerDO.getAddressDOs()) {
					addressBO = beanMapper.mapAddressDOToBO(addressDO, new AddressBO());
				}

				List<ContactBO> contactBOs = new ArrayList<>();
				for (ContactDO contactDO2 : customerDO.getContactDOs()) {
					ContactBO contactBO2 = beanMapper.mapContactDOToBO(contactDO2, new ContactBO(), null, null);
					contactBOs.add(contactBO2);
				}

				customerBO = beanMapper.mapCustomerDOToBO(customerDO, new CustomerBO(), addressBO, contactBOs);
			}
			contactBO = beanMapper.mapContactDOToBO(contactDO, new ContactBO(), customerBO, null);
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while Getting emailId", cdExp);
		}
		return contactBO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public CustomerBO getCustomerDetails(long customerId) throws CrafartServiceException {
		CustomerBO customerBO = new CustomerBO();
		try {
			CustomerDO customerDO = customerDAOImpl.getCustomerDetails(customerId);
			AddressBO addressBO = new AddressBO();
			for (AddressDO addressDO2 : customerDO.getAddressDOs()) {
				addressBO = beanMapper.mapAddressDOToBO(addressDO2, new AddressBO());
			}
			List<ContactBO> contactBOs = new ArrayList<>();
			for (ContactDO contactDO : customerDO.getContactDOs()) {
				ContactBO contactBO = beanMapper.mapContactDOToBO(contactDO, new ContactBO(), null, null);
				contactBOs.add(contactBO);
			}
			customerBO = beanMapper.mapCustomerDOToBO(customerDO, new CustomerBO(), addressBO, contactBOs);
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriving customer details", cdExp);
		}
		return customerBO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateCustomerDetail(CustomerBO customerBO) throws CrafartServiceException {
		CustomerDO customerDO = beanMapper.mapCustomerBOToDO(customerBO, new CustomerDO());
		AddressDO addressDO = beanMapper.mapAddressBOToDO(customerBO.getAddressBO(), new AddressDO(), null, customerDO);
		List<AddressDO> addressDOs = new ArrayList<>();
		addressDOs.add(addressDO);

		ContactDO contactDO = new ContactDO();
		List<ContactDO> contactDOs = new ArrayList<>();
		for (ContactBO contactBO2 : customerBO.getContactBOs()) {
			contactDO = beanMapper.mapContactBOToDO(contactBO2, new ContactDO(), customerDO, null);
			contactDOs.add(contactDO);
		}

		customerDO.setAddressDOs(addressDOs);
		customerDO.setContactDOs(contactDOs);
		try {
			customerDAOImpl.updateCustomerDetails(customerDO);
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while updating customer table", cdExp);
		}
	}

}
