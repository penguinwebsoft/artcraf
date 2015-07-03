/**
 * 
 */
package com.crafart.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.crafart.dataobjects.AccountDO;
import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.AttributeDO;
import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.dataobjects.BannerDO;
import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.CommisionDO;
import com.crafart.dataobjects.ContactDO;
import com.crafart.dataobjects.CourierDO;
import com.crafart.dataobjects.CrafartOrderDO;
import com.crafart.dataobjects.CrafartUserDO;
import com.crafart.dataobjects.CurrencyDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.dataobjects.InformationDO;
import com.crafart.dataobjects.InvoiceDO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.OrderStatusDO;
import com.crafart.dataobjects.ProductAttributeDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.dataobjects.ProductDiscountDO;
import com.crafart.dataobjects.ProductRatingDO;
import com.crafart.dataobjects.ProductReviewDO;
import com.crafart.dataobjects.ProductShippingDO;
import com.crafart.dataobjects.ProductSpecialDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.SeoDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.dataobjects.TaxClassDO;
import com.crafart.dataobjects.TaxRateDO;
import com.crafart.dataobjects.TaxRuleDO;
import com.crafart.dataobjects.UserDO;
import com.crafart.dataobjects.UserGroupDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.AttributeBO;
import com.crafart.service.businessobjects.AttributeGroupDescBO;
import com.crafart.service.businessobjects.BannerBO;
import com.crafart.service.businessobjects.BannerGroupBO;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.CommisionBO;
import com.crafart.service.businessobjects.ContactBO;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.businessobjects.CrafartOrderBO;
import com.crafart.service.businessobjects.CrafartUserBO;
import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.businessobjects.InformationBO;
import com.crafart.service.businessobjects.InvoiceBO;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.OrderStatusBO;
import com.crafart.service.businessobjects.ProductAttributeBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.ProductDiscountBO;
import com.crafart.service.businessobjects.ProductRatingBO;
import com.crafart.service.businessobjects.ProductReviewBO;
import com.crafart.service.businessobjects.ProductShippingBO;
import com.crafart.service.businessobjects.ProductSpecialBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.SeoBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.businessobjects.TaxClassBO;
import com.crafart.service.businessobjects.TaxRateBO;
import com.crafart.service.businessobjects.TaxRuleBO;
import com.crafart.service.businessobjects.UserBO;
import com.crafart.service.businessobjects.UserGroupBO;
import com.crafart.service.businessobjects.WeightClassBO;

/**
 * mapping from BO to DO and vice versa
 * 
 * @author Karthi
 * @version 1.0
 * 
 */
@Component("beanMapper")
public class BeanMapper {

	public SellerDO mapSellerBOToDO(SellerBO sellerBO, SellerDO sellerDO, CommisionDO commisionDO) {
		sellerDO.setApproved(sellerBO.getApproved());
		sellerDO.setCommisionDO(commisionDO);
		sellerDO.setCompanyLogo(sellerBO.getCompanyLogo());
		sellerDO.setCompanyName(sellerBO.getCompanyName());
		sellerDO.setCst_no(sellerBO.getCstNo());
		sellerDO.setEpch_no(sellerBO.getEpchNo());
		sellerDO.setFirstName(sellerBO.getFirstName());
		sellerDO.setLastName(sellerBO.getLastName());
		sellerDO.setSellerId(sellerBO.getSellerId());
		sellerDO.setStatus(sellerBO.getStatus());
		sellerDO.setTin_no(sellerDO.getStatus());
		sellerDO.setVat_no(sellerBO.getVatNo());
		sellerDO.setGender(sellerBO.getGender());
		sellerDO.setPassword(sellerBO.getPassword());
		sellerDO.setDateOfBirth(sellerBO.getDateOfBirth());
		return sellerDO;

	}

	public SellerBO mapSellerDOToBO(SellerDO sellerDO, SellerBO sellerBO, AddressBO addressBO, StoreBO storeBO, CommisionBO commissionBO) {
		sellerBO.setApproved(sellerDO.getApproved());
		sellerBO.setCommissionBO(commissionBO);
		sellerBO.setCompanyLogo(sellerDO.getCompanyLogo());
		sellerBO.setCompanyName(sellerDO.getCompanyName());
		sellerBO.setCstNo(sellerDO.getCst_no());
		sellerBO.setEpchNo(sellerDO.getEpch_no());
		sellerBO.setFirstName(sellerDO.getFirstName());
		sellerBO.setLastName(sellerDO.getLastName());
		sellerBO.setSellerId(sellerDO.getSellerId());
		sellerBO.setStatus(sellerDO.getStatus());
		sellerBO.setTinNo(sellerDO.getTin_no());
		sellerBO.setVatNo(sellerDO.getVat_no());
		sellerBO.setGender(sellerDO.getGender());
		sellerBO.setDateOfBirth(sellerDO.getDateOfBirth());
		sellerBO.setPassword(sellerDO.getPassword());
		sellerBO.setAddressBO(addressBO);
		sellerBO.setStoreBO(storeBO);
		return sellerBO;

	}

