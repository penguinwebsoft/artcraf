/**
 * 
 */
package com.crafart;

import java.util.List;

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
	public void testAddLengthClassDetail() {
		LengthClassBO lengthClassBO = getLengthClass();
		try {
			manageLengthClassServiceImpl.addLengthClassDetail(lengthClassBO);
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
		lengthClassBO.setSortorder(9);
		return lengthClassBO;
	}

	@Test
	@Rollback(true)
	public void testGetLengthClassDetail() {
		LengthClassBO lengthClassBO = getLengthClass();
		try {
			manageLengthClassServiceImpl.addLengthClassDetail(lengthClassBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			@SuppressWarnings("unused")
			List<LengthClassBO> lengthClassBOs = manageLengthClassServiceImpl.getLengthClassDetail();
			
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
