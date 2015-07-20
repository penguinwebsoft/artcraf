package com.crafart;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.GeoZoneDAO;

/**
 * 
 * @author Karthi
 * 
 */
@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class GeoZoneDAOTest {

	@Autowired
	private GeoZoneDAO geoZoneDAOImpl;

	/*
	 * Test case to add data in geozone table
	 */
	@Test
	@Rollback(true)
	public void testAddGeoZoneDetail() {
		GeoZoneDO geoZoneDO = getGeoZone();
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateGeoZone() {
		GeoZoneDO geoZoneDO = getGeoZone();
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
			geoZoneDO.setName("Geozone updated");
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
			geoZoneDAOImpl.getGeoZone(geoZoneDO.getGeoZoneId());
			Assert.assertEquals("Geozone updated", geoZoneDO.getName());
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	/*
	 * Test case is to retrieve details from geozone table
	 */
	@Test
	@Rollback(true)
	public void testgetGeoZoneDetail() {
		GeoZoneDO geoZoneDO = getGeoZone();
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
		try {
			List<GeoZoneDO> geoZoneDOs = geoZoneDAOImpl.getGeoZoneDetail();
			Assert.assertNotNull(geoZoneDOs);
		} catch (CrafartDataException cdExp) {
			cdExp.printStackTrace();
			Assert.fail();
		}
	}

	private GeoZoneDO getGeoZone() {
		GeoZoneDO geoZoneDO = new GeoZoneDO();
		geoZoneDO.setDescription("qwerty");
		geoZoneDO.setName("Delhi");
		geoZoneDO.setSortOrder(1);
		return geoZoneDO;
	}
}
