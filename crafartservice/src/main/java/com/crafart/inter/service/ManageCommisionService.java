/**
 * 
 */
package com.crafart.inter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.CommisionBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 *
 */
@Service("ManageCommissionService")
public interface ManageCommisionService {

	public void addCommission(CommisionBO commissionBO) throws CrafartServiceException;

	public void updateCommission(CommisionBO commissionBO) throws CrafartServiceException;
		
	public Map<Long, CommisionBO> getCommisions()throws CrafartServiceException;
}
