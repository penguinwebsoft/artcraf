/**
 * 
 */
package com.crafart;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageLengthClassService;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageLengthClassServiceTest {

	@Autowired
	public ManageLengthClassService manageLengthClassServiceImpl;

	@Test
	@Rollback(true)
	public void testUpdateLengthClass() {
		LengthClassBO lengthClassBO = getLengthClass();
		try {
			manageLengthClassServiceImpl.addLengthClass(lengthClassBO);
			lengthClassBO.setTitle("Updated Title");
			// since got new identifier , calling addLengthClass will actually
			// update the lengthclass data
			manageLengthClassServiceImpl.addLengthClass(lengthClassBO);
			Assert.assertEquals("Updated Title", lengthClassBO.getTitle());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testAddLengthClass() {
		LengthClassBO lengthClassBO = getLengthClass();
		try {
			manageLengthClassServiceImpl.addLengthClass(lengthClassBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private LengthClassBO getLengthClass() {
		LengthClassBO lengthClassBO = new LengthClassBO();
		lengthClassBO.setTitle("kjh");
		lengthClassBO.setUnit("jhh");
		lengthClassBO.setIsActive(88);
		lengthClassBO.setSortOrder(9);
		return lengthClassBO;
	}

	@Test
	@Rollback(true)
	public void testGetLengthClass() {
		LengthClassBO lengthClassBO = getLengthClass();
		try {
			manageLengthClassServiceImpl.addLengthClass(lengthClassBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			Map<Long, LengthClassBO> lengthClassBOs = manageLengthClassServiceImpl.getLengthClass();
			int count = 0;
			for (Map.Entry<Long, LengthClassBO> lengthClassEntry : lengthClassBOs.entrySet()) {
				if ((lengthClassBO.getLengthClassId() == lengthClassEntry.getValue().getLengthClassId())) {
					count = count + 1;
				}
			}
			Assert.assertEquals(1, count);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
