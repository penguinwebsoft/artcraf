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

import com.crafart.data.GeoZoneDAO;
import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.exception.CrafartDataException;

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

	@Test
	@Rollback(true)
	public void testAddGeoZoneDetail() {
		GeoZoneDO geoZoneDO = getGeoZone();
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	private GeoZoneDO getGeoZone() {
		GeoZoneDO geoZoneDO = new GeoZoneDO();
		geoZoneDO.setDescription("qwerty");
		geoZoneDO.setName("Delhi");
		return geoZoneDO;
	}

	@Test
	@Rollback(true)
	public void testgetGeoZoneDetail() {
		GeoZoneDO geoZoneDO = getGeoZone();
		try {
			geoZoneDAOImpl.addGeoZoneDetail(geoZoneDO);
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
		try {
			List<GeoZoneDO> geoZoneDOs = geoZoneDAOImpl.getGeoZoneDetail();
			/*
			 * for (GeoZoneDO geoZoneDO2 : geoZoneDOs) {
			 * System.out.print("\n"+geoZoneDO2.getGeoZoneId()); }
			 */
		} catch (CrafartDataException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
