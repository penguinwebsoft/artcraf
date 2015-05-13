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

import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.ProductAttributeDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.dataobjects.ProductDiscountDO;
import com.crafart.dataobjects.ProductShippingDO;
import com.crafart.dataobjects.ProductSpecialDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.TaxRateDO;
import com.crafart.dataobjects.TaxRuleDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.LengthClassDAO;
import com.crafart.inter.data.ProductAttributeDAO;
import com.crafart.inter.data.ProductDAO;
import com.crafart.inter.data.ProductDescriptionDAO;
import com.crafart.inter.data.ProductDiscountDAO;
import com.crafart.inter.data.ProductShippingDAO;
import com.crafart.inter.data.ProductSpecialDAO;
import com.crafart.inter.data.TaxRateDAO;
import com.crafart.inter.data.TaxRuleDAO;
import com.crafart.inter.data.WeightClassDAO;
import com.crafart.inter.service.ManageProductService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.ProductAttributeBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.ProductDiscountBO;
import com.crafart.service.businessobjects.ProductShippingBO;
import com.crafart.service.businessobjects.ProductSpecialBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.businessobjects.TaxRateBO;
import com.crafart.service.businessobjects.TaxRuleBO;
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

	@Autowired
	private ProductShippingDAO productShippingDAOImpl;

	@Autowired
	private ProductAttributeDAO productAttributeDAOImpl;

	@Autowired
	private TaxRateDAO taxRateDAOImpl;

	@Autowired
	private TaxRuleDAO taxRuleDAOImpl;

	/**
	 * mapping is done by mapProductBOToDO by this we are mapping BO objects to
	 * DO then calling data access addProduct method by productDO object
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addProduct(ProductBO productBO) throws CrafartServiceException {
		WeightClassBO weightClassBO = productBO.getWeightClassBO();
		SellerBO sellerBO = productBO.getSellerBO();
		SellerDO sellerDO = beanMapper.mapSellerBOToDO(sellerBO, new SellerDO());
		WeightClassDO weightClassDO = beanMapper.mapWeightClassBOToDO(weightClassBO, new WeightClassDO());
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		ProductDO productDO = beanMapper.mapProductBOToDO(productBO, new ProductDO(), weightClassDO, sellerDOs);
		ProductDescriptionBO productDescriptionBO = productBO.getProductDescriptionBO();
		ProductDescriptionDO productDescriptionDO = beanMapper.mapProductDescriptionBOToDO(productDescriptionBO, new ProductDescriptionDO(), productDO);
		productDO.setWeightClassDO(weightClassDO);
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
		/**
		 * getting list of ProductShipping objects from productBO and mapping is
		 * done using beanMapper
		 */
		List<ProductShippingBO> productShippingBOs = productBO.getProductShippingBOs();
		List<ProductShippingDO> productShippingDOs = new ArrayList<>();
		for (ProductShippingBO productShippingBO : productShippingBOs) {
			ProductShippingDO productShippingDO = beanMapper.mapPoductShippingBOToDO(productShippingBO, new ProductShippingDO(), productDO);
			productShippingDOs.add(productShippingDO);
		}
		/**
		 * getting list of ProductAttribute objects from productBO and mapping
		 * is done using beanMapper
		 */
		List<ProductAttributeBO> productAttributeBOs = productBO.getProductAttributeBOs();
		List<ProductAttributeDO> productAttributeDOs = new ArrayList<>();
		for (ProductAttributeBO productAttributeBO : productAttributeBOs) {
			ProductAttributeDO productAttributeDO = beanMapper.mapProductAttributeBOToDO(productAttributeBO, new ProductAttributeDO(), productDO);
			productAttributeDOs.add(productAttributeDO);
		}
		/**
		 * getting TaxRate object from productBO and mapping is done using
		 * beanMapper
		 */
		TaxRateBO taxRateBO = productBO.getTaxRateBO();
		TaxRateDO taxRateDO = beanMapper.mapTaxRateBOToDO(taxRateBO, new TaxRateDO(), productDO);

		List<TaxRuleBO> taxRuleBOs = taxRateBO.getTaxRuleBOs();
		List<TaxRuleDO> taxRuleDOs = new ArrayList<>();
		for (TaxRuleBO taxRuleBO : taxRuleBOs) {
			TaxRuleDO taxRuleDO = beanMapper.mapTaxRuleBOToDO(taxRuleBO, new TaxRuleDO(), taxRateDO);
			taxRuleDOs.add(taxRuleDO);
		}

		try {
			weightClassDAOImpl.addWeightClass(weightClassDO);
			productDAOImpl.addProduct(productDO);
			productDescriptionDAOImpl.addDescription(productDescriptionDO);
			productSpecialDAOImpl.addProductSpecial(productSpecialDOs);
			productDiscountDAOImpl.addProductDiscount(productDiscountDOs);
			productShippingDAOImpl.addProductShipping(productShippingDOs);
			productAttributeDAOImpl.addProductAttribute(productAttributeDOs);
			taxRateDAOImpl.addTaxRate(taxRateDO);
			taxRuleDAOImpl.addTaxRule(taxRuleDOs);

			productBO.setProductId(productDO.getProductId());
			productBO.getWeightClassBO().setWeightClassId(productDO.getWeightClassDO().getWeightClassId());
		} catch (CrafartDataException crafartDataException) {
			throw new CrafartServiceException("error in adding product detail to DB", crafartDataException);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ProductBO getProductDetail(long productId) throws CrafartServiceException {
		ProductBO productBO = new ProductBO();
		try {
			ProductDO productDO = productDAOImpl.getProductDetail(productId);
			SellerDO sellerDO = productDO.getSellerDOs().get(0);
			List<AddressDO> addressDOs = sellerDO.getAddressDOs();
			for (AddressDO addressDO : addressDOs) {
				productBO = beanMapper.mapProductDOToBO(
						productDO,
						new ProductBO(),
						beanMapper.mapSellerDOToBO(sellerDO, new SellerBO(), beanMapper.mapAddressDOToBO(addressDO, new AddressBO()),
								beanMapper.mapStoreDOToBO(sellerDO.getStoreDO(), new StoreBO(), null)));
			}

		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriving product details", cdExp);
		}
		return productBO;

	}

}