	public ProductDO mapProductBOToDO(ProductBO productBO, ProductDO productDO, WeightClassDO weightClassDO, List<SellerDO> sellerDOs) {
		productDO.setCategoryId(productBO.getCategoryId());
		productDO.setDateAvailable(productBO.getDateAvailable());
		productDO.setDateAvailable(productBO.getDateAvailable());
		productDO.setHeight(productBO.getHeight());
		productDO.setImage(productBO.getImage());
		productDO.setLength(productBO.getHeight());
		productDO.setLocation(productBO.getLocation());
		productDO.setMinimum(productBO.getMinimum());
		productDO.setModel(productBO.getModel());
		productDO.setPoints(productBO.getPoints());
		productDO.setPrice(productBO.getPrice());
		productDO.setProductId(productBO.getProductId());
		productDO.setQuantity(productBO.getQuantity());
		productDO.setSellerDOs(sellerDOs);
		productDO.setShipping(productBO.getShipping());
		productDO.setSku(productBO.getSku());
		productDO.setSortOrder(productBO.getSortOrder());
		productDO.setStatus(productBO.getStatus());
		productDO.setStockStatusId(productBO.getStockStatusId());
		productDO.setSubtract(productBO.getSubtract());
		productDO.setUpc(productBO.getUpc());
		productDO.setProductName(productBO.getProductName());
		productDO.setViewed(productBO.getViewed());
		productDO.setWeight(productBO.getWeight());
		productDO.setWeightClassDO(weightClassDO);
		productDO.setWidth(productBO.getWidth());
		return productDO;
	}

	public ProductBO mapProductDOToBO(ProductDO productDO, ProductBO productBO, SellerBO sellerBO, List<ProductAttributeBO> productAttributeBOs, List<ProductDiscountBO> productDiscountBOs) {
		productBO.setCategoryId(productDO.getCategoryId());
		productBO.setDateAvailable(productDO.getDateAvailable());
		productBO.setHeight(productDO.getHeight());
		productBO.setImage(productDO.getImage());
		productBO.setLength(productDO.getLength());
		productBO.setLocation(productDO.getLocation());
		productBO.setMinimum(productDO.getMinimum());
		productBO.setModel(productDO.getModel());
		productBO.setPoints(productDO.getPoints());
		productBO.setPrice(productDO.getPrice());
		productBO.setProductName(productDO.getProductName());
		productBO.setProductId(productDO.getProductId());
		productBO.setQuantity(productDO.getQuantity());
		productBO.setSellerBO(sellerBO);
		productBO.setShipping(productDO.getShipping());
		productBO.setSku(productDO.getSku());
		productBO.setSortOrder(productDO.getSortOrder());
		productBO.setStatus(productDO.getStatus());
		productBO.setStockStatusId(productDO.getStockStatusId());
		productBO.setSubtract(productDO.getSubtract());
		productBO.setUpc(productDO.getUpc());
		productBO.setViewed(productDO.getViewed());
		productBO.setWeight(productDO.getWeight());
		productBO.setWeightClassBO(null);
		productBO.setWidth(productDO.getWidth());
		productBO.setProductAttributeBOs(productAttributeBOs);
		productBO.setProductDiscountBOs(productDiscountBOs);
		/* productBO.setProductReviewBOs(productReviewBOs); */
		return productBO;

	}

	public AccountDO mapAccountBOToDO(AccountBO accountBO, AccountDO accountDO) {
		accountDO.setAccountId(accountBO.getAccountId());
		accountDO.setAccountName(accountBO.getAccountNumber());
		accountDO.setAccountNumber(accountBO.getAccountNumber());
		accountDO.setBankName(accountBO.getBankName());
		accountDO.setBranchName(accountBO.getBranchName());
		accountDO.setIfscCode(accountBO.getIfscCode());
		accountDO.setMicrCode(accountBO.getMicrCode());
		accountDO.setType(accountBO.getType());
		return accountDO;

	}

	public AccountBO mapAccountDOToBO(AccountDO accountDO, AccountBO accountBO) {
		accountBO.setAccountId(accountDO.getAccountId());
		accountBO.setAccountName(accountDO.getAccountName());
		accountBO.setAccountNumber(accountDO.getAccountNumber());
		accountBO.setBankName(accountDO.getBankName());
		accountBO.setIfscCode(accountDO.getIfscCode());
		accountBO.setBranchName(accountDO.getBranchName());
		accountBO.setMicrCode(accountDO.getMicrCode());
		accountBO.setType(accountDO.getType());
		return accountBO;
	}

	/*
	 * public List<StoreDO> mapStoreBOsToDOs(List<StoreBO> storeBOs){
	 * List<StoreDO> storeDOs = new ArrayList<>(); for(StoreBO storeBO :
	 * storeBOs){ StoreDO storeDO = mapStoreBOToDO(storeBO, new StoreDO());
	 * storeDOs.add(storeDO); } return storeDOs; }
	 */

	public StoreDO mapStoreBOToDO(StoreBO storeBO, StoreDO storeDO, SellerDO sellerDO) {
		storeDO.setName(storeBO.getName());
		storeDO.setSellerDO(sellerDO);
		storeDO.setStoreDescription(storeBO.getStoreDescription());
		storeDO.setStoreReturn(storeBO.getStoreReturn());
		storeDO.setStoreId(storeBO.getStoreId());
		storeDO.setStoreUrl(storeBO.getStoreUrl());
		return storeDO;

	}

	public StoreBO mapStoreDOToBO(StoreDO storeDO, StoreBO storeBO, SellerBO sellerBO) {
		storeBO.setName(storeDO.getName());
		storeBO.setStoreDescription(storeDO.getStoreDescription());
		storeBO.setStoreId(storeDO.getStoreId());
		storeBO.setStoreReturn(storeDO.getStoreReturn());
		storeBO.setStoreUrl(storeDO.getStoreUrl());
		storeBO.setSellerBO(sellerBO);
		return storeBO;

	}

	public AddressDO mapAddressBOToDO(AddressBO addressBO, AddressDO addressDO, SellerDO sellerDO, CustomerDO customerDO) {
		addressDO.setCityId(addressBO.getCityId());
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		addressDO.setSellerDOs(sellerDOs);
		addressDO.setPinCode(addressBO.getPinCode());
		addressDO.setStateId(addressBO.getStateId());
		addressDO.setStreet(addressBO.getStreet());
		List<CustomerDO> customerDOs = new ArrayList<>();
		customerDOs.add(customerDO);
		addressDO.setCustomerDOs(customerDOs);
		return addressDO;

	}

