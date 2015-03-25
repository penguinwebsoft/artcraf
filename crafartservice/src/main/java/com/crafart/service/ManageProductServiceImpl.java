/**
 * 
 */
package com.crafart.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.ProductDAO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Service("ManageProductServiceImpl")
public class ManageProductServiceImpl implements ManageProductService {

	private static final Logger log = Logger.getLogger(ManageSellerServiceImpl.class);

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private ProductDAO productDAOImpl;

	/**
	 * mapping is done by mapProductBOToDO by this we are mapping BO objects to
	 * DO then calling dataaccess addProduct method by productDO object
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProduct(ProductBO productBO) throws CrafartServiceException {

		ProductDO productDO = beanMapper.mapProductBOToDO(productBO, new ProductDO());
		try {
			productDAOImpl.addProduct(productDO);
			productBO.setProductId(productDO.getProductId());
		} catch (CrafartDataException crafartDataException) {
			log.error("Exception while adding ProductId " + productBO.getProductId());
			crafartDataException.printStackTrace();
		}
	}

}
