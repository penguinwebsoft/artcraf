/**
 * 
 */
package com.crafart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.LengthClassDAO;
import com.crafart.data.ProductDAO;
import com.crafart.data.ProductDescriptionDAO;
import com.crafart.data.ProductDiscountDAO;
import com.crafart.data.ProductSpecialDAO;
import com.crafart.data.WeightClassDAO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.dataobjects.ProductDiscountDO;
import com.crafart.dataobjects.ProductSpecialDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.ProductDiscountBO;
import com.crafart.service.businessobjects.ProductSpecialBO;
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

	@Autowired
	private ProductSpecialDAO productSpecialDAOImpl;

	@Autowired
	private ProductDiscountDAO productDiscountDAOImpl;

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
		/**
		 * getting list of ProductSpecail objects from productBO and mapping is
		 * done using beanMapper
		 */
		List<ProductSpecialBO> productSpecialBOs = productBO.getProductSpecialBOs();
		List<ProductSpecialDO> productSpecialDOs = new ArrayList<>();
		for (ProductSpecialBO productSpecialBO2 : productSpecialBOs) {
			ProductSpecialDO productSpecialDO = beanMapper.mapProductSpecialBOToDO(productSpecialBO2, new ProductSpecialDO(), productDO);
			productSpecialDOs.add(productSpecialDO);
		}
		/**
		 * getting list of ProductDiscount objects from productBO and mapping is
		 * done using beanMapper
		 */
		List<ProductDiscountBO> productDiscountBOs = productBO.getProductDiscountBOs();
		List<ProductDiscountDO> productDiscountDOs = new ArrayList<>();
		for (ProductDiscountBO productDiscountBO2 : productDiscountBOs) {
			ProductDiscountDO productDiscountDO = beanMapper.mapProductDiscountBOToDO(productDiscountBO2, new ProductDiscountDO(), productDO);
			productDiscountDOs.add(productDiscountDO);
		}

		try {
			weightClassDAOImpl.addWeightClass(weightClassDO);
			lengthClassDAOImpl.addLengthClass(lengthClassDO);
			productDAOImpl.addProduct(productDO);
			productDescriptionDAOImpl.addDescription(productDescriptionDO);
			productSpecialDAOImpl.addProductSpecial(productSpecialDOs);
			productDiscountDAOImpl.addProductDiscount(productDiscountDOs);
			productBO.setProductId(productDO.getProductId());
			productBO.getLengthClassBO().setLengthClassId(productDO.getLengthClassDO().getLengthClassId());
			productBO.getWeightClassBO().setWeightClassId(productDO.getWeightClassDO().getWeightClassId());
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("error in adding product detail to DB", crafartDataException);
		}
	}

}