	public AddressBO mapAddressDOToBO(AddressDO addressDO, AddressBO addressBO) {
		addressBO.setAddressId(addressDO.getAddressId());
		addressBO.setCityId(addressDO.getCityId());
		addressBO.setPinCode(addressDO.getPinCode());
		addressBO.setStateId(addressDO.getStateId());
		addressBO.setStreet(addressDO.getStreet());
		return addressBO;

	}

	public WeightClassDO mapWeightClassBOToDO(WeightClassBO weightClassBO, WeightClassDO weightClassDO) {
		weightClassDO.setUnit(weightClassBO.getUnit());
		weightClassDO.setTitle(weightClassBO.getTitle());
		weightClassDO.setValue(weightClassBO.getValue());
		weightClassDO.setWeightClassId(weightClassBO.getWeightClassId());
		return weightClassDO;

	}

	public LengthClassDO mapLengthClassBOToDO(LengthClassBO lengthClassBO, LengthClassDO lengthClassDO) {
		lengthClassDO.setLengthClassId(lengthClassBO.getLengthClassId());
		lengthClassDO.setTitle(lengthClassBO.getTitle());
		lengthClassDO.setIsActive(lengthClassBO.getIsActive());
		return lengthClassDO;

	}
	public LengthClassBO mapLengthClassDOToBO(LengthClassDO lengthClassDO, LengthClassBO lengthClassBO) {
		lengthClassBO.setLengthClassId(lengthClassDO.getLengthClassId());
		lengthClassBO.setTitle(lengthClassDO.getTitle());
		lengthClassBO.setUnit(lengthClassDO.getUnit());
		lengthClassBO.setIsActive(lengthClassDO.getIsActive());
		lengthClassBO.setSortorder(lengthClassDO.getSortorder());
		
		return lengthClassBO;

	}


	public CategoryDO mapCategoryBOToDO(CategoryBO categoryBO, CategoryDO categoryDO, SeoDO seoDO) {
		categoryDO.setCategoryId(categoryBO.getCategoryId());
		categoryDO.setSeoDO(seoDO);
		categoryDO.setImageLocation(categoryBO.getImageLocation());
		categoryDO.setParentId(categoryBO.getParentId());
		categoryDO.setSortOrder(categoryBO.getSortOrder());
		categoryDO.setCategoryName(categoryBO.getCategoryName());
		categoryDO.setStatus(categoryBO.getStatus());
		categoryDO.setDescription(categoryBO.getDescription());
		return categoryDO;

	}

	public CategoryBO mapCategoryDOToBO(CategoryDO categoryDO, CategoryBO categoryBO, SeoBO seoBO) {
		categoryBO.setCategoryId(categoryDO.getCategoryId());
		SeoDO seoDO = categoryDO.getSeoDO();
		if(null != seoDO){
			categoryBO.setSeoBO(mapSeoDOToBO(seoDO, seoBO));
		}
		categoryBO.setImageLocation(categoryDO.getImageLocation());
		categoryBO.setParentId(categoryDO.getParentId());
		categoryBO.setSortOrder(categoryDO.getSortOrder());
		categoryBO.setDescription(categoryDO.getDescription());
		categoryBO.setStatus(categoryDO.getStatus());
		categoryBO.setCategoryName(categoryDO.getCategoryName());
		return categoryBO;

	}

	public SeoDO mapSeoBOToDO(SeoBO seoBO, SeoDO seoDO) {
		seoDO.setMetaDesc(seoBO.getMetaDesc());
		seoDO.setMetaKeyword(seoBO.getMetaKeyword());
		seoDO.setMetaTitle(seoBO.getMetaTitle());
		seoDO.setSeo_id(seoBO.getSeoId());
		return seoDO;

	}

	public SeoBO mapSeoDOToBO(SeoDO seoDO, SeoBO seoBO) {
		seoBO.setMetaDesc(seoDO.getMetaDesc());
		seoBO.setMetaKeyword(seoDO.getMetaKeyword());
		seoBO.setMetaTitle(seoDO.getMetaTitle());
		seoBO.setSeoId(seoDO.getSeo_id());
		return seoBO;

	}

	public AttributeDO mapAttributeBOToDO(AttributeBO attributeBO, AttributeDO attributeDO) {
		attributeDO.setAttributeId(attributeBO.getAttributeId());
		attributeDO.setAttributeName(attributeBO.getAttributeName());
		attributeDO.setSortOrder(attributeBO.getSortOrder());
		return attributeDO;
	}
	
	public AttributeBO mapAttributeDOToBO(AttributeDO attributeDO, AttributeBO attributeBO) {
		attributeBO.setAttributeId(attributeDO.getAttributeId());
		attributeBO.setAttributeName(attributeDO.getAttributeName());
		attributeBO.setSortOrder(attributeDO.getSortOrder());
		return attributeBO;
	}
	
	public AttributeGroupDescDO mapAttributeGroupDescBOToDO(AttributeGroupDescBO attributeGroupDescBO, AttributeGroupDescDO attributeGroupDescDO) {
		attributeGroupDescDO.setAtrributeGroupDescId(attributeGroupDescBO.getAtrributeGroupDescId());
		attributeGroupDescDO.setAttributeGroupName(attributeGroupDescBO.getAttributeGroupName());
		attributeGroupDescDO.setSortOrder(attributeGroupDescBO.getSortOrder());
		return attributeGroupDescDO;
	}

