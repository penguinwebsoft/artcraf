/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.InformationBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@Service
public interface ManageInformationService {

	public void addInformation(InformationBO informationBO) throws CrafartServiceException;

	public Map<Long, InformationBO> getInformations() throws CrafartServiceException;
	
	public void updateInformation(InformationBO informationBO) throws CrafartServiceException;
}
