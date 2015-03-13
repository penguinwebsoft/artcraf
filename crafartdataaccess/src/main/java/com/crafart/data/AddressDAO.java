/**
 * 
 */
package com.crafart.data;

import com.crafart.dataobjects.AddressDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 * 
 */
public interface AddressDAO {

	public void addAddress(AddressDO addressDO) throws CrafartDataException;
}
