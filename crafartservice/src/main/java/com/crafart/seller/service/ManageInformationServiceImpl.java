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

import com.crafart.dataobjects.InformationDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.InformationDAO;
import com.crafart.inter.service.ManageInformationService;
import com.crafart.service.businessobjects.InformationBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author
 * 
 */
@Service("manageInformationServiceImpl")
public class ManageInformationServiceImpl implements ManageInformationService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private InformationDAO informationDAOImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addInformationDetail(InformationBO informationBO) throws CrafartServiceException {
		InformationDO informationDO = beanMapper.mapInformationBOToDO(informationBO, new InformationDO());
		try {
			informationDAOImpl.addInformationDetail(informationDO);
			informationBO.setInformationId(informationDO.getInformationId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding information", cdExp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<InformationBO> getInformationDetail() throws CrafartServiceException {
		List<InformationBO> informationBOs = new ArrayList<>();
		try {
			List<InformationDO> informationDOs = informationDAOImpl.getInformationDetail();
			for (InformationDO informationDO : informationDOs) {
				InformationBO informationBO = beanMapper.mapInformationDOToBO(informationDO, new InformationBO());
				informationBOs.add(informationBO);
			}
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("Error while retriveing from DB", e);
		}
		return informationBOs;
	}

}
