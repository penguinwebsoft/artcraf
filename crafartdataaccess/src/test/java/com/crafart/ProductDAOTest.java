/**
 * 
 */
package com.crafart;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.ProductDAO;
import com.crafart.data.ProductDAOImpl;
import com.crafart.data.SellerDAO;
import com.crafart.data.SellerDAOImpl;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProductDAOTest {

	private static final Logger log = Logger.getLogger(ProductDAOTest.class);

	@Autowired
	private ProductDAO productDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	/**
	 * test case for addProduct, first getting sellerId by calling
	 * {@link SellerDAOImpl} addSeller, then by getting sellerId, we are calling
	 * {@link ProductDAOImpl} addProduct method
	 */
	@Test
	@Rollback(true)
	public void addProductTest() {
		try {
			ProductDO productDO = getProduct();
			productDAOImpl.addProduct(productDO);
			log.info("product id " + productDO.getProductId());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductDO getProduct() throws ParseException {
		SellerDO sellerDO = getSellerDO();
		ProductDO productDO = new ProductDO();
		productDO.setCategoryId(1);
		productDO.setDateAvailable(java.sql.Date.valueOf("2013-02-01"));
		productDO.setHeight(52);
		productDO.setImage("a15cb5e");
		productDO.setLength(63.2);
		productDO.setLengthClassId(1);
		productDO.setLocation("awawaw");
		productDO.setMinimum(26.00);
		productDO.setModel("zzzz");
		productDO.setPoints(5);
		productDO.setPrice(12.2f);
		productDO.setQuantity("2");
		productDO.setSellerId(sellerDO.getSellerId());
		productDO.setShipping(2);
		productDO.setSku("aqaqaq");
		productDO.setSortOrder("aes");
		productDO.setStatus(1);
		productDO.setStockStatusId("20");
		productDO.setSubtract(20.0001);
		productDO.setTaxClassId(1);
		productDO.setUpc("asd");
		productDO.setViewed(2);
		productDO.setWeight("25");
		productDO.setWeightClassId(1);
		productDO.setWidth(12.5);

		return productDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerDO getSellerDO() {
		SellerDO sellerDO = new SellerDO();
		sellerDO.setFirstName("xxxx");
		sellerDO.setLastName("yyyy");
		sellerDO.setTin_no(1);
		sellerDO.setDateOfBirth("00/00/1300");
		sellerDO.setGender(1);
		sellerDO.setCompanyName("penguin");
		sellerDO.setCompanyLogo("pen");
		sellerDO.setEpch_no("123");
		sellerDO.setVat_no("123456a");
		sellerDO.setCst_no("000");
		sellerDO.setCommission("aaaa");
		sellerDO.setStatus(1);
		sellerDO.setApproved(1);
		try {
			sellerDAOImpl.addSeller(sellerDO);
			sellerDO.setSellerId(sellerDO.getSellerId());
		} catch (CrafartDataException uExp) {
			uExp.printStackTrace();
		}
		return sellerDO;

	}

}
