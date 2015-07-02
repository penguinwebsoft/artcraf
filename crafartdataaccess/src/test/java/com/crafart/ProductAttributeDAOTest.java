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

import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.CommisionDO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductAttributeDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.SeoDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeGroupDescDAO;
import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.data.CommissionDAO;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.data.ProductAttributeDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.SeoDAO;
import com.crafart.inter.data.WeightClassDAO;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProductAttributeDAOTest {

	@Autowired
	private ProductAttributeDAO productAttributeDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Autowired
	private ProductDAO productDAOImpl;
	
	@Autowired
	private CommissionDAO commissionDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private AttributeGroupDescDAO attributeGroupDescDAOImpl;
	
	@Autowired
	private CategoryDAO categoryDAOImpl;
	
	@Autowired
	private SeoDAO seoDAOImpl;


	/*
	 * Test case to add data in product attribute table
	 */
	@Test
	@Rollback(true)
	public void testAddProductAttribute() {
		List<ProductAttributeDO> productAttributeDOs = getProductAttribute();
		try {
			productAttributeDAOImpl.addProductAttribute(productAttributeDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case is to retrieve details from category table
	 */
	@Test
	@Rollback(true)
	public void testGetProductAttribute() {
		try {
			List<ProductAttributeDO> productAttributeDOs1 = getProductAttribute();
			try {
				productAttributeDAOImpl.addProductAttribute(productAttributeDOs1);
			} catch (CrafartDataException cdExp) {
				cdExp.printStackTrace();
				Assert.fail();
			}
			long productId = 0;
			for (ProductAttributeDO productAttributeDO : productAttributeDOs1) {
				productId = productAttributeDO.getProductDO().getProductId();
			}
			List<ProductAttributeDO> productAttributeDOs = productAttributeDAOImpl.getProductAttribute(productId);
			Assert.assertNotNull("List of AttribteDO is null", productAttributeDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private List<ProductAttributeDO> getProductAttribute() {
		List<ProductAttributeDO> productAttributeDOs = new ArrayList<>();
		ProductAttributeDO productAttributeDO = new ProductAttributeDO();
		ProductDO productDO = getProduct();
		productAttributeDO.setAttributeGroupId(getAttributeGroupDesc().getAtrributeGroupDescId());
		productAttributeDO.setText("Black&green");
		productAttributeDO.setSortOrder(1);
		productAttributeDO.setProductDO(productDO);
		ProductAttributeDO productAttributeDO2 = new ProductAttributeDO();
		productAttributeDO2.setText("brown");
		productAttributeDO2.setAttributeGroupId(getAttributeGroupDesc().getAtrributeGroupDescId());
		productAttributeDO2.setSortOrder(2);
		productAttributeDO2.setProductDO(productDO);
		productAttributeDOs.add(productAttributeDO2);
		productAttributeDOs.add(productAttributeDO);
		return productAttributeDOs;
	}

	
	public AttributeGroupDescDO getAttributeGroupDesc() {
		AttributeGroupDescDO attributeGroupDescDO = new AttributeGroupDescDO();
		attributeGroupDescDO.setAttributeGroupName("model");
		attributeGroupDescDO.setSortOrder(1);
		try {
			attributeGroupDescDAOImpl.addAttributeGroupDesc(attributeGroupDescDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return attributeGroupDescDO;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public ProductDO getProduct() {
		SellerDO sellerDO = getSellerDO();
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		ProductDO productDO = new ProductDO();
		productDO.setCategoryId(getCategory().getCategoryId());
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
	private CommisionDO getCommission() {
		CommisionDO commissionDO = new CommisionDO();
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
		sellerDO.setCommisionDO(getCommission());
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
