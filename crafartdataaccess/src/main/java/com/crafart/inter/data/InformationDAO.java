/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.InformationDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author prabaharn periasamy
 * 
 */
public interface InformationDAO {

	public void addInformation(InformationDO informationDO) throws CrafartDataException;
	
	public void updateInformation(InformationDO informationDO) throws CrafartDataException;
	
	public InformationDO getInformation(long inforamtionId) throws CrafartDataException;

	public List<InformationDO> getInformations() throws CrafartDataException;
}
