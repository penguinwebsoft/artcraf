/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.CourierDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface CourierDAO {

	public void addCourierDetail(CourierDO courierDO) throws CrafartDataException;

	public List<CourierDO> getCourierDetail() throws CrafartDataException;
}
