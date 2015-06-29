/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.InformationDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author 
 * 
 */
public interface InformationDAO {

	public void addInformationDetail(InformationDO informationDO) throws CrafartDataException;

	public List<InformationDO> getInformationDetail() throws CrafartDataException;
}
