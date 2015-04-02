/**
 * 
 */
package com.crafart.inter.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.LengthClassDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 * 
 */
@Repository("lengthClassDAO")
public interface LengthClassDAO {

	public void addLengthClass(LengthClassDO lengthClassDO) throws CrafartDataException;
}
