/**
 * 
 */
package com.crafart.inter.service;

import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
public interface ManageStoreService {

	public void addStoreDetail(StoreBO storeBO) throws CrafartServiceException;

	public StoreBO checkStoreUrl(String storeUrl) throws CrafartServiceException;
}
