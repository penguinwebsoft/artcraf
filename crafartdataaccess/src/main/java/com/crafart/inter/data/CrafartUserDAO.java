/**
 * 
 */
package com.crafart.inter.data;

import com.crafart.dataobjects.CrafartUserDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface CrafartUserDAO {

	public void addCrafartUser(CrafartUserDO crafartUserDO) throws CrafartDataException;

}
