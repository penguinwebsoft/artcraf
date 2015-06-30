/**
 * 
 */
package com.crafart.inter.data;

import com.crafart.dataobjects.CustomerDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface CustomerDAO {

	public void addCustomer(CustomerDO customerDO) throws CrafartDataException;

	public CustomerDO getCustomerDetails(long customerId) throws CrafartDataException;

	public void updateCustomerDetails(CustomerDO customerDO) throws CrafartDataException;

}
