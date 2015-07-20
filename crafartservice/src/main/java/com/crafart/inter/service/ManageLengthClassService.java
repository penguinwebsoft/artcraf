/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageLengthClassService {

	public void addLengthClass(LengthClassBO lengthClassBO) throws CrafartServiceException;

	public void updateLengthClass(LengthClassBO lengthClassBO) throws CrafartServiceException;

	public Map<Long, LengthClassBO> getLengthClass() throws CrafartServiceException;
}
