/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
public interface AttributeGroupDescDAO {

	public void addAttributeGroupDesc(AttributeGroupDescDO attributeGroupDescDO) throws CrafartDataException;
	
	public List<AttributeGroupDescDO> getAttributeGroupDesc() throws CrafartDataException;
}
