/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.OrderStatusDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author
 * 
 */
public interface OrderStatusDAO {

	public void addOrderStatusDetail(OrderStatusDO orderStatusDO) throws CrafartDataException;

	public List<OrderStatusDO> getOrderStatusDetail() throws CrafartDataException;
}
