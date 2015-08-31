/**
 * 
 */
package com.crafart.data;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CouponDO;

import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CouponDAO;


/**
 * @author Deepam
 *
 */
@Repository("couponDAOImpl")
public class CouponDAOImpl extends CommonDAOImpl implements CouponDAO {


	
	/**
	 * adding addCoupon to Discount table by addGeoZoneDetails
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCoupon(CouponDO couponDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(couponDO);
			
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding coupon details in table", hExp);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CouponDO> getCouponDetail() throws CrafartDataException {
		List<CouponDO> couponDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			couponDOs = session.createQuery("from CouponDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving Coupon details", hExp);
		}
		return couponDOs;
	}

	/**
	 * retrieve coupon data object for identifier {@link Long} CODE
	 * @param CODE
	 */
	@Override
	public CouponDO getCoupon(long CODE) throws CrafartDataException {
		CouponDO couponDO = (CouponDO) this.getSessionFactory().getCurrentSession().get(CouponDO.class, CODE);
		return couponDO;
	}

	




}
