/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.CommissionDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
public interface CommissionDAO {

	public void addCommission(CommissionDO commissionDO) throws CrafartDataException;
	
	public List<CommissionDO> getCommission() throws CrafartDataException;
}
