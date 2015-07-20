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
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.inter.service.ManageAttributeGroupDescService;
import com.crafart.inter.service.ManageCategoryService;
import com.crafart.inter.service.ManageCommisionService;
import com.crafart.inter.service.ManageCourierService;
import com.crafart.inter.service.ManageCustomerService;
import com.crafart.inter.service.ManageGeoZoneService;
import com.crafart.inter.service.ManageProductRatingService;
import com.crafart.inter.service.ManageProductService;
import com.crafart.inter.service.ManageSellerService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.AttributeGroupDescBO;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.CommisionBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.ProductAttributeBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.ProductDiscountBO;
import com.crafart.service.businessobjects.ProductRatingBO;
import com.crafart.service.businessobjects.ProductShippingBO;
import com.crafart.service.businessobjects.ProductSpecialBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.SeoBO;
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
@Component
public class ManageProductRatingServiceTest {

	@Autowired
	private ManageProductRatingService manageProductRatingServiceImpl;

	@Autowired
	private ManageSellerService manageSellerServiceImpl;
	
	@Autowired
	private ManageAttributeGroupDescService manageAttributeGroupDescServiceImpl;

	@Autowired
	private ManageProductService manageProductServiceImpl;

	@Autowired
	private ManageCustomerService manageCustomerServiceImpl;

	@Autowired
	private ManageGeoZoneService manageGeoZoneServiceImpl;

	@Autowired
	private ManageCommisionService manageCommissionServiceImpl;
	
	@Autowired
	private ManageCourierService manageCourierServiceImpl;
	
	@Autowired
	private ManageCategoryService manageCategoryServiceImpl;


	@Test
	@Rollback(true)
	@Transactional(propagation=Propagation.REQUIRED)
	public void testGetProductRating() {
		ProductRatingBO productRatingBO1 = getProductRating();
		try {
			manageProductRatingServiceImpl.addProductRatting(productRatingBO1);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<ProductRatingBO> productRatingBOs = manageProductRatingServiceImpl.getProductRating(productRatingBO1.getProductRatingId());
			for (ProductRatingBO productRatingBO : productRatingBOs) {
				System.out.print(productRatingBO.getPoints() + "\t" + productRatingBO.getCustomerBO().getCustomerId());
			}
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	@Transactional(propagation=Propagation.REQUIRED)
	public void testAddProductRating() {
		ProductRatingBO productRatingBO = getProductRating();
		try {
			manageProductRatingServiceImpl.addProductRatting(productRatingBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductRatingBO getProductRating() {
		ProductRatingBO productRatingBO = new ProductRatingBO();
		ProductBO productBO = getProductBO();
		CustomerBO customerBO = getCustomer();
		productRatingBO.setPoints(5);
		productRatingBO.setProductBO(productBO);
		productRatingBO.setCustomerBO(customerBO);
		return productRatingBO;

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

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductBO getProductBO() {
		SellerBO sellerBO = getSellerBO();
		ProductBO productBO = new ProductBO();
		productBO.setCategoryId(getCategoryBO().getCategoryId());
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
		}
		return productBO;
	}

	public CategoryBO getCategoryBO() {
		CategoryBO categoryBO = new CategoryBO();
		categoryBO.setImageLocation("");
		categoryBO.setCategoryName("bag");
		categoryBO.setSortOrder(12);
		categoryBO.setDescription("its paper bag");
		categoryBO.setStatus(2);
		categoryBO.setSeoBO(getSeo());
		try {
			manageCategoryServiceImpl.addCategory(categoryBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return categoryBO;
	}
	
	private SeoBO getSeo() {
		SeoBO seoBO = new SeoBO();
		seoBO.setMetaDesc("asdf");
		seoBO.setMetaKeyword("qwert");
		seoBO.setMetaTitle("zxcvbn");
		return seoBO;
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

	private CourierBO getCourier() {
		CourierBO courierBO = new CourierBO();
		courierBO.setImage("from service");
		courierBO.setCourierName("BlueDart");
		courierBO.setEstimatedDeliveryTime("lfl");
		courierBO.setSortOrder(9);
		try {
			manageCourierServiceImpl.addCourier(courierBO);
		} catch (CrafartServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courierBO;
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
		productAttributeBO.setAttributeGroupId(getAttributeGroupDescBO().getAtrributeGroupDescId());
		productAttributeBO.setSortOrder(1);
		productAttributeBO.setText("black&white");
		ProductAttributeBO productAttributeBO2 = new ProductAttributeBO();
		productAttributeBO2.setAttributeGroupId(getAttributeGroupDescBO().getAtrributeGroupDescId());
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
		productShippingBO.setCourierId(getCourier().getCourierId());
		productShippingBO.setGeoZoneId(getGeoZone().getGeoZoneId());
		productShippingBO.setShippingRate(125);
		ProductShippingBO productShippingBO2 = new ProductShippingBO();
		productShippingBO2.setCourierId(getCourier().getCourierId());
		productShippingBO2.setGeoZoneId(getGeoZone().getGeoZoneId());
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
		productDiscountBO.setValue(101.2f);
		productDiscountBO.setQuantity(23);
		productDiscountBO.setStartDate("00/00/0202");
		productDiscountBO.setDiscountCode("test");
		ProductDiscountBO productDiscountBO2 = new ProductDiscountBO();
		productDiscountBO2.setEndDate("00/01/0101");
		productDiscountBO2.setValue(125);
		productDiscountBO2.setQuantity(15);
		productDiscountBO2.setStartDate("11/11/1111");
		productDiscountBO2.setDiscountCode("teste");
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
		weightClassBO.setUnit(15);
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
		sellerBO.setCommissionBO(getCommision());

		try {
			manageSellerServiceImpl.addSeller(sellerBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return sellerBO;

	}

	private CommisionBO getCommision() {
		CommisionBO commissionBO = new CommisionBO();
		commissionBO.setName("qwerty");
		commissionBO.setSortOrder(2);
		commissionBO.setType("qwert");
		commissionBO.setValue(2.0f);
		return commissionBO;

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
	private GeoZoneBO getGeoZone() {
		GeoZoneBO geoZoneBO = new GeoZoneBO();
		geoZoneBO.setDescription("jlk");
		geoZoneBO.setName("Kerala");
		try {
			manageGeoZoneServiceImpl.addGeoZone(geoZoneBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		return geoZoneBO;
	}
	
	public AttributeGroupDescBO getAttributeGroupDescBO(){
		AttributeGroupDescBO attributeGroupDescBO = new AttributeGroupDescBO();
		attributeGroupDescBO.setAttributeGroupName("Jewllery");
		attributeGroupDescBO.setSortOrder(1);
		try {
			manageAttributeGroupDescServiceImpl.addAttributeGroupDesc(attributeGroupDescBO);
		} catch (CrafartServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attributeGroupDescBO;
	}
}
