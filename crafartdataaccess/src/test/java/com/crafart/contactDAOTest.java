/**
 * 
 */
package com.crafart;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ContactDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ContactDAO;

/**
 * @author Karthi
 *
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class contactDAOTest {

	@Autowired
	private ContactDAO contactDAOImpl;
	
	@Test
	@Rollback(true)
	public void testFindByEmailId(){
		try {
			ContactDO contactDO = contactDAOImpl.findByEmailId("sam@gmail.com");
			System.out.print(contactDO.getContactValue()+"\t");
			List<CustomerDO> customerDOs = contactDO.getCustomerDOs();
			for (CustomerDO customerDO : customerDOs) {
				System.out.print(customerDO.getPassword());
			}
			List<SellerDO> sellerDOs = contactDO.getSellerDOs();
			for (SellerDO sellerDO : sellerDOs) {
				System.out.print(sellerDO.getSellerId());
			}
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
		}
	}
}
