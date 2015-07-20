/**
 * 
 */
package com.crafart;

import java.util.Map;

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

import com.crafart.inter.service.ManageGeoZoneService;
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
	public void testAddGeozone() {
		GeoZoneBO geoZoneBO = getGeoZone();
		try {
			manageGeoZoneServiceImpl.addGeoZone(geoZoneBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Rollback(true)
	public void testUpdateGeozone() {
		GeoZoneBO geoZoneBO = getGeoZone();
		try {
			manageGeoZoneServiceImpl.addGeoZone(geoZoneBO);
			geoZoneBO.setName("geozone update");
			manageGeoZoneServiceImpl.updateGeoZone(geoZoneBO);
			Assert.assertEquals("geozone update", geoZoneBO.getName());
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
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
			manageGeoZoneServiceImpl.addGeoZone(geoZoneBO);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
		try {
			Map<Long, GeoZoneBO> geoZoneBOs = manageGeoZoneServiceImpl.getGeoZones();
			int count = 0;
			for (Map.Entry<Long, GeoZoneBO> geoZoneBOEntries : geoZoneBOs.entrySet()) {
				if (geoZoneBO.getGeoZoneId() == geoZoneBOEntries.getValue().getGeoZoneId()) {
					count = count + 1;
				}
			}
			Assert.assertTrue(count == 1);
		} catch (CrafartServiceException csExp) {
			csExp.printStackTrace();
			Assert.fail();
		}
	}
}
