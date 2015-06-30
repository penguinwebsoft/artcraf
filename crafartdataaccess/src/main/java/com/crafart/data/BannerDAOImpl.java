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
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.BannerDAO;

/**
 * @author Karthi
 * 
 */
@Repository("bannerDAOImpl")
public class BannerDAOImpl extends CommonDAOImpl implements BannerDAO {


	@Transactional(propagation = Propagation.REQUIRED)
	public void addBannerDetail(BannerDO bannerDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(bannerDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding banner detail", hExp);
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