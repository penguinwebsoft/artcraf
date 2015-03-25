/**
 * 
 */
package com.crafart;

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
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.ManageGeoZoneService;
import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@ContextConfiguration({ "classpath:crafartdatasource-context-test.xml", "classpath:crafartservice-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class ManageGeoZoneServiceTest {

	@Autowired
	public ManageGeoZoneService manageGeoZoneServiceImpl;

	@Test
	@Rollback(true)
	public void testAddGeozoneDetail() {
		GeoZoneBO geoZoneBO = getGeoZone();
		try {
			manageGeoZoneServiceImpl.addGeoZoneDetail(geoZoneBO);
		} catch (CrafartServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	private GeoZoneBO getGeoZone() {
		GeoZoneBO geoZoneBO = new GeoZoneBO();
		geoZoneBO.setDescription("jlk");
		geoZoneBO.setName("Kerala");
		return geoZoneBO;
	}

	@Test
	@Rollback(true)
	public void testGetGeoZoneDetail() {
		GeoZoneBO geoZoneBO = getGeoZone();
		try {
			manageGeoZoneServiceImpl.addGeoZoneDetail(geoZoneBO);
		} catch (CrafartServiceException e1) {
			Assert.fail();
			e1.printStackTrace();
		}
		try {
			List<GeoZoneBO> geoZoneBOs = manageGeoZoneServiceImpl.getGeoZoneDetail();
			/*
			 * for (GeoZoneBO geoZoneBO2 : geoZoneBOs) {
			 * System.out.print("\n"+geoZoneBO2.getGeoZoneId()); }
			 */
		} catch (CrafartServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
