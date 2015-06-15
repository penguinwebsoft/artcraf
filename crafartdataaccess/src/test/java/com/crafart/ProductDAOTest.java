/**
 * 
 */
package com.crafart;

import java.util.ArrayList;
import java.util.List;

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

import com.crafart.data.ProductDAOImpl;
import com.crafart.data.SellerDAOImpl;
import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.CommissionDO;
import com.crafart.dataobjects.ContactDO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.SeoDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.SeoDAO;
import com.crafart.inter.data.WeightClassDAO;

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
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Autowired
	private CategoryDAO categoryDAOImpl;
	
	@Autowired
	private SeoDAO seoDAOImpl;
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
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private ProductDO getProduct() {
		ProductDO productDO = new ProductDO();
		List<SellerDO> sellerDOs = getSellerDO();
		productDO.setCategoryId(getCategory().getCategoryId());
		productDO.setDateAvailable("03-10-1982");
		productDO.setHeight(52);
		productDO.setImage("a15cb5e");
		productDO.setLength(63.2);
		productDO.setLocation("testing for fetching");
		productDO.setMinimum(26.00);
		productDO.setModel("service");
		productDO.setPoints(5);
		productDO.setPrice(12.2f);
		productDO.setSellerDOs(sellerDOs);
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
		return productDO;
	}
	
	
	public CategoryDO getCategory(){
		CategoryDO categoryDO = new CategoryDO();
		categoryDO.setImageLocation("");
		categoryDO.setSortOrder(2);
		categoryDO.setStatus(2);
		categoryDO.setSeoDO(getSeo());
		categoryDO.setDescription("Its gold jwellery");
		categoryDO.setCategoryName("gold");
		try {
			categoryDAOImpl.addCategory(categoryDO);
		} catch (CrafartDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryDO;
	}

	public SeoDO getSeo(){
		SeoDO seoDO = new SeoDO();
		seoDO.setMetaDesc("abc");
		seoDO.setMetaKeyword("cde");
		seoDO.setMetaTitle("jkl");
		try {
			seoDAOImpl.addSeo(seoDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return seoDO;
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
	private List<SellerDO> getSellerDO() {
		List<SellerDO> sellerDOs = new ArrayList<>();
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
		sellerDO.setStoreDO(getStoreDOs(sellerDO));
		sellerDOs.add(sellerDO);
		sellerDO.setAddressDOs(getAddressDOs(sellerDOs));
		sellerDO.setContactDOs(getContactDOs(sellerDOs));

		try {
			sellerDAOImpl.addSeller(sellerDO);
			sellerDO.setSellerId(sellerDO.getSellerId());
			sellerDOs.add(sellerDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
		}

		return sellerDOs;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<ContactDO> getContactDOs(List<SellerDO> sellerDOs) {
		List<ContactDO> contactDOs = new ArrayList<>();
		ContactDO contactDO = new ContactDO();
		contactDO.setContactTypeId(1);
		contactDO.setContactValue("9999900000");
		contactDO.setSellerDOs(sellerDOs);
		ContactDO contactDO2 = new ContactDO();
		contactDO2.setContactTypeId(2);
		contactDO2.setContactValue("044-505000");
		contactDO2.setSellerDOs(sellerDOs);
		ContactDO contactDO3 = new ContactDO();
		contactDO3.setContactTypeId(3);
		contactDO3.setContactValue("seller@iii.com");
		contactDO3.setSellerDOs(sellerDOs);
		ContactDO contactDO4 = new ContactDO();
		contactDO4.setContactTypeId(4);
		contactDO4.setContactValue("seller@iii.com");
		contactDO4.setSellerDOs(sellerDOs);
		contactDOs.add(contactDO);
		contactDOs.add(contactDO2);
		contactDOs.add(contactDO3);
		contactDOs.add(contactDO4);
		return contactDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private List<AddressDO> getAddressDOs(List<SellerDO> sellerDOs) {
		AddressDO addressDO = new AddressDO();
		addressDO.setCityId(1);
		addressDO.setPinCode("001100");
		addressDO.setSellerDOs(sellerDOs);
		addressDO.setStateId(2);
		addressDO.setStreet("qwertyuiop");
		List<AddressDO> addressDOs = new ArrayList<>();
		addressDOs.add(addressDO);
		return addressDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private StoreDO getStoreDOs(SellerDO sellerDO) {
		StoreDO storeDO = new StoreDO();
		storeDO.setName("store craf");
		storeDO.setStoreDescription("penguin store");
		storeDO.setStoreReturn("test desc");
		storeDO.setStoreUrl("acx");
		storeDO.setSellerDO(sellerDO);
		/*
		 * List<StoreDO> storeDOs = new ArrayList<>(); storeDOs.add(storeDO);
		 */
		return storeDO;
	}

	/*
	 * Test case is to retrieve single product detail from product table
	 */
	@Test
	@Rollback(true)
	public void testGetProductDetails() {
		try {
			ProductDO productDO1 = getProduct();
			productDAOImpl.addProduct(productDO1);
			ProductDO productDO = productDAOImpl.getProductDetail(productDO1.getProductId());
			for (SellerDO sellerDO : productDO.getSellerDOs()) {
				for (AddressDO addressDO : sellerDO.getAddressDOs()) {
					System.out.print(addressDO.getAddressId());
				}
			}
			Assert.assertNotNull(productDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case is to retrieve details from product table
	 */
	@Test
	@Rollback(true)
	public void testGetAllProduct() {
		try {
			ProductDO productDO1 = getProduct();
			productDAOImpl.addProduct(productDO1);
			List<ProductDO> productDOs = productDAOImpl.getAllProduct();
			Assert.assertNotNull(productDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}
}
