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

import com.crafart.service.ManageProductService;
import com.crafart.service.ManageSellerService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.ProductDiscountBO;
import com.crafart.service.businessobjects.ProductSpecialBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.businessobjects.WeightClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageProductServiceTest {

	@Autowired
	private ManageProductService manageProductServiceImpl;

	@Autowired
	private ManageSellerService manageSellerServiceImpl;

	@Test
	@Rollback(true)
	public void testManageProductService() {

		ProductBO productBO = getProductBO();
		try {
			manageProductServiceImpl.addProduct(productBO);
		} catch (CrafartServiceException crafartServiceException) {
			crafartServiceException.printStackTrace();
			Assert.fail();
		}
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
		productBO.setLengthClassBO(getLengthClassBO(productBO));
		productBO.setLocation("from service testing");
		productBO.setMinimum(26.00);
		productBO.setModel("service");
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
		productBO.setWeightClassBO(getWeightClassBO(productBO));
		productBO.setWidth(12.5);
		productBO.setProductDescriptionBO(getProductDescriptionAndSeo());
		productBO.setProductDiscountBOs(getProductDiscount());
		productBO.setProductSpecialBOs(getProductSpecial());
		return productBO;
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
		lengthClassBO.setUnit(152);
		lengthClassBO.setValue(Float.valueOf("15.2"));
		return lengthClassBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private SellerBO getSellerBO() {
		SellerBO sellerBO = new SellerBO();
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setGender(1);
		sellerBO.setDateOfBirth("00/00/0000");
		sellerBO.setApproved(1);
		sellerBO.setCommission("www");
		sellerBO.setCompanyLogo("qqq");
		sellerBO.setCompanyName("penguin");
		sellerBO.setCstNo("4444");
		sellerBO.setEpchNo("121212");
		sellerBO.setFirstName("from service");
		sellerBO.setLastName("service");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");
		sellerBO.setStoreBO(getStoreBO(sellerBO));
		sellerBO.setAddressBO(getAddressBO(sellerBO));

		try {
			manageSellerServiceImpl.addSeller(sellerBO);
		} catch (CrafartServiceException e) {
			e.printStackTrace();
		}
		return sellerBO;

	}

	private AddressBO getAddressBO(SellerBO sellerBO) {
		AddressBO addressBO = new AddressBO();
		addressBO.setCityId(0);
		addressBO.setPinCode("service now");
		addressBO.setStateId(0);
		addressBO.setStreet("testing now");
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

}
