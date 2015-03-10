/**
 * 
 */
package com.crafart.data;

import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
public interface StoreDAO {

	public void addStoreDetail(StoreDO storeDO) throws CrafartDataException;
}
