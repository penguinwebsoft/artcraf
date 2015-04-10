/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.CrafartOrderDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface CrafartOrderDAO {

	public void addCrafartOrder(CrafartOrderDO crafartOrderDO) throws CrafartDataException;

	public List<CrafartOrderDO> getCrafartOrder() throws CrafartDataException;

	public void updateCrafartOrder(CrafartOrderDO crafartOrderDO) throws CrafartDataException;
}
