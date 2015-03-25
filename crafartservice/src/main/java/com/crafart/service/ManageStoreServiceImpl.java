/**
 * 
 */
package com.crafart.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.StoreDAO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Service("ManageStoreServiceImpl")
public class ManageStoreServiceImpl implements ManageStoreService {

	public static final Logger log = Logger.getLogger(ManageAccountServiceImpl.class);

	@Autowired
	private StoreDAO storeDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	/**
	 * mapping is done from BO to DO after mapping we are calling dataaccess
	 * addStoreDetail method
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addStoreDetail(StoreBO storeBO) throws CrafartServiceException {

		StoreDO storeDO = beanMapper.mapStoreBOToDO(storeBO, new StoreDO(), new SellerDO());
		try {
			storeDAOImpl.addStoreDetail(storeDO);
			storeBO.setStoreId(storeDO.getStoreId());
		} catch (CrafartDataException crafartDataException) {
			log.error("Exception while adding store detail, storeId id " + storeBO.getStoreId());
			crafartDataException.printStackTrace();
		}
	}

}