	public AttributeGroupDescBO mapAttributeGroupDescDOToBO(AttributeGroupDescDO attributeGroupDescDO, AttributeGroupDescBO attributeGroupDescBO) {
		attributeGroupDescBO.setAtrributeGroupDescId(attributeGroupDescDO.getAtrributeGroupDescId());
		attributeGroupDescBO.setAttributeGroupName(attributeGroupDescDO.getAttributeGroupName());
		attributeGroupDescBO.setSortOrder(attributeGroupDescDO.getSortOrder());
		return attributeGroupDescBO;

	}

	public ProductAttributeDO mapProductAttributeBOToDO(ProductAttributeBO productAttributeBO, ProductAttributeDO productAttributeDO, ProductDO productDO) {
		productAttributeDO.setAttributeGroupId(productAttributeBO.getAttributeGroupId());
		productAttributeDO.setAttributeId(productAttributeBO.getAttributeId());
		productAttributeDO.setProductDO(productDO);
		productAttributeDO.setSortOrder(productAttributeBO.getSortOrder());
		productAttributeDO.setText(productAttributeBO.getText());
		return productAttributeDO;

	}

	public ProductAttributeBO mapProductAttributeDOToBO(ProductAttributeDO productAttributeDO, ProductAttributeBO productAttributeBO) {
		productAttributeBO.setAttributeGroupId(productAttributeDO.getAttributeGroupId());
		productAttributeBO.setAttributeId(productAttributeDO.getAttributeId());
		productAttributeBO.setSortOrder(productAttributeDO.getSortOrder());
		productAttributeBO.setText(productAttributeDO.getText());
		return productAttributeBO;

	}

	public GeoZoneDO mapGeoZoneBOToDO(GeoZoneBO geoZoneBO, GeoZoneDO geoZoneDO) {
		geoZoneDO.setDescription(geoZoneBO.getDescription());
		geoZoneDO.setGeoZoneId(geoZoneBO.getGeoZoneId());
		geoZoneDO.setName(geoZoneBO.getName());
		return geoZoneDO;

	}

	public GeoZoneBO mapGeoZoneDOToBO(GeoZoneDO geoZoneDO, GeoZoneBO geoZoneBO) {
		geoZoneBO.setDescription(geoZoneDO.getDescription());
		geoZoneBO.setGeoZoneId(geoZoneDO.getGeoZoneId());
		geoZoneBO.setName(geoZoneDO.getName());
		return geoZoneBO;

	}

	public CourierDO mapCourierBOToDO(CourierBO courierBO, CourierDO courierDO) {
		courierDO.setCourierId(courierBO.getCourierId());
		courierDO.setImage(courierBO.getImage());
		courierDO.setCourierName(courierBO.getCourierName());
		courierDO
				.setEstimatedDeliveryTime(courierBO.getEstimatedDeliveryTime());
		courierDO.setSortOrder(courierBO.getSortOrder());
		return courierDO;

	}

	public CourierBO mapCourierDOToBO(CourierDO courierDO, CourierBO courierBO) {
		courierBO.setCourierId(courierDO.getCourierId());
		courierBO.setImage(courierDO.getImage());
		courierBO.setCourierName(courierDO.getCourierName());
		courierBO.setEstimatedDeliveryTime(courierDO.getEstimatedDeliveryTime());
		courierBO.setSortOrder(courierDO.getSortOrder());
		return courierBO;

	}

	public TaxClassDO mapTaxClassBOToDO(TaxClassBO taxClassBO, TaxClassDO taxClassDO) {
		taxClassDO.setDescription(taxClassBO.getDescription());
		taxClassDO.setTaxClassId(taxClassBO.getTaxClassId());
		taxClassDO.setTitle(taxClassBO.getTitle());
		return taxClassDO;

	}

	public TaxClassBO mapTaxClassDOToBO(TaxClassDO taxClassDO, TaxClassBO taxClassBO) {
		taxClassBO.setDescription(taxClassDO.getDescription());
		taxClassBO.setTaxClassId(taxClassDO.getTaxClassId());
		taxClassBO.setTitle(taxClassDO.getTitle());
		return taxClassBO;

	}

	public ProductDescriptionDO mapProductDescriptionBOToDO(ProductDescriptionBO productDescriptionBO, ProductDescriptionDO productDescriptionDO, ProductDO productDO) {
		productDescriptionDO.setMetaDescription(productDescriptionBO.getMetaDescription());
		productDescriptionDO.setProductDO(productDO);
		productDescriptionDO.setMetaKeyword(productDescriptionBO.getMetaKeyword());
		productDescriptionDO.setDescription(productDescriptionBO.getDescription());
		productDescriptionDO.setProductDescriptionId(productDescriptionBO.getProductDescriptionId());
		productDescriptionDO.setName(productDescriptionBO.getName());
		productDescriptionDO.setTag(productDescriptionBO.getTag());
		return productDescriptionDO;

	}

	public ProductSpecialDO mapProductSpecialBOToDO(ProductSpecialBO productSpecialBO, ProductSpecialDO productSpecialDO, ProductDO productDO) {
		productSpecialDO.setEndDate(productSpecialBO.getEndDate());
		productSpecialDO.setPrice(productSpecialBO.getPrice());
		productSpecialDO.setProductSpecialId(productSpecialBO.getProductSpecialId());
		productSpecialDO.setStartDate(productSpecialBO.getStartDate());
		productSpecialDO.setProductDO(productDO);
		productSpecialDO.setSellerId(productDO.getSellerDOs().get(0).getSellerId());
		return productSpecialDO;

	}

