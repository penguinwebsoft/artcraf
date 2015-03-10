/**
 * 
 */
package com.crafart.service.mapper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.crafart.dataobjects.AccountDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.service.businessobjects.AccountBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;

/**
 * mapping from BO to DO and vice versa
 * 
 * @author Karthi
 * @version 1.0
 * 
 */
@Component("beanMapper")
public class BeanMapper {

	private static final Logger log = Logger.getLogger(BeanMapper.class);

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
		log.info("bean mapping for sellerBO to sellerDO");
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
		log.info("bean mapping for sellerDO to sellerBO");
		return sellerBO;

	}

	public ProductDO mapProductBOToDO(ProductBO productBO, ProductDO productDO) {
		productDO.setCategoryId(productBO.getCategoryId());
		productDO.setDateAvailable(productBO.getDateAvailable());
		productDO.setHeight(productBO.getHeight());
		productDO.setImage(productBO.getImage());
		productDO.setLength(productBO.getHeight());
		productDO.setLengthClassId(productBO.getLengthClassId());
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
		productDO.setWeightClassId(productBO.getWeightClassId());
		productDO.setWidth(productBO.getWidth());
		log.info("Bean mapping from BO to DO");
		return productDO;
	}

	public ProductBO mapProductDOToBO(ProductDO productDO, ProductBO productBO) {
		productBO.setCategoryId(productDO.getCategoryId());
		productBO.setDateAvailable(productDO.getDateAvailable());
		productBO.setHeight(productDO.getHeight());
		productBO.setImage(productDO.getImage());
		productBO.setLength(productDO.getLength());
		productBO.setLengthClassId(productDO.getLengthClassId());
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
		productBO.setWeightClassId(productDO.getWeightClassId());
		productBO.setWidth(productDO.getWidth());
		log.info("Bean mapping from DO to BO");
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
		log.info("Bean Mapping from BO to DO");
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
		log.info("Bean mapping from DO to BO");
		return accountBO;

	}

	public StoreDO mapStoreBOToDO(StoreBO storeBO, StoreDO storeDO) {
		storeDO.setName(storeBO.getName());
		storeDO.setSellerId(storeBO.getSellerId());
		storeDO.setStore_Description(storeBO.getStore_Description());
		storeDO.setStore_Return(storeBO.getStore_Return());
		storeDO.setStoreId(storeBO.getStoreId());
		storeDO.setStoreUrl(storeBO.getStoreUrl());
		log.info("Bean mapping from BO to DO");
		return storeDO;

	}
}
