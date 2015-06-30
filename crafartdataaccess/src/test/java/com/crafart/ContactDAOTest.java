/**
 * 
 */
package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.ContactDO;
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
public class ContactDAOTest {

	@Autowired
	private ContactDAO contactDAOImpl;

	@Ignore
	@Rollback(true)
	public void testFindByEmailId() {
		try {
			ContactDO contactDO = contactDAOImpl.findByEmailId("asasddds@iii.com");
			System.out.print(contactDO.getContactValue() + "\t");
			List<SellerDO> sellerDOs = contactDO.getSellerDOs();
			for (SellerDO sellerDO : sellerDOs) {
				List<AddressDO> addressDOs = sellerDO.getAddressDOs();
				for (AddressDO addressDO : addressDOs) {
					System.out.print("\t" + "address_id" + addressDO.getAddressId());
				}
				System.out.print("\t Store_id" + sellerDO.getStoreDO().getStoreId());
				System.out.print("\t seller_id" + sellerDO.getSellerId());
			}
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void dummyTest(){
		
	}
}
