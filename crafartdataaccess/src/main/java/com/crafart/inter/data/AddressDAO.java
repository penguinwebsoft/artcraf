/**
 * 
 */
package com.crafart.inter.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.AddressDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
@Repository("addressDAO")
public interface AddressDAO {

	public void addAddress(AddressDO addressDO) throws CrafartDataException;
}
