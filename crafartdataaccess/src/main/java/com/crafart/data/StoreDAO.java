/**
 * 
 */
package com.crafart.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("storeDAO")
public interface StoreDAO {

	public void addStoreDetail(StoreDO storeDO) throws CrafartDataException;
}
