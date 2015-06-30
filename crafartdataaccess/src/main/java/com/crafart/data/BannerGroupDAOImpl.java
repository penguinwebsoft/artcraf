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

import com.crafart.dataobjects.BannerGroupDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerGroupDAO;

/**
 * @author Karthi
 * 
 */
@Repository("bannerGroupDAOImpl")
public class BannerGroupDAOImpl extends CommonDAOImpl implements BannerGroupDAO {


	/**
	 * adding BannerGroupDetail details to banner_group table by addGeoZoneDetails
	 */
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addBannerGroupDetail(BannerGroupDO bannerGroupDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(bannerGroupDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding  bannerGroup details in table", hExp);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<BannerGroupDO> getBannerGroupDetail() throws CrafartDataException {
		List<BannerGroupDO> bannerGroupDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			bannerGroupDOs = session.createQuery("from BannerGroupDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving bannerGroup details", hExp);
		}
		return bannerGroupDOs;
	}

}
