/**
 * 
 */
package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageProductReviewService;
import com.crafart.service.businessobjects.ProductReviewBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ManageProductReviewServiceTest {

	@Autowired
	private ManageProductReviewService manageProductReviewServiceImpl;

	@Test
	@Rollback(true)
	public void testGetProductReview() {
		try {
			manageProductReviewServiceImpl.getProductReview(8081);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetSingleProductReviews() {
		try {
			List<ProductReviewBO> productReviewBOs = manageProductReviewServiceImpl.getSingleProductReviews(21841);
			for (ProductReviewBO productReviewBO : productReviewBOs) {
				System.out.print(productReviewBO.getAuthour());
			}
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
