/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.InformationBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author 
 * 
 */
@Service
public interface ManageInformationService {

	public void addInformationDetail(InformationBO informationBO) throws CrafartServiceException;

	public List<InformationBO> getInformationDetail() throws CrafartServiceException;
}
