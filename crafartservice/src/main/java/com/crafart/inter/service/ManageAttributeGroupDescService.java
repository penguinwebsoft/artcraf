/**
 * 
 */
package com.crafart.inter.service;

import java.util.List;

import com.crafart.service.businessobjects.AttributeGroupDescBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * 
 */
public interface ManageAttributeGroupDescService {

	public List<AttributeGroupDescBO> getAttributeGroupDesc() throws CrafartServiceException;
}
