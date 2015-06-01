/**
 * 
 */
package com.crafart.seller.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.StoreDAO;
import com.crafart.inter.service.ManageStoreService;
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

		StoreDO storeDO = beanMapper.mapStoreBOToDO(storeBO, new StoreDO(), beanMapper.mapSellerBOToDO(storeBO.getSellerBO(), new SellerDO()));
		try {
			storeDAOImpl.addStoreDetail(storeDO);
			storeBO.setStoreId(storeDO.getStoreId());
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Exception while adding store detail", crafartDataException);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public StoreBO checkStoreUrl(String storeUrl) throws CrafartServiceException {
		StoreBO storeBO = null;
		try {
			StoreDO storeDO = storeDAOImpl.checkStoreUrl(storeUrl);
			if (null != storeDO)
				storeBO = beanMapper.mapStoreDOToBO(storeDO, new StoreBO(), null);
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("Exception while getting store url", crafartDataException);
		}
		return storeBO;
	}

}
