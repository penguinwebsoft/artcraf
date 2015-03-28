/**
 * 
 */
package com.crafart.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.crafart.dataobjects.AccountDO;
import com.crafart.dataobjects.AddressDO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.CourierDO;
import com.crafart.dataobjects.GeoZoneDO;
import com.crafart.dataobjects.LengthClassDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.ProductDescriptionDO;
import com.crafart.dataobjects.ProductDiscountDO;
import com.crafart.dataobjects.ProductSpecialDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.dataobjects.TaxClassDO;
import com.crafart.dataobjects.WeightClassDO;
import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.businessobjects.GeoZoneBO;
import com.crafart.service.businessobjects.LengthClassBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductDescriptionBO;
import com.crafart.service.businessobjects.ProductDiscountBO;
import com.crafart.service.businessobjects.ProductSpecialBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.businessobjects.TaxClassBO;
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

	public SellerDO mapSellerBOToDO(SellerBO sellerBO, SellerDO sellerDO) {
		sellerDO.setApproved(sellerBO.getApproved());
		sellerDO.setCommission(sellerBO.getCommission());
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
		sellerDO.setDateOfBirth(sellerBO.getDateOfBirth());
		return sellerDO;

	}

	public SellerBO mapSellerDOToBO(SellerDO sellerDO, SellerBO sellerBO) {
		sellerBO.setApproved(sellerDO.getApproved());
		sellerBO.setCommission(sellerDO.getCommission());
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
		sellerBO.setAddressBO((AddressBO) sellerDO.getAddressDOs());
		return sellerBO;

	}

	public ProductDO mapProductBOToDO(ProductBO productBO, ProductDO productDO, WeightClassDO weightClassDO, LengthClassDO lengthClassDO) {
		productDO.setCategoryId(productBO.getCategoryId());
		productDO.setDateAvailable(productBO.getDateAvailable());
		productDO.setDateAvailable(productBO.getDateAvailable());
		productDO.setHeight(productBO.getHeight());
		productDO.setImage(productBO.getImage());
		productDO.setLength(productBO.getHeight());
		productDO.setLengthClassDO(lengthClassDO);
		productDO.setLocation(productBO.getLocation());
		productDO.setMinimum(productBO.getMinimum());
		productDO.setModel(productBO.getModel());
		productDO.setPoints(productBO.getPoints());
		productDO.setPrice(productBO.getPrice());
		productDO.setProductId(productBO.getProductId());
		productDO.setQuantity(productBO.getQuantity());
		productDO.setSellerId(productBO.getSellerId());
		productDO.setShipping(productBO.getShipping());
		productDO.setSku(productBO.getSku());
		productDO.setSortOrder(productBO.getSortOrder());
		productDO.setStatus(productBO.getStatus());
		productDO.setStockStatusId(productBO.getStockStatusId());
		productDO.setSubtract(productBO.getSubtract());
		productDO.setTaxClassId(productBO.getTaxClassId());
		productDO.setUpc(productBO.getUpc());
		productDO.setViewed(productBO.getViewed());
		productDO.setWeight(productBO.getWeight());
		productDO.setWeightClassDO(weightClassDO);
		productDO.setWidth(productBO.getWidth());
		return productDO;
	}

	public ProductBO mapProductDOToBO(ProductDO productDO, ProductBO productBO) {
		productBO.setCategoryId(productDO.getCategoryId());
		productBO.setDateAvailable(productDO.getDateAvailable());
		productBO.setHeight(productDO.getHeight());
		productBO.setImage(productDO.getImage());
		productBO.setLength(productDO.getLength());
		productBO.setLengthClassBO(null);
		productBO.setLocation(productDO.getLocation());
		productBO.setMinimum(productDO.getMinimum());
		productBO.setModel(productDO.getModel());
		productBO.setPoints(productDO.getPoints());
		productBO.setPrice(productDO.getPrice());
		productBO.setProductId(productDO.getProductId());
		productBO.setQuantity(productDO.getQuantity());
		productBO.setSellerId(productDO.getSellerId());
		productBO.setShipping(productDO.getShipping());
		productBO.setSku(productDO.getSku());
		productBO.setSortOrder(productDO.getSortOrder());
		productBO.setStatus(productDO.getStatus());
		productBO.setStockStatusId(productDO.getStockStatusId());
		productBO.setSubtract(productDO.getSubtract());
		productBO.setTaxClassId(productDO.getTaxClassId());
		productBO.setUpc(productDO.getUpc());
		productBO.setViewed(productDO.getViewed());
		productBO.setWeight(productDO.getWeight());
		productBO.setWeightClassBO(null);
		productBO.setWidth(productDO.getWidth());
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

	public AddressDO mapAddressBOToDO(AddressBO addressBO, AddressDO addressDO, SellerDO sellerDO) {
		addressDO.setCityId(addressBO.getCityId());
		List<SellerDO> sellerDOs = new ArrayList<>();
		sellerDOs.add(sellerDO);
		addressDO.setSellerDOs(sellerDOs);
		addressDO.setPinCode(addressBO.getPinCode());
		addressDO.setStateId(addressBO.getStateId());
		addressDO.setStreet(addressBO.getStreet());
		return addressDO;

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
		lengthClassDO.setUnit(lengthClassBO.getUnit());
		lengthClassDO.setValue(lengthClassBO.getValue());
		return lengthClassDO;

	}

	public CategoryDO mapCategoryBOToDO(CategoryBO categoryBO, CategoryDO categoryDO) {
		categoryDO.setCategoryColumn(categoryBO.getCategoryColumn());
		categoryDO.setCategoryId(categoryBO.getCategoryId());
		categoryDO.setImageLocation(categoryBO.getImageLocation());
		categoryDO.setParentId(categoryBO.getParentId());
		categoryDO.setSortOrder(categoryBO.getSortOrder());
		categoryDO.setStatus(categoryBO.getStatus());
		return categoryDO;

	}

	public CategoryBO mapCategoryDOToBO(CategoryDO categoryDO, CategoryBO categoryBO) {
		categoryBO.setCategoryColumn(categoryDO.getCategoryColumn());
		categoryBO.setCategoryId(categoryDO.getCategoryId());
		categoryBO.setImageLocation(categoryDO.getImageLocation());
		categoryBO.setParentId(categoryDO.getParentId());
		categoryBO.setSortOrder(categoryDO.getSortOrder());
		categoryBO.setStatus(categoryDO.getStatus());
		return categoryBO;

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
		courierDO.setName(courierBO.getName());
		courierDO.setProductLimit(courierBO.getProductLimit());
		courierDO.setSortOrder(courierBO.getSortOrder());
		return courierDO;

	}

	public CourierBO mapCourierDOToBO(CourierDO courierDO, CourierBO courierBO) {
		courierBO.setCourierId(courierDO.getCourierId());
		courierBO.setImage(courierDO.getImage());
		courierBO.setName(courierDO.getName());
		courierBO.setProductLimit(courierDO.getProductLimit());
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
		productSpecialDO.setSellerId(productDO.getSellerId());
		return productSpecialDO;

	}

	public ProductDiscountDO mapProductDiscountBOToDO(ProductDiscountBO productDiscountBO, ProductDiscountDO productDiscountDO, ProductDO productDO) {
		productDiscountDO.setEndDate(productDiscountBO.getEndDate());
		productDiscountDO.setPrice(productDiscountBO.getPrice());
		productDiscountDO.setProductDiscountId(productDiscountBO.getProductDiscountId());
		productDiscountDO.setQuantity(productDiscountBO.getQuantity());
		productDiscountDO.setStartDate(productDiscountBO.getStartDate());
		productDiscountDO.setProductDO(productDO);
		productDiscountDO.setSellerId(productDO.getSellerId());
		return productDiscountDO;

	}
}