	public ProductDiscountDO mapProductDiscountBOToDO(ProductDiscountBO productDiscountBO, ProductDiscountDO productDiscountDO, ProductDO productDO) {
		productDiscountDO.setEndDate(productDiscountBO.getEndDate());
		productDiscountDO.setValue(productDiscountBO.getValue());
		productDiscountDO.setProductDiscountId(productDiscountBO.getProductDiscountId());
		productDiscountDO.setQuantity(productDiscountBO.getQuantity());
		productDiscountDO.setStartDate(productDiscountBO.getStartDate());
		productDiscountDO.setProductDO(productDO);
		productDiscountDO.setSellerId(productDO.getSellerDOs().get(0).getSellerId());
		return productDiscountDO;

	}

	public ProductDiscountBO mapProductDiscountDOToBO(ProductDiscountDO productDiscountDO, ProductDiscountBO productDiscountBO) {
		productDiscountBO.setEndDate(productDiscountDO.getEndDate());
		productDiscountBO.setValue(productDiscountDO.getValue());
		productDiscountBO.setProductDiscountId(productDiscountDO.getProductDiscountId());
		productDiscountBO.setQuantity(productDiscountDO.getQuantity());
		productDiscountBO.setStartDate(productDiscountDO.getStartDate());
		return productDiscountBO;

	}

	public ProductShippingDO mapPoductShippingBOToDO(ProductShippingBO productShippingBO, ProductShippingDO productShippingDO, ProductDO productDO) {
		productShippingDO.setCourierId(productShippingBO.getCourierId());
		productShippingDO.setGeoZoneId(productShippingBO.getGeoZoneId());
		productShippingDO.setProductDO(productDO);
		productShippingDO.setShippingRate(productShippingBO.getShippingRate());
		productShippingDO.setProductShippingId(productShippingBO.getProductShippingId());
		return productShippingDO;

	}

	public TaxRateDO mapTaxRateBOToDO(TaxRateBO taxRateBO, TaxRateDO taxRateDO, ProductDO productDO) {
		taxRateDO.setName(taxRateBO.getName());
		taxRateDO.setProductDO(productDO);
		taxRateDO.setRate(taxRateBO.getRate());
		taxRateDO.setSellerId(productDO.getSellerDOs().get(0).getSellerId());
		taxRateDO.setTaxRateId(taxRateBO.getSellerId());
		taxRateDO.setType(taxRateBO.getType());
		return taxRateDO;

	}

	public TaxRateBO mapTaxRateDOToBO(TaxRateDO taxRateDO, TaxRateBO taxRateBO, ProductBO productBO) {
		taxRateBO.setName(taxRateDO.getName());
		taxRateBO.setProductBO(productBO);
		taxRateBO.setRate(taxRateDO.getRate());
		taxRateBO.setSellerId(productBO.getSellerBO().getSellerId());
		taxRateBO.setTaxRateId(taxRateDO.getSellerId());
		taxRateBO.setType(taxRateDO.getType());
		return taxRateBO;

	}

	public TaxRuleDO mapTaxRuleBOToDO(TaxRuleBO taxRuleBO, TaxRuleDO taxRuleDO, TaxRateDO taxRateDO) {
		taxRuleDO.setBased(taxRuleBO.getBased());
		taxRuleDO.setPriority(taxRuleBO.getPriority());
		taxRuleDO.setTaxClassId(taxRuleBO.getTaxClassId());
		taxRuleDO.setTaxRuleId(taxRuleBO.getTaxRuleId());
		taxRuleDO.setValue(taxRuleBO.getValue());
		taxRuleDO.setTaxRateDO(taxRateDO);
		return taxRuleDO;

	}

	public CommisionDO mapCommissionBOToDO(CommisionBO commissionBO, CommisionDO commissionDO) {
		commissionDO.setCommissionId(commissionBO.getCommissionId());
		commissionDO.setName(commissionBO.getName());
		commissionDO.setSortOrder(commissionBO.getSortOrder());
		commissionDO.setType(commissionBO.getType());
		commissionDO.setValue(commissionBO.getValue());
		return commissionDO;

	}

	public CommisionBO mapCommissionDOToBO(CommisionDO commissionDO, CommisionBO commissionBO) {
		commissionBO.setCommissionId(commissionDO.getCommissionId());
		commissionBO.setName(commissionDO.getName());
		commissionBO.setSortOrder(commissionDO.getSortOrder());
		commissionBO.setType(commissionDO.getType());
		commissionBO.setValue(commissionDO.getValue());
		return commissionBO;

	}

	public CurrencyDO mapCurrencyBOToDO(CurrencyBO currencyBO, CurrencyDO currencyDO) {
		currencyDO.setCode(currencyBO.getCode());
		currencyDO.setCurrencyId(currencyBO.getCurrencyId());
		currencyDO.setDecimalPlace(currencyBO.getDecimalPlace());
		currencyDO.setStatus(currencyBO.getStatus());
		currencyDO.setSymbolLeft(currencyBO.getSymbolLeft());
		currencyDO.setSymbolRight(currencyBO.getSymbolRight());
		currencyDO.setTitle(currencyBO.getTitle());
		currencyDO.setValue(currencyBO.getValue());
		return currencyDO;

	}

	public CurrencyBO mapCurrencyDOToBO(CurrencyDO currencyDO, CurrencyBO currencyBO) {
		currencyBO.setCode(currencyDO.getCode());
		currencyBO.setCurrencyId(currencyDO.getCurrencyId());
		currencyBO.setDecimalPlace(currencyDO.getDecimalPlace());
		currencyBO.setStatus(currencyDO.getStatus());
		currencyBO.setSymbolLeft(currencyDO.getSymbolLeft());
		currencyBO.setSymbolRight(currencyDO.getSymbolRight());
		currencyBO.setTitle(currencyDO.getTitle());
		currencyBO.setValue(currencyDO.getValue());
		return currencyBO;

	}

