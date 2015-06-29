/**
 * 
 */
package com.crafart.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.LengthClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.service.ManageLengthClassService;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageLengthClassImpl")
public class ManageLengthClassServiceImpl implements ManageLengthClassService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addLengthClassDetail(LengthClassBO lengthClassBO) throws CrafartServiceException {
		LengthClassDO lengthClassDO = beanMapper.mapLengthClassBOToDO(lengthClassBO, new LengthClassDO());
		try {
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
			lengthClassBO.setLengthClassId(lengthClassDO.getLengthClassId());
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Error while adding lengthclass", cDExp);
		}
	}

	@Override
	public List<LengthClassBO> getLengthClassDetail() throws CrafartServiceException {
		
		List<LengthClassBO> lengthClassBOs = new ArrayList<>();
		try {
			List<LengthClassDO> lengthClassDOs = lengthClassDAOImpl.getLengthClass();
			for (LengthClassDO lengthClassDO : lengthClassDOs) {
				
				LengthClassBO lengthClassBO = beanMapper.mapLengthClassDOToBO(lengthClassDO, new LengthClassBO());
				lengthClassBOs.add(lengthClassBO);
			}
		} catch (CrafartDataException cDExp) {
			throw new CrafartServiceException("Service Error while retriveing all lengthClass details", cDExp);
		}
		return lengthClassBOs;
}
	}
