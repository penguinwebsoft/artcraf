/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

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

	public List<LengthClassDO> getLengthClasses() throws CrafartDataException;
	
	public LengthClassDO getLengthClass(long lengthClassId) throws CrafartDataException;
}
