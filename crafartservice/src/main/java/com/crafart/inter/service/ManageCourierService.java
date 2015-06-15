/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageCourierService {

	public void addCourierDetail(CourierBO courierBO) throws CrafartServiceException;

	public List<CourierBO> getCourierDetail() throws CrafartServiceException;
	


}
