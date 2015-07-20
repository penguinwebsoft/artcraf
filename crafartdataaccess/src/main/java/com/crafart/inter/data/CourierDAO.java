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

	public void addCourier(CourierDO courierDO) throws CrafartDataException;

	public CourierDO getCourier(long courierId) throws CrafartDataException;

	public List<CourierDO> getCouriers() throws CrafartDataException;
}
