/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
@Repository("attributeGroupDescDAO")
public interface AttributeGroupDescDAO {

	public void addAttributeGroupDesc(AttributeGroupDescDO attributeGroupDescDO) throws CrafartDataException;
	
	public List<AttributeGroupDescDO> getAttributeGroupDesc() throws CrafartDataException;
}
