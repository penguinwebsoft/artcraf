package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.service.businessobjects.GeoZoneBO;

@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class GeoZoneControllerTest {

	@Autowired
	private GeoZoneController geoZoneController;
	
	@Test
	@Rollback(true)
	public void testAddGeoZone() {
		try {
			GeoZoneBO geoZoneBO = getGeoZone();
			geoZoneController.addGeoZone(geoZoneBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	@Rollback(true)
	public void testUpdateGeoZone() {
		try {
			GeoZoneBO geoZoneBO = getGeoZone();
			geoZoneController.addGeoZone(geoZoneBO, new MockHttpSession());
			geoZoneController.updateGeoZone(geoZoneBO, new MockHttpSession());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	private GeoZoneBO getGeoZone() {
		GeoZoneBO geoZoneBO = new GeoZoneBO();
		geoZoneBO.setDescription("jlk");
		geoZoneBO.setName("Kerala");
		return geoZoneBO;
	}
}
