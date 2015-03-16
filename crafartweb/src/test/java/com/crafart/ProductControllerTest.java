/**
 * 
 */
package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.SellerBO;

/**
 * @author Karthi
 * 
 *
 */

/**
 * Unit test for simple App.
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ProductControllerTest {

	@Autowired
	private ProductController productController;

	@Autowired
	private SellerController sellerController;

	@Test
	@Rollback(true)
	public void testAddProduct() {
		ProductBO productBO = getProductBO();
		try {
			productController.addProduct(productBO);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductBO getProductBO() {
		SellerBO sellerBO = getSellerBO();
		ProductBO productBO = new ProductBO();
		productBO.setCategoryId(1);
		productBO.setDateAvailable(java.sql.Date.valueOf("2013-02-01"));
		productBO.setHeight(52);
		productBO.setImage("a15cb5e");
		productBO.setLength(63.2);
		productBO.setLengthClassId(1);
		productBO.setLocation("awawaw");
		productBO.setMinimum(26.00);
		productBO.setModel("zzzz");
		productBO.setPoints(5);
		productBO.setPrice(12.2f);
		productBO.setQuantity("2");
		productBO.setSellerId(sellerBO.getSellerId());
		productBO.setShipping(2);
		productBO.setSku("aqaqaq");
		productBO.setSortOrder("aes");
		productBO.setStatus(1);
		productBO.setStockStatusId("20");
		productBO.setSubtract(20.0001);
		productBO.setTaxClassId(1);
		productBO.setUpc("asd");
		productBO.setViewed(2);
		productBO.setWeight("25");
		productBO.setWeightClassId(1);
		productBO.setWidth(12.5);
		return productBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerBO getSellerBO() {
		SellerBO sellerBO = new SellerBO();
		sellerBO.setFirstName("xxxx");
		sellerBO.setLastName("yyyy");
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setTinNo(1);
		sellerBO.setCompanyName("penguin");
		sellerBO.setCompanyLogo("pen");
		sellerBO.setEpchNo("123");
		sellerBO.setVatNo("123456a");
		sellerBO.setCstNo("000");
		sellerBO.setCommission("aaaa");
		sellerBO.setStatus(1);
		sellerBO.setApproved(1);

		try {
			sellerController.addSeller(sellerBO, null, null, new MockHttpServletRequest(), new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellerBO;

	}

}