	public CrafartUserDO mapCrafartUserBOToDO(CrafartUserBO crafartUserBO, CrafartUserDO crafartUserDO) {
		crafartUserDO.setFirstName(crafartUserBO.getFirstName());
		crafartUserDO.setIp(crafartUserBO.getIp());
		crafartUserDO.setLastName(crafartUserBO.getLastName());
		crafartUserDO.setPassword(crafartUserBO.getPassword());
		crafartUserDO.setSellerPermission(crafartUserBO.getSellerPermission());
		crafartUserDO.setStatus(crafartUserBO.getStatus());
		crafartUserDO.setUserGroupDO(null);
		crafartUserDO.setUserId(crafartUserBO.getUserId());
		crafartUserDO.setUserName(crafartUserBO.getUserName());
		return crafartUserDO;

	}

	public CrafartUserBO mapCrafartUserDOToBO(CrafartUserDO crafartUserDO, CrafartUserBO crafartUserBO) {
		crafartUserBO.setFirstName(crafartUserDO.getFirstName());
		crafartUserBO.setIp(crafartUserDO.getIp());
		crafartUserBO.setLastName(crafartUserDO.getLastName());
		crafartUserBO.setPassword(crafartUserDO.getPassword());
		crafartUserBO.setSellerPermission(crafartUserDO.getSellerPermission());
		crafartUserBO.setStatus(crafartUserDO.getStatus());
		crafartUserBO.setUserGroupBO(null);
		crafartUserBO.setUserId(crafartUserDO.getUserId());
		crafartUserBO.setUserName(crafartUserDO.getUserName());
		return crafartUserBO;

	}

	public CustomerDO mapCustomerBOToDO(CustomerBO customerBO, CustomerDO customerDO) {
		customerDO.setCustomerId(customerBO.getCustomerId());
		customerDO.setDateOfBirth(customerBO.getDateOfBirth());
		customerDO.setGender(customerBO.getGender());
		customerDO.setFirstName(customerBO.getFirstName());
		customerDO.setIp(customerBO.getIp());
		customerDO.setLastName(customerBO.getLastName());
		customerDO.setPassword(customerBO.getPassword());
		customerDO.setStatus(customerBO.getStatus());
		return customerDO;
	}

	public CustomerBO mapCustomerDOToBO(CustomerDO customerDO, CustomerBO customerBO, AddressBO addressBO, List<ContactBO> contactBOs) {
		customerBO.setCustomerId(customerDO.getCustomerId());
		customerBO.setDateOfBirth(customerDO.getDateOfBirth());
		customerBO.setGender(customerDO.getGender());
		customerBO.setFirstName(customerDO.getFirstName());
		customerBO.setIp(customerDO.getIp());
		customerBO.setLastName(customerDO.getLastName());
		customerBO.setPassword(customerDO.getPassword());
		customerBO.setStatus(customerDO.getStatus());
		customerBO.setAddressBO(addressBO);
		customerBO.setContactBOs(contactBOs);
		return customerBO;

	}

	public InvoiceDO mapInvoiceBOToDO(InvoiceBO invoiceBO, InvoiceDO invoiceDO, SellerDO sellerDO, CustomerDO customerDO) {
		invoiceDO.setInvoiceDate(invoiceBO.getInvoiceDate());
		invoiceDO.setInvoiceId(invoiceBO.getInvoiceId());
		invoiceDO.setInvoiceNo(invoiceBO.getInvoiceNo());
		invoiceDO.setInvoicePrefix(invoiceBO.getInvoicePrefix());
		invoiceDO.setSellerDO(sellerDO);
		invoiceDO.setCustomerDO(customerDO);
		return invoiceDO;

	}

	public InvoiceBO mapInvoiceDOToBO(InvoiceDO invoiceDO, InvoiceBO invoiceBO, SellerBO sellerBO, CustomerBO customerBO) {
		invoiceBO.setCustomerBO(customerBO);
		invoiceBO.setInvoiceDate(invoiceDO.getInvoiceDate());
		invoiceBO.setInvoiceId(invoiceDO.getInvoiceId());
		invoiceBO.setInvoiceNo(invoiceDO.getInvoiceNo());
		invoiceBO.setInvoicePrefix(invoiceDO.getInvoicePrefix());
		invoiceBO.setSellerBO(sellerBO);
		return invoiceBO;

	}

	public CrafartOrderDO mapCrafartOrderBOToDO(CrafartOrderBO crafartOrderBO, CrafartOrderDO crafartOrderDO, CommisionDO commissionDO, CourierDO courierDO, CrafartUserDO crafartUserDO,
			CurrencyDO currencyDO, CustomerDO customerDO, InvoiceDO invoiceDO, ProductDO productDO, StoreDO storeDO, TaxRateDO taxRateDO) {
		crafartOrderDO.setComment(crafartOrderBO.getComment());
		crafartOrderDO.setCommisionDO(commissionDO);
		crafartOrderDO.setCourierDO(courierDO);
		crafartOrderDO.setCrafartUserDO(crafartUserDO);
		crafartOrderDO.setCurrencyDO(currencyDO);
		crafartOrderDO.setCustomerDO(customerDO);
		crafartOrderDO.setForwardedIp(crafartOrderBO.getForwardedIp());
		crafartOrderDO.setInvoiceDO(invoiceDO);
		crafartOrderDO.setOrderId(crafartOrderBO.getOrderId());
		crafartOrderDO.setOrderIp(crafartOrderBO.getOrderIp());
		crafartOrderDO.setOrderStatusId(crafartOrderBO.getOrderStatusId());
		crafartOrderDO.setProductDO(productDO);
		crafartOrderDO.setStoreDO(storeDO);
		crafartOrderDO.setTaxRateDO(taxRateDO);
		crafartOrderDO.setTotal(crafartOrderBO.getTotal());
		return crafartOrderDO;

	}

