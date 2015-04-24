/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.ContactDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface ContactDAO {

	public void addContact(List<ContactDO> contactDOs) throws CrafartDataException;

	public ContactDO findByEmailId(String eMailId) throws CrafartDataException;

}
