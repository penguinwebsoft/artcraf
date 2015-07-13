/**
 * 
 */
package com.crafart;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.crafart.service.businessobjects.UserBO;
import com.crafart.service.exception.CrafartServiceException;


/**
 * @author
 * 
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class UserControllerTest {

	@Autowired
	private UserController userController;
	
	@Test
	public void testDummy(){
		
	}

	@Ignore
	@Rollback(true)
	public void testGetUserDetail() throws CrafartServiceException {
		ModelMap modelMap = userController.getUser(new MockHttpSession());
		System.out.println("UserControllerTest.testGetUserDetail()");
		System.out.print(modelMap.size());
	}
	

	@Ignore
	@Rollback(true)
	public void testAddUserBO() {
		UserBO userBO = new UserBO();
		userBO.setUserName("djsc");
		userBO.setFirstName("jcjdn");
		userBO.setLastName("sxh");
		userBO.setPassword("gbhh");
		userBO.setIsActive("enable");
	}

}
