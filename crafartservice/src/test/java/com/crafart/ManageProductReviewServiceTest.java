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

import com.crafart.inter.service.ManageCustomerService;
import com.crafart.inter.service.ManageProductReviewService;
import com.crafart.inter.service.ManageProductService;
import com.crafart.inter.service.ManageSellerService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.ProductAttributeBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.ProductDiscountBO;
import com.crafart.service.businessobjects.ProductReviewBO;
import com.crafart.service.businessobjects.ProductShippingBO;
import com.crafart.service.businessobjects.ProductSpecialBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.businessobjects.TaxRateBO;
import com.crafart.service.businessobjects.TaxRuleBO;
import com.crafart.service.businessobjects.WeightClassBO;
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

	@Autowired
	private ManageSellerService manageSellerServiceImpl;

	@Autowired
	private ManageProductService manageProductServiceImpl;

	@Autowired
	private ManageCustomerService manageCustomerServiceImpl;

	@Test
	@Rollback(true)
	public void testGetProductReview() {
		ProductReviewBO productReviewBO = getProductReview();
		try {
			manageProductReviewServiceImpl.addProductReview(productReviewBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			manageProductReviewServiceImpl.getProductReview(productReviewBO.getProductReviewId());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testGetSingleProductReviews() {
		ProductReviewBO productReviewBO1 = getProductReview();
		try {
			manageProductReviewServiceImpl.addProductReview(productReviewBO1);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			manageProductReviewServiceImpl.getSingleProductReviews(productReviewBO1.getProductBO().getProductId());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testAddReview() {
		ProductReviewBO productReviewBO = getProductReview();
		try {
			manageProductReviewServiceImpl.addProductReview(productReviewBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	private ProductReviewBO getProductReview() {
		ProductBO productBO = getProductBO();
		CustomerBO customerBO = getCustomer();
		ProductReviewBO productReviewBO = new ProductReviewBO();
		productReviewBO.setAuthour("aaaa");
		productReviewBO.setCustomerBO(customerBO);
		productReviewBO.setProductBO(productBO);
		productReviewBO.setRating(12);
		productReviewBO.setStatus(1);
		productReviewBO.setText("qwerty");
		return productReviewBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductDescriptionBO getProductDescriptionAndSeo() {
		ProductDescriptionBO productDescriptionBO = new ProductDescriptionBO();
		productDescriptionBO.setDescription("qwerty");
		productDescriptionBO.setMetaDescription("qwerty");
		productDescriptionBO.setMetaKeyword("qwerty");
		productDescriptionBO.setName("ytrewq");
		productDescriptionBO.setTag("ytrewq");
		return productDescriptionBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductBO getProductBO() {
		SellerBO sellerBO = getSellerBO();
		ProductBO productBO = new ProductBO();
		productBO.setCategoryId(1);
		productBO.setDateAvailable("20/00/0000");
		productBO.setHeight(52);
		productBO.setImage("a15cb5e");
		productBO.setLength(63.2);
		productBO.setLocation("for getting product details");
		productBO.setMinimum(26.00);
		productBO.setModel("service");
		productBO.setPoints(5);
		productBO.setPrice(12.2f);
		productBO.setQuantity("2");
		productBO.setSellerBO(sellerBO);
		productBO.setShipping(2);
		productBO.setSku("aqaqaq");
		productBO.setSortOrder("aes");
		productBO.setStatus(1);
		productBO.setStockStatusId("20");
		productBO.setProductName("Micromax");
		productBO.setSubtract(20.0001);
		productBO.setUpc("asd");
		productBO.setViewed(2);
		productBO.setWeight("25");
		productBO.setWeightClassBO(getWeightClassBO(productBO));
		productBO.setWidth(12.5);
		productBO.setProductDescriptionBO(getProductDescriptionAndSeo());
		productBO.setProductDiscountBOs(getProductDiscount());
		productBO.setProductSpecialBOs(getProductSpecial());
		productBO.setProductShippingBOs(getProductShipping());
		productBO.setProductAttributeBOs(getProductAttribute());
		productBO.setTaxRateBO(getTaxRate());
		try {
			manageProductServiceImpl.addProduct(productBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return productBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<TaxRuleBO> getTaxRule() {
		List<TaxRuleBO> taxRuleBOs = new ArrayList<>();
		TaxRuleBO taxRuleBO = new TaxRuleBO();
		taxRuleBO.setValue("5%");
		taxRuleBO.setPriority(1);
		taxRuleBO.setTaxClassId(1);
		taxRuleBO.setBased("service");
		TaxRuleBO taxRuleBO2 = new TaxRuleBO();
		taxRuleBO2.setBased("service");
		taxRuleBO2.setPriority(2);
		taxRuleBO2.setTaxClassId(2);
		taxRuleBO2.setValue("4%");
		TaxRuleBO taxRuleBO3 = new TaxRuleBO();
		taxRuleBO3.setBased("service");
		taxRuleBO3.setPriority(2);
		taxRuleBO3.setTaxClassId(3);
		taxRuleBO3.setValue("2%");
		taxRuleBOs.add(taxRuleBO);
		taxRuleBOs.add(taxRuleBO2);
		taxRuleBOs.add(taxRuleBO3);
		return taxRuleBOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private TaxRateBO getTaxRate() {
		TaxRateBO taxRateBO = new TaxRateBO();
		taxRateBO.setName("pppp");
		taxRateBO.setRate(36);
		taxRateBO.setType("opop");
		taxRateBO.setTaxRuleBOs(getTaxRule());
		return taxRateBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ProductAttributeBO> getProductAttribute() {
		List<ProductAttributeBO> productAttributeBOs = new ArrayList<>();
		ProductAttributeBO productAttributeBO = new ProductAttributeBO();
		productAttributeBO.setAttributeGroupId(21);
		productAttributeBO.setSortOrder(1);
		productAttributeBO.setText("black&white");
		ProductAttributeBO productAttributeBO2 = new ProductAttributeBO();
		productAttributeBO2.setAttributeGroupId(21);
		productAttributeBO2.setSortOrder(2);
		productAttributeBO2.setText("red&green");
		productAttributeBOs.add(productAttributeBO2);
		productAttributeBOs.add(productAttributeBO);
		return productAttributeBOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ProductShippingBO> getProductShipping() {
		List<ProductShippingBO> productShippingBOs = new ArrayList<>();
		ProductShippingBO productShippingBO = new ProductShippingBO();
		productShippingBO.setCourierId(41);
		productShippingBO.setGeoZoneId(50);
		productShippingBO.setShippingRate(125);
		ProductShippingBO productShippingBO2 = new ProductShippingBO();
		productShippingBO2.setCourierId(41);
		productShippingBO2.setGeoZoneId(50);
		productShippingBO2.setShippingRate(154);
		productShippingBOs.add(productShippingBO2);
		productShippingBOs.add(productShippingBO);
		return productShippingBOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ProductDiscountBO> getProductDiscount() {
		List<ProductDiscountBO> productDiscountBOs = new ArrayList<>();
		ProductDiscountBO productDiscountBO = new ProductDiscountBO();
		productDiscountBO.setEndDate("01/01/0101");
		productDiscountBO.setPrice(101.2f);
		productDiscountBO.setQuantity(23);
		productDiscountBO.setStartDate("00/00/0202");
		ProductDiscountBO productDiscountBO2 = new ProductDiscountBO();
		productDiscountBO2.setEndDate("00/01/0101");
		productDiscountBO2.setPrice(125);
		productDiscountBO2.setQuantity(15);
		productDiscountBO2.setStartDate("11/11/1111");
		productDiscountBOs.add(productDiscountBO2);
		productDiscountBOs.add(productDiscountBO);
		return productDiscountBOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ProductSpecialBO> getProductSpecial() {
		List<ProductSpecialBO> productSpecialBOs = new ArrayList<>();
		ProductSpecialBO productSpecialBO = new ProductSpecialBO();
		productSpecialBO.setEndDate("00/00/0000");
		productSpecialBO.setPrice(120.25f);
		productSpecialBO.setStartDate("00/00/0001");
		ProductSpecialBO productSpecialBO2 = new ProductSpecialBO();
		productSpecialBO2.setEndDate("00/00/9999");
		productSpecialBO2.setPrice(120.25f);
		productSpecialBO2.setStartDate("00/10/9001");
		productSpecialBOs.add(productSpecialBO2);
		productSpecialBOs.add(productSpecialBO);
		return productSpecialBOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private WeightClassBO getWeightClassBO(ProductBO productBO) {
		WeightClassBO weightClassBO = new WeightClassBO();
		weightClassBO.setTitle("from service");
		// weightClassBO.setUnit(15);
		weightClassBO.setValue(10);
		return weightClassBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private LengthClassBO getLengthClassBO(ProductBO productBO) {
		LengthClassBO lengthClassBO = new LengthClassBO();
		lengthClassBO.setTitle("from service");
		lengthClassBO.setIsActive(0);
		return lengthClassBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerBO getSellerBO() {
		SellerBO sellerBO = new SellerBO();
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setApproved(1);
		sellerBO.setCompanyLogo("qqq");
		sellerBO.setCompanyName("penguin");
		sellerBO.setCstNo("4444");
		sellerBO.setEpchNo("121212");
		sellerBO.setFirstName("test for getting attribute");
		sellerBO.setLastName("service");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");
		sellerBO.setPassword("gjvsa");
		sellerBO.setStoreBO(getStoreBO(sellerBO));
		sellerBO.setAddressBO(getAddressBO(sellerBO));
		sellerBO.setContactBOs(getContactBOs(sellerBO));

		try {
			manageSellerServiceImpl.addSeller(sellerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return sellerBO;

	}

	private AddressBO getAddressBO(SellerBO sellerBO) {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(0);
		addressBO.setPinCode("adding address");
		addressBO.setStateId(0);
		addressBO.setStreet("adding address");
		addressBO.setSellerBO(sellerBO);
		return addressBO;
	}

	private StoreBO getStoreBO(SellerBO sellerBO) {
		StoreBO storeBO = new StoreBO();
		storeBO.setName("from service add");
		storeBO.setSellerBO(sellerBO);
		storeBO.setStoreDescription(" from service add");
		storeBO.setStoreReturn("serv");
		storeBO.setStoreUrl("www.wwww.com");
		return storeBO;

	}

	private List<ContactBO> getContactBOs(SellerBO sellerBO) {
		List<ContactBO> contactBOs = new ArrayList<>();
		ContactBO contactBO = new ContactBO();
		contactBO.setContactTypeId(1);
		contactBO.setContactValue("0000000");
		contactBO.setSellerBO(sellerBO);
		ContactBO contactBO2 = new ContactBO();
		contactBO2.setContactTypeId(2);
		contactBO2.setContactValue("044-202020");
		contactBO.setSellerBO(sellerBO);
		ContactBO contactBO3 = new ContactBO();
		contactBO3.setContactTypeId(3);
		contactBO3.setContactValue("sellerservice@iii.com");
		contactBO.setSellerBO(sellerBO);
		contactBOs.add(contactBO);
		contactBOs.add(contactBO2);
		contactBOs.add(contactBO3);
		return contactBOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CustomerBO getCustomer() {
		CustomerBO customerBO = new CustomerBO();
		AddressBO addressBO = getAddress();
		customerBO.setDateOfBirth("00-00-1000");
		customerBO.setFirstName("satur");
		customerBO.setGender(0);
		customerBO.setLastName("monday");
		customerBO.setIp("120000001200");
		customerBO.setPassword("klklkl");
		customerBO.setStatus(1);
		customerBO.setAddressBO(addressBO);
		List<ContactBO> contactBOs = getContactBOs(customerBO);
		customerBO.setContactBOs(contactBOs);
		try {
			manageCustomerServiceImpl.addCustomerDetail(customerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return customerBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private AddressBO getAddress() {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(047);
		addressBO.setPinCode("639117");
		addressBO.setStateId(047);
		addressBO.setStreet("2a nagar");
		return addressBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ContactBO> getContactBOs(CustomerBO customerBO) {
		List<ContactBO> contactBOs = new ArrayList<>();
		ContactBO contactBO = new ContactBO();
		contactBO.setContactTypeId(1);
		contactBO.setContactValue("0000000");
		contactBO.setCustomerBO(customerBO);
		ContactBO contactBO2 = new ContactBO();
		contactBO2.setContactTypeId(2);
		contactBO2.setContactValue("044-202020");
		contactBO2.setCustomerBO(customerBO);
		ContactBO contactBO3 = new ContactBO();
		contactBO3.setContactTypeId(3);
		contactBO3.setContactValue("klklk@iii.com");
		contactBO3.setCustomerBO(customerBO);
		contactBOs.add(contactBO);
		contactBOs.add(contactBO2);
		contactBOs.add(contactBO3);
		return contactBOs;
	}

}
