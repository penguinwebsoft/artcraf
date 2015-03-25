/**
 * 
 */
package com.crafart;

import javax.servlet.http.HttpSession;

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

import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.businessobjects.WeightClassBO;

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

	@SuppressWarnings("deprecation")
	/**
	 * Mock session object is created for testing purpose and mock values are inserted using putvalue()
	 */
	@Test
	@Rollback(true)
	public void testAddProduct() {
		ProductBO productBO = getProductBO();
		try {
			HttpSession httpSession = new MockHttpSession();
			httpSession.putValue("sellerprofile", getSellerBO());
			TaxClassBO taxClassBO = new TaxClassBO();
			taxClassBO.setTaxClassId(1);
			httpSession.putValue("taxClass", taxClassBO);
			productController.addProduct(productBO, new MockHttpServletRequest(), httpSession);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();

		}
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
		productBO.setLocation("from controller");
		productBO.setMinimum(26.00);
		productBO.setModel("from controller");
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
		return productBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductDescriptionBO getProductDescriptionAndSeo() {
		ProductDescriptionBO productDescriptionBO = new ProductDescriptionBO();
		productDescriptionBO.setDescription("from controller");
		productDescriptionBO.setMetaDescription("from controller");
		productDescriptionBO.setMetaKeyword("cont");
		productDescriptionBO.setName("controller");
		productDescriptionBO.setTag("demo from controller");
		return productDescriptionBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private WeightClassBO getWeightClassBO(ProductBO productBO) {
		WeightClassBO weightClassBO = new WeightClassBO();
		weightClassBO.setTitle("from controller");
		weightClassBO.setUnit(15);
		weightClassBO.setValue(10);
		return weightClassBO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private LengthClassBO getLengthClassBO(ProductBO productBO) {
		LengthClassBO lengthClassBO = new LengthClassBO();
		lengthClassBO.setTitle("from controller");
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
		sellerBO.setFirstName("from controller");
		sellerBO.setLastName("controller");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");
		sellerBO.setStoreBO(getStoreBO(sellerBO));
		sellerBO.setAddressBO(getAddressBO(sellerBO));

		try {
			sellerController.addSeller(sellerBO, null, null, new MockHttpServletRequest(), new MockHttpSession());
		} catch (Exception e) {
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
