/**
 * 
 */
package com.crafart.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.LengthClassDAO;
import com.crafart.data.ProductDAO;
import com.crafart.data.ProductDescriptionDAO;
import com.crafart.data.WeightClassDAO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.WeightClassBO;
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

	@Autowired
	private ProductDescriptionDAO productDescriptionDAOImpl;

	@Autowired
	private WeightClassDAO weightClassDAOImpl;

	@Autowired
	private LengthClassDAO lengthClassDAOImpl;

	/**
	 * mapping is done by mapProductBOToDO by this we are mapping BO objects to
	 * DO then calling dataaccess addProduct method by productDO object
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProduct(ProductBO productBO) throws CrafartServiceException {
		WeightClassBO weightClassBO = productBO.getWeightClassBO();
		WeightClassDO weightClassDO = beanMapper.mapWeightClassBOToDO(weightClassBO, new WeightClassDO());
		LengthClassBO lengthClassBO = productBO.getLengthClassBO();
		LengthClassDO lengthClassDO = beanMapper.mapLengthClassBOToDO(lengthClassBO, new LengthClassDO());
		ProductDO productDO = beanMapper.mapProductBOToDO(productBO, new ProductDO(), weightClassDO, lengthClassDO);
		ProductDescriptionBO productDescriptionBO = productBO.getProductDescriptionBO();
		ProductDescriptionDO productDescriptionDO = beanMapper.mapProductDescriptionBOToDO(productDescriptionBO, new ProductDescriptionDO(), productDO);
		productDO.setWeightClassDO(weightClassDO);
		productDO.setLengthClassDO(lengthClassDO);
		try {
			weightClassDAOImpl.addWeightClass(weightClassDO);
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
			productDAOImpl.addProduct(productDO);
			productDescriptionDAOImpl.addDescription(productDescriptionDO);
			productBO.setProductId(productDO.getProductId());
			productBO.getLengthClassBO().setLengthClassId(productDO.getLengthClassDO().getLengthClassId());
			productBO.getWeightClassBO().setWeightClassId(productDO.getWeightClassDO().getWeightClassId());
		} catch (CrafartDataException crafartDataException) {
			log.error("Exception while adding ProductId " + productBO.getProductId());
			crafartDataException.printStackTrace();
		}
	}

}
