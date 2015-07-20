/**
 * 
 */
package com.crafart.seller.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.InformationDO;
import com.crafart.dataobjects.SeoDO;
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

	/**
	 * Map information business object to data object which passed to data layer
	 * for adding information
	 * 
	 * @param informationBO
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addInformation(InformationBO informationBO) throws CrafartServiceException {
		if (informationBO.getInformationId() > 0) {
			updateInformation(informationBO);
		} else {
			InformationDO informationDO = beanMapper.mapInformationBOToDO(informationBO, new InformationDO());
			SeoDO seoDO = beanMapper.mapSeoBOToDO(informationBO.getSeoBO(), new SeoDO());
			informationDO.setSeoDO(seoDO);
			try {
				informationDAOImpl.addInformation(informationDO);
				informationBO.setInformationId(informationDO.getInformationId());
				informationBO.getSeoBO().setSeoId(informationDO.getSeoDO().getSeo_id());
			} catch (CrafartDataException cdExp) {
				throw new CrafartServiceException("Error while adding information", cdExp);
			}
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, InformationBO> getInformations() throws CrafartServiceException {
		Map<Long, InformationBO> informationBOs = new HashMap<>();
		try {
			List<InformationDO> informationDOs = informationDAOImpl.getInformations();
			for (InformationDO informationDO : informationDOs) {
				InformationBO informationBO = beanMapper.mapInformationDOToBO(informationDO, new InformationBO());
				informationBOs.put(informationBO.getInformationId(), informationBO);
			}
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("Error while retriveing from DB", e);
		}
		return informationBOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateInformation(InformationBO informationBO) throws CrafartServiceException {
		try {
			InformationDO informationDO = informationDAOImpl.getInformation(informationBO.getInformationId());
			informationDO = beanMapper.mapInformationBOToDO(informationBO, informationDO);
			SeoDO seoDO = beanMapper.mapSeoBOToDO(informationBO.getSeoBO(), informationDO.getSeoDO());
			informationDO.setSeoDO(seoDO);
			informationDAOImpl.updateInformation(informationDO);
			informationBO.setInformationId(informationDO.getInformationId());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding information", cdExp);
		}
	}

}
