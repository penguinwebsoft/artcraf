package com.crafart.data;


import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("sellerDAOImpl")
public class SellerDAOImpl extends CommonDAOImpl implements SellerDAO {
	
	private static final Logger log = Logger.getLogger(SellerDAOImpl.class);

	private static final String ADD_SELLER = "INSERT INTO SELLER(SELLER_ID, FIRST_NAME, LAST_NAME, TIN_NO, COMPANY_NAME, COMPANY_LOGO, EPCH_NO, VAT_NO, CST_NO, COMMISSION, STATUS, APPROVED, CREATED_DTTM) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";

	private static final String USER_KEY = "SELECT  COALESCE( MAX( SELLER_ID ) , 0 )+1  FROM SELLER ";

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeller(SellerDO sellerDO)throws CrafartDataException {
		JdbcTemplate jdbcTemplate = this.getJdbctemplate();
		long sellerId = jdbcTemplate.queryForObject(USER_KEY, Long.class);
		sellerDO.setSellerId(sellerId);
		int isSellerAdded = jdbcTemplate.update(ADD_SELLER, new Object[]{sellerId, sellerDO.getFirstName(), sellerDO.getLastName(), sellerDO.getTin_no(), sellerDO.getCompanyName(), sellerDO.getCompanyLogo(), sellerDO.getEpch_no(), sellerDO.getVat_no(), sellerDO.getCst_no(), sellerDO.getCommission(), sellerDO.getStatus(), sellerDO.getApproved()});
		try {
			if(isSellerAdded == 0){
				log.info("Seller registration failed");
			}
		} catch (DataAccessException dataAccessException) {
			throw new CrafartDataException("Seller registration failed", dataAccessException);
		}
	}

}