	public CrafartOrderBO mapCrafartOrderDOToBO(CrafartOrderDO crafartOrderDO, CrafartOrderBO crafartOrderBO, CommisionBO commissionBO, CourierBO courierBO, CrafartUserBO crafartUserBO,
			CurrencyBO currencyBO, CustomerBO customerBO, InvoiceBO invoiceBO, ProductBO productBO, StoreBO storeBO, TaxRateBO taxRateBO) {
		crafartOrderBO.setComment(crafartOrderDO.getComment());
		crafartOrderBO.setCommissionBO(commissionBO);
		crafartOrderBO.setCourierBO(courierBO);
		crafartOrderBO.setCrafartUserBO(crafartUserBO);
		crafartOrderBO.setCurrencyBO(currencyBO);
		crafartOrderBO.setCustomerBO(customerBO);
		crafartOrderBO.setForwardedIp(crafartOrderDO.getForwardedIp());
		crafartOrderBO.setInvoiceBO(invoiceBO);
		crafartOrderBO.setOrderId(crafartOrderDO.getOrderId());
		crafartOrderBO.setOrderIp(crafartOrderDO.getOrderIp());
		crafartOrderBO.setOrderStatusId(crafartOrderDO.getOrderStatusId());
		crafartOrderBO.setProductBO(productBO);
		crafartOrderBO.setStoreBO(storeBO);
		crafartOrderBO.setTaxRateBO(taxRateBO);
		crafartOrderBO.setTotal(crafartOrderDO.getTotal());
		return crafartOrderBO;

	}

	public ContactDO mapContactBOToDO(ContactBO contactBO, ContactDO contactDO, CustomerDO customerDO, SellerDO sellerDO) {
		List<CustomerDO> customerDOs = new ArrayList<>();
		customerDOs.add(customerDO);
		contactDO.setContactId(contactBO.getContactId());
		contactDO.setContactTypeId(contactBO.getContactTypeId());
		contactDO.setContactValue(contactBO.getContactValue());
		contactDO.setCustomerDOs(customerDOs);
		return contactDO;

	}

	public ContactBO mapContactDOToBO(ContactDO contactDO, ContactBO contactBO, CustomerBO customerBO, SellerBO sellerBO) {
		contactBO.setContactId(contactDO.getContactId());
		contactBO.setContactTypeId(contactDO.getContactTypeId());
		contactBO.setContactValue(contactDO.getContactValue());
		contactBO.setCustomerBO(customerBO);
		contactBO.setSellerBO(sellerBO);
		return contactBO;

	}

	public ProductRatingBO mapProductRatingDOToBO(ProductRatingDO productRatingDO, ProductRatingBO productRatingBO, CustomerBO customerBO, ProductBO productBO) {
		productRatingBO.setCustomerBO(customerBO);
		productRatingBO.setProductBO(productBO);
		productRatingBO.setPoints(productRatingDO.getPoints());
		productRatingBO.setProductRatingId(productRatingDO.getProductRatingId());
		return productRatingBO;

	}

	public ProductRatingDO mapProductRatingBOToDO(ProductRatingBO productRatingBO, ProductRatingDO productRatingDO, CustomerDO customerDO, ProductDO productDO) {
		productRatingDO.setCustomerDO(customerDO);
		productRatingDO.setPoints(productRatingBO.getPoints());
		productRatingDO.setProductDO(productDO);
		productRatingDO.setProductRatingId(productRatingBO.getProductRatingId());
		return productRatingDO;

	}

	public ProductReviewBO mapProductReviewDOToBO(ProductReviewDO productReviewDO, ProductReviewBO productReviewBO, CustomerBO customerBO, ProductBO productBO) {
		productReviewBO.setAuthour(productReviewDO.getAuthour());
		productReviewBO.setProductReviewId(productReviewDO.getProductReviewId());
		productReviewBO.setRating(productReviewDO.getRating());
		productReviewBO.setStatus(productReviewDO.getStatus());
		productReviewBO.setText(productReviewDO.getText());
		productReviewBO.setCustomerBO(customerBO);
		productReviewBO.setProductBO(productBO);
		return productReviewBO;

	}

	public ProductReviewDO mapProductReviewBOToDO(ProductReviewBO productReviewBO, ProductReviewDO productReviewDO, CustomerDO customerDO, ProductDO productDO) {
		productReviewDO.setAuthour(productReviewBO.getAuthour());
		productReviewDO.setProductReviewId(productReviewBO.getProductReviewId());
		productReviewDO.setRating(productReviewBO.getRating());
		productReviewDO.setStatus(productReviewBO.getStatus());
		productReviewDO.setText(productReviewBO.getText());
		productReviewDO.setCustomerDO(customerDO);
		productReviewDO.setProductDO(productDO);
		return productReviewDO;

	}

	public BannerBO mapBannerDOToBO(BannerDO bannerDO, BannerBO bannerBO) {
		bannerBO.setBannerId(bannerDO.getBannerId());
		bannerBO.setBannerImage(bannerDO.getBannerImage());
		bannerBO.setBannerName(bannerDO.getBannerName());
		bannerBO.setBannerUrl(bannerDO.getBannerUrl());
		bannerBO.setSortOrder(bannerDO.getSortOrder());
		return bannerBO;
	}
	public BannerDO mapBannerBOToDO(BannerBO bannerBO, BannerDO bannerDO) {
		bannerDO.setBannerId(bannerBO.getBannerId());
		bannerDO.setBannerImage(bannerBO.getBannerImage());
		bannerDO.setBannerName(bannerBO.getBannerName());
		bannerDO.setBannerUrl(bannerBO.getBannerUrl());
		bannerDO.setSortOrder(bannerBO.getSortOrder());
		return bannerDO;
	}

