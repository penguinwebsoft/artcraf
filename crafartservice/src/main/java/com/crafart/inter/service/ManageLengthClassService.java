/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
@Service
public interface ManageLengthClassService {

	public void addLengthClassDetail(LengthClassBO lengthClassBO) throws CrafartServiceException;

	public List<LengthClassBO> getLengthClassDetail() throws CrafartServiceException;
}
