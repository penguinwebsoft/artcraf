/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

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

import com.crafart.dataobjects.CommissionDO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductDiscountDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.ProductDiscountDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.WeightClassDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProductDiscountDAOTest {

	@Autowired
	private ProductDiscountDAO productDiscountDAOImpl;

	@Autowired
	private ProductDAO productDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	/*
	 * Test case to add data in product discount table
	 */

	@Test
	@Rollback(true)
	public void testAddProductDiscount() {
		List<ProductDiscountDO> productDiscountDOs = getProductDiscount();
		try {
			productDiscountDAOImpl.addProductDiscount(productDiscountDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private List<ProductDiscountDO> getProductDiscount() {
		List<ProductDiscountDO> productDiscountDOs = new ArrayList<>();
		ProductDO productDO = getProduct();
		ProductDiscountDO productDiscountDO = new ProductDiscountDO();
		productDiscountDO.setEndDate("00/00/0000");
		productDiscountDO.setValue(125.6f);
		productDiscountDO.setQuantity(20);
		productDiscountDO.setStartDate("00/00/0000");
		productDiscountDO.setProductDO(productDO);
		for (SellerDO sellerDO : productDO.getSellerDOs()) {
			productDiscountDO.setSellerId(sellerDO.getSellerId());
		}
		ProductDiscountDO productDiscountDO2 = new ProductDiscountDO();
		productDiscountDO2.setEndDate("00/00/0000");
		productDiscountDO2.setStartDate("00/01/0202");
		productDiscountDO2.setValue(150);
		productDiscountDO2.setProductDO(productDO);
		for (SellerDO sellerDO : productDO.getSellerDOs()) {
			productDiscountDO2.setSellerId(sellerDO.getSellerId());
		}
		productDiscountDOs.add(productDiscountDO2);
		productDiscountDOs.add(productDiscountDO);
		return productDiscountDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public ProductDO getProduct() {
		SellerDO sellerDO = getSellerDO();
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		ProductDO productDO = new ProductDO();
		productDO.setCategoryId(1);
		productDO.setSellerDOs(sellerDOs);
		productDO.setDateAvailable("03-10-1982");
		productDO.setHeight(52);
		productDO.setImage("a15cb5e");
		productDO.setLength(63.2);
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
		productDO.setUpc("asd");
		productDO.setViewed(2);
		productDO.setWeight("25");
		productDO.setWeightClassDO(getWeightClass());
		productDO.setWidth(12.5);
		try {
			productDAOImpl.addProduct(productDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return productDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private LengthClassDO getLengthClass() {
		LengthClassDO lengthClassDO = new LengthClassDO();
		lengthClassDO.setTitle("from dao");
		lengthClassDO.setIsActive(0);
		try {
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
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
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return weightClassDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CommissionDO getCommission() {
		CommissionDO commissionDO = new CommissionDO();
		commissionDO.setName("qwqw");
		commissionDO.setSortOrder(2);
		commissionDO.setType("comm");
		commissionDO.setValue(3.5f);
		try {
			commissionDAOImpl.addCommission(commissionDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return commissionDO;
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
		sellerDO.setCommissionDO(getCommission());
		sellerDO.setStatus(1);
		sellerDO.setApproved(1);
		try {
			sellerDAOImpl.addSeller(sellerDO);
			sellerDO.setSellerId(sellerDO.getSellerId());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
		}
		return sellerDO;

	}

}
