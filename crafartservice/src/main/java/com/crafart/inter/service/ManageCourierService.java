/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageCourierService {

	public void addCourier(CourierBO courierBO) throws CrafartServiceException;

	public Map<Long, CourierBO> getCouriers() throws CrafartServiceException; 
	
	public void updateCourier(CourierBO courierBO) throws CrafartServiceException;

}
