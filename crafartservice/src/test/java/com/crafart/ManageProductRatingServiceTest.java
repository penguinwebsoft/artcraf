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

import com.crafart.inter.service.ManageProductRatingService;
import com.crafart.service.businessobjects.ProductRatingBO;
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
public class ManageProductRatingServiceTest {

	@Autowired
	private ManageProductRatingService manageProductRatingServiceImpl;

	@Test
	@Rollback(true)
	public void testGetProductRating() {
		try {
			List<ProductRatingBO> productRatingBOs = manageProductRatingServiceImpl.getProductRating(8221);
			for (ProductRatingBO productRatingBO : productRatingBOs) {
				System.out.print(productRatingBO.getPoints() + "\t" + productRatingBO.getCustomerBO().getCustomerId());
			}
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
