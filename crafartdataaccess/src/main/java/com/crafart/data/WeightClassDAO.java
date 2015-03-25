/**
 * 
 */
package com.crafart.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 * 
 */
@Repository("weightClassDAO")
public interface WeightClassDAO {

	public void addWeightClass(WeightClassDO weightClassDO) throws CrafartDataException;
}
