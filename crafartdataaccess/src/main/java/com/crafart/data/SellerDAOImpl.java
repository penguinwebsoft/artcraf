package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.SellerDAO;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("sellerDAOImpl")
public class SellerDAOImpl extends CommonDAOImpl implements SellerDAO {


	/**
	 * Add seller details to database and returns with generated primary key. if
	 * error during the DB insertion all other related transactions are rolled
	 * back.
	 * 
	 * <li>{@link CrafartDataException} thrown back to caller method if there
	 * are any error while adding the database. <li>caller method have to handle
	 * the exception and appropriate implementation measures to be taken based
	 * on the error.
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeller(SellerDO sellerDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(sellerDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding new seller details", hExp);
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSeller(SellerDO sellerDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			//bug fix- save or update wont work incase if save and update actions happens
			// in the same session, in that hibernate throws error saying 
			// "a different object with the same identifier value was already associated with the session"
			// in that case, we need to do merge object which has same identifier
			session.merge(sellerDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Erroe while updating table", hExp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public SellerDO getSellerContacts(long seller_id) throws CrafartDataException {
		SellerDO sellerDO = new SellerDO();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from SellerDO where seller_id = :seller_id");
			query.setLong("seller_id", seller_id);
			sellerDO = (SellerDO) query.uniqueResult();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while getting seller detail", hExp);
		}
		return sellerDO;
	}

}
