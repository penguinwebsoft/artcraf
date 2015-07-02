/**
 * 
 */
package com.crafart.inter.service;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.CommisionBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 *
 */
@Service("ManageCommissionService")
public interface ManageCommissionService {

	public void addCommission(CommisionBO commissionBO) throws CrafartServiceException;

}
