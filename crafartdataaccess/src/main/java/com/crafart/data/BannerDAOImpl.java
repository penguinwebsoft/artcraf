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

import com.crafart.dataobjects.BannerDO;
import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerDAO;

/**
 * @author Karthi
 * 
 */
@Repository("bannerDAOImpl")
public class BannerDAOImpl extends CommonDAOImpl implements BannerDAO {

	

	/**
	 * obtain banner object which has identifier {@link Long} bannerId
	 * @param categoryId
	 * @return {@link BannerDO}
	 * @throws CrafartDataException
	 */
	@Override
	public BannerDO getBannerDO(long bannerId) throws CrafartDataException {
		Session session = this.getSessionFactory().getCurrentSession();
		BannerDO bannerDO = (BannerDO) session.get(BannerDO.class, bannerId);
		return bannerDO;
	}
	

	/**
	 * add banner group for banner group id {@link BannerGroupDO}
	 * @param bannerDO
	 * @throws CrafartDataException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBanner(BannerDO bannerDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(bannerDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding banner detail", hExp);
		}
	}

	/**
	 * updating Banner data for banner id 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBanner(BannerDO bannerDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(bannerDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding  banner details in table", hExp);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<BannerDO> getBannerDetail() throws CrafartDataException {
		List<BannerDO> bannerDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			bannerDOs = session.createQuery("from BannerDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error while retriving details from commission table", hExp);
		}
		return bannerDOs;
	}

	

}