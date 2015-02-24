/**
 * 
 */
package com.crafart.service.mapper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.crafart.dataobjects.SellerDO;
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
		sellerDO.setCst_no(sellerBO.getCst_no());
		sellerDO.setEpch_no(sellerBO.getEpch_no());
		sellerDO.setFirstName(sellerBO.getFirstName());
		sellerDO.setLastName(sellerBO.getLastName());
		sellerDO.setSellerId(sellerBO.getSellerId());
		sellerDO.setStatus(sellerBO.getStatus());
		sellerDO.setTin_no(sellerDO.getStatus());
		sellerDO.setVat_no(sellerBO.getVat_no());
		log.info("bean mapping for sellerBO to sellerDO");
		return sellerDO;

	}
	
	public SellerBO mapSellerDOToBO(SellerDO sellerDO, SellerBO sellerBO){
		sellerBO.setApproved(sellerDO.getApproved());
		sellerBO.setCommission(sellerDO.getCommission());
		sellerBO.setCompanyLogo(sellerDO.getCompanyLogo());
		sellerBO.setCompanyName(sellerDO.getCompanyName());
		sellerBO.setCst_no(sellerDO.getCst_no());
		sellerBO.setEpch_no(sellerDO.getEpch_no());
		sellerBO.setFirstName(sellerDO.getFirstName());
		sellerBO.setLastName(sellerDO.getLastName());
		sellerBO.setSellerId(sellerDO.getSellerId());
		sellerBO.setStatus(sellerDO.getStatus());
		sellerBO.setTin_no(sellerDO.getTin_no());
		sellerBO.setVat_no(sellerDO.getVat_no());
		log.info("bean mapping for sellerDO to sellerBO");
		return sellerBO;
		
	}
}
