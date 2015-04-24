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

import com.crafart.dataobjects.CourierDO;
import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductShippingDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CourierDAO;
import com.crafart.inter.data.GeoZoneDAO;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.ProductShippingDAO;
import com.crafart.inter.data.SellerDAO;
import com.crafart.inter.data.WeightClassDAO;

/**
 * @author Karthi
 *
 */
/**
 * Unit test for simple App.
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProductShippingDAOTest {

	@Autowired
	private ProductShippingDAO productShippingDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private SellerDAO sellerDAOImpl;

	@Autowired
	private ProductDAO productDAOImpl;

	@Autowired
	private CourierDAO courierDAOImpl;

	@Autowired
	private GeoZoneDAO geoZoneDAOImpl;

	@Test
	@Rollback(true)
	public void testAddProductShipping() {
		List<ProductShippingDO> productShippingDOs = getProductShipping();
		try {
			productShippingDAOImpl.addProductShipping(productShippingDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private List<ProductShippingDO> getProductShipping() {
		List<ProductShippingDO> productShippingDOs = new ArrayList<>();
		ProductDO productDO = getProduct();
		CourierDO courierDO = getCourier();
		GeoZoneDO geoZoneDO = getGeoZone();
		ProductShippingDO productShippingDO = new ProductShippingDO();
		productShippingDO.setCourierId(courierDO.getCourierId());
		productShippingDO.setGeoZoneId(geoZoneDO.getGeoZoneId());
		productShippingDO.setProductDO(productDO);
		productShippingDO.setShippingRate(125);
		ProductShippingDO productShippingDO2 = new ProductShippingDO();
		productShippingDO2.setCourierId(courierDO.getCourierId());
		productShippingDO2.setGeoZoneId(geoZoneDO.getGeoZoneId());
		productShippingDO2.setProductDO(productDO);
		productShippingDO2.setShippingRate(154);
		productShippingDOs.add(productShippingDO2);
		productShippingDOs.add(productShippingDO);
		return productShippingDOs;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private GeoZoneDO getGeoZone() {
		GeoZoneDO geoZoneDO = new GeoZoneDO();
		geoZoneDO.setDescription("qwerty");
		geoZoneDO.setName("Maharastra");
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
			geoZoneDO.setGeoZoneId(geoZoneDO.getGeoZoneId());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return geoZoneDO;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private CourierDO getCourier() {
		CourierDO courierDO = new CourierDO();
		courierDO.setImage("asdfgh");
		courierDO.setName("TRACK");
		courierDO.setProductLimit(1);
		courierDO.setSortOrder(1);
		try {
			courierDAOImpl.addCourierDetail(courierDO);
			courierDO.setCourierId(courierDO.getCourierId());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		return courierDO;
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
		}
		return sellerDO;

	}

}