	public BannerGroupDO mapBannerGroupBOToDO(BannerGroupBO bannerGroupBO, BannerGroupDO bannerGroupDO) {
		bannerGroupDO.setBannerGroupId(bannerGroupBO.getBannerGroupId());
		bannerGroupDO.setBannerGroupName(bannerGroupBO.getBannerGroupName());
		bannerGroupDO.setBannerSize(bannerGroupBO.getBannerSize());
		bannerGroupDO.setSortOrder(bannerGroupBO.getSortOrder());
		return bannerGroupDO;
	}

	public BannerGroupBO mapGeoZoneDOToBO(BannerGroupDO bannerGroupDO, BannerGroupBO bannerGroupBO) {
		
		bannerGroupBO.setBannerGroupId(bannerGroupDO.getBannerGroupId());
		bannerGroupBO.setBannerGroupName(bannerGroupDO.getBannerGroupName());
		bannerGroupBO.setBannerSize(bannerGroupDO.getBannerSize());
		bannerGroupBO.setSortOrder(bannerGroupDO.getSortOrder());
		return bannerGroupBO;
	}

	public InformationDO mapInformationBOToDO(InformationBO informationBO, InformationDO informationDO) {
		informationDO.setInformationId(informationBO.getInformationId());
		informationDO.setInformationTitle(informationBO.getInformationTitle());
		informationDO.setMetaDescription(informationBO.getMetaDescription());
		informationDO.setDescription(informationBO.getDescription());
		informationDO.setMetaTitle(informationBO.getMetaTitle());
		informationDO.setMetaKeyword(informationBO.getMetaKeyword());
		informationDO.setSortOrder(informationBO.getSortOrder());
		informationDO.setIsActive(informationBO.getIsActive());
		return informationDO;
	}
	public InformationBO mapInformationDOToBO(InformationDO informationDO, InformationBO informationBO) {
		informationBO.setInformationId(informationDO.getInformationId());
		informationBO.setInformationTitle(informationDO.getInformationTitle());
		informationBO.setMetaDescription(informationDO.getMetaDescription());
		informationBO.setDescription(informationDO.getDescription());
		informationBO.setMetaTitle(informationDO.getMetaTitle());
		informationBO.setMetaKeyword(informationDO.getMetaKeyword());
		informationBO.setSortOrder(informationDO.getSortOrder());
		informationBO.setIsActive(informationDO.getIsActive());
		return informationBO;
	}

	public UserGroupDO mapUserGroupBOToDO(UserGroupBO userGroupBO, UserGroupDO userGroupDO) {
		userGroupDO.setUserGroupId(userGroupBO.getUserGroupId());
		userGroupDO.setGroupName(userGroupBO.getUserName());
		userGroupDO.setPermission(userGroupBO.getPermission());
		userGroupDO.setSortOrder(userGroupBO.getSortOrder());
		return userGroupDO;
	}
	
	public UserGroupBO mapUserGroupDOToBO(UserGroupDO userGroupDO, UserGroupBO userGroupBO) {
		userGroupBO.setUserGroupId(userGroupDO.getUserGroupId());
		userGroupBO.setUserName(userGroupDO.getGroupName());
		userGroupBO.setPermission(userGroupDO.getPermission());
		userGroupBO.setSortOrder(userGroupDO.getSortOrder());
		return userGroupBO;
	}

	public UserDO mapUserBOToDO(UserBO userBO, UserDO userDO) {
		userDO.setUserId(userBO.getUserId());
		userDO.setUserGroupId(userBO.getUserGroupId());
		userDO.setUserName(userBO.getUserName());
		userDO.setFirstName(userBO.getFirstName());
		userDO.setLastName(userBO.getLastName());
		userDO.setPassword(userBO.getPassword());
		userDO.setIsActive(userBO.getIsActive());
		return userDO;
	}


	public UserBO mapUserDOToBO(UserDO userDO, UserBO userBO) {
		userBO.setUserId(userDO.getUserId());
		userBO.setUserGroupId(userDO.getUserGroupId());
		userBO.setUserName(userDO.getUserName());
		userBO.setFirstName(userDO.getFirstName());
		userBO.setLastName(userDO.getLastName());
		userBO.setPassword(userDO.getPassword());
		userBO.setIsActive(userDO.getIsActive());
		return userBO;
	}

	public OrderStatusDO mapOrderStatusBOToDO(OrderStatusBO orderStatusBO, OrderStatusDO orderStatusDO) {
		orderStatusDO.setOrderStatusId(orderStatusBO.getOrderStatusId());
		orderStatusDO.setOrderStatusTitle(orderStatusBO.getOrderStatusTitle());
		orderStatusDO.setDescription(orderStatusBO.getDescription());
		orderStatusDO.setOrderStatusSubject(orderStatusBO.getOrderStatusSubject());
		orderStatusDO.setSortOrder(orderStatusBO.getSortOrder());
		return orderStatusDO;
	}

	public OrderStatusBO mapOrderStatusDOToBO(OrderStatusDO orderStatusDO, OrderStatusBO orderStatusBO) {
		orderStatusBO.setOrderStatusId(orderStatusDO.getOrderStatusId());
		orderStatusBO.setOrderStatusTitle(orderStatusDO.getOrderStatusTitle());
		orderStatusBO.setDescription(orderStatusDO.getDescription());
		orderStatusBO.setOrderStatusSubject(orderStatusDO.getOrderStatusSubject());
		orderStatusBO.setSortOrder(orderStatusDO.getSortOrder());
		return orderStatusBO;
	}


}
	
