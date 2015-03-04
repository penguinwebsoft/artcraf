package com.crafart.data;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
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

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeller(SellerDO sellerDO) throws CrafartDataException {
		JdbcTemplate jdbcTemplate = this.getJdbctemplate();
		long sellerId = jdbcTemplate.queryForObject(USER_KEY, Long.class);
		sellerDO.setSellerId(sellerId);
		int isSellerAdded = jdbcTemplate.update(
				ADD_SELLER,
				new Object[] { sellerId, sellerDO.getFirstName(), sellerDO.getLastName(), sellerDO.getTin_no(), sellerDO.getCompanyName(), sellerDO.getCompanyLogo(), sellerDO.getEpch_no(),
						sellerDO.getVat_no(), sellerDO.getCst_no(), sellerDO.getCommission(), sellerDO.getStatus(), sellerDO.getApproved() });
		try {
			if (isSellerAdded == 0) {
				log.info("Seller registration failed");
			}
		} catch (DataAccessException dataAccessException) {
			throw new CrafartDataException("Seller registration failed", dataAccessException);
		}
	}

	/**
	 * Add seller details to database and returns with generated primary key.
	 * if error during the db insertion all other related transactions are rolled back.
	 * 
	 * <li>{@link CrafartDataException} thrown back to caller method if there are any error while adding the database.
	 * <li>caller method have tp handle the exception and appropriate implementation measures to be taken based on the error.
	 */
	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public void saveSeller(SellerDO sellerDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(sellerDO);
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding new seller details", hExp);
		}

	}
}
