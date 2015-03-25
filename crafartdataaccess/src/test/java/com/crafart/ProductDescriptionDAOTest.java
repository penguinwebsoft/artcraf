/**
 * 
 */
package com.crafart;

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

import com.crafart.data.LengthClassDAO;
import com.crafart.data.ProductDAO;
import com.crafart.data.ProductDescriptionDAO;
import com.crafart.data.SellerDAO;
import com.crafart.data.WeightClassDAO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 *
 */

/**
 * Unit test for simple App.
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProductDescriptionDAOTest {

	@Autowired
	private ProductDescriptionDAO productDescriptionDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;
	
	@Autowired
	private ProductDAO productDAOImpl;

	@Test
	@Rollback(true)
	public void testAddProductDescription() {
		ProductDescriptionDO productDescriptionDO = getProductDescriptionAndSeo();
		try {
			productDescriptionDAOImpl.addDescription(productDescriptionDO);
		} catch (CrafartDataException crafartDataException) {
			crafartDataException.printStackTrace();
			Assert.fail();
			
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductDescriptionDO getProductDescriptionAndSeo() {
		ProductDO productDO = getProduct();
		ProductDescriptionDO productDescriptionDO = new ProductDescriptionDO();
		productDescriptionDO.setMetaDescription("ppppp");
		productDescriptionDO.setDescription("qqqqq");
		productDescriptionDO.setMetaKeyword("rrrrr");
		productDescriptionDO.setName("sssss");
		productDescriptionDO.setTag("ttttt");
		productDescriptionDO.setProductDO(productDO);
		return productDescriptionDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ProductDO getProduct() {
		SellerDO sellerDO = getSellerDO();
		ProductDO productDO = new ProductDO();
		productDO.setCategoryId(1);
		productDO.setSellerId(sellerDO.getSellerId());
		productDO.setDateAvailable("03-10-1982");
		productDO.setHeight(52);
		productDO.setImage("a15cb5e");
		productDO.setLength(63.2);
		productDO.setLengthClassDO(getLengthClass());
		productDO.setLocation("from service");
		productDO.setMinimum(26.00);
		productDO.setModel("service");
		productDO.setPoints(5);
		productDO.setPrice(12.2f);
		productDO.setQuantity("2");
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
		productDO.setWeightClassDO(getWeightClass());
		productDO.setWidth(12.5);
		try {
			productDAOImpl.addProduct(productDO);
		} catch (CrafartDataException e) {
			e.printStackTrace();
			Assert.fail();
		}
		return productDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private LengthClassDO getLengthClass() {
		LengthClassDO lengthClassDO = new LengthClassDO();
		lengthClassDO.setTitle("from dao");
		lengthClassDO.setUnit(15);
		lengthClassDO.setValue(15);
		try {
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
		} catch (CrafartDataException e) {
			e.printStackTrace();
			Assert.fail();
		}
		return lengthClassDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private WeightClassDO getWeightClass() {
		WeightClassDO weightClassDO = new WeightClassDO();
		weightClassDO.setTitle("from dao");
		weightClassDO.setUnit(12.5);
		weightClassDO.setValue(12.5f);
		try {
			weightClassDAOImpl.addWeightClass(weightClassDO);
		} catch (CrafartDataException e) {
			e.printStackTrace();
			Assert.fail();
		}
		return weightClassDO;
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