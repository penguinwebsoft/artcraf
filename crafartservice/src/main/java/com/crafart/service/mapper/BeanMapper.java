/**
 * 
 */
package com.crafart.service.mapper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.SellerDO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.SellerBO;

/**
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

}
