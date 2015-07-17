/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.CommisionDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
public interface CommissionDAO {

	public void addCommision(CommisionDO commissionDO) throws CrafartDataException;
	
	public List<CommisionDO> getCommisions() throws CrafartDataException;
}
