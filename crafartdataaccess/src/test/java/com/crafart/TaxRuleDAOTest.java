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

import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.TaxRateDO;
import com.crafart.dataobjects.TaxRuleDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.TaxRateDAO;
import com.crafart.inter.data.TaxRuleDAO;
import com.crafart.inter.data.WeightClassDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class TaxRuleDAOTest {

	@Autowired
	private TaxRuleDAO taxRuleDAOImpl;

	@Autowired
	private TaxRateDAO taxRateDAOImpl;

	@Autowired
	private ProductDAO productDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Test
	@Rollback(true)
	public void testAddTaxRule() {
		List<TaxRuleDO> taxRuleDOs = getTaxRule();
		try {
			taxRuleDAOImpl.addTaxRule(taxRuleDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<TaxRuleDO> getTaxRule() {
		TaxRuleDO taxRuleDO = new TaxRuleDO();
		List<TaxRuleDO> taxRuleDOs = new ArrayList<>();
		TaxRateDO taxRateDO = getTaxRate();
		taxRuleDO.setBased("xxx");
		taxRuleDO.setPriority(1);
		taxRuleDO.setTaxClassId(1);
		taxRuleDO.setValue("2%");
		taxRuleDO.setTaxRateDO(taxRateDO);
		TaxRuleDO taxRuleDO2 = new TaxRuleDO();
		taxRuleDO2.setBased("ccc");
		taxRuleDO2.setPriority(1);
		taxRuleDO2.setTaxClassId(2);
		taxRuleDO2.setValue("4%");
		taxRuleDO2.setTaxRateDO(taxRateDO);
		TaxRuleDO taxRuleDO3 = new TaxRuleDO();
		taxRuleDO3.setBased("aaa");
		taxRuleDO3.setPriority(1);
		taxRuleDO3.setTaxClassId(3);
		taxRuleDO3.setValue("5%");
		taxRuleDO3.setTaxRateDO(taxRateDO);
		taxRuleDOs.add(taxRuleDO);
		taxRuleDOs.add(taxRuleDO2);
		taxRuleDOs.add(taxRuleDO3);
		return taxRuleDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private TaxRateDO getTaxRate() {
		TaxRateDO taxRateDO = new TaxRateDO();
		ProductDO productDO = getProduct();
		taxRateDO.setProductDO(productDO);
		taxRateDO.setSellerId(productDO.getSellerId());
		taxRateDO.setName("opop");
		taxRateDO.setRate(1);
		taxRateDO.setType("nnnn");
		try {
			taxRateDAOImpl.addTaxRate(taxRateDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return taxRateDO;
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
		lengthClassDO.setIsActive(1);
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
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return sellerDO;

	}

}
