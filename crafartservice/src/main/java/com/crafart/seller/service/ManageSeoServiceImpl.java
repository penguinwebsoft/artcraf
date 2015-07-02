/**
 * 
 */
package com.crafart.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.SeoDAO;
import com.crafart.inter.service.ManageSeoService;
import com.crafart.service.businessobjects.SeoBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 *
 */
@Service("ManageSeoServiceImpl")
public class ManageSeoServiceImpl implements ManageSeoService {

	@Autowired
	private SeoDAO seoDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addSeo(SeoBO seoBO) throws CrafartServiceException {
		SeoDO seoDO = beanMapper.mapSeoBOToDO(seoBO, new SeoDO());
		try {
			seoDAOImpl.addSeo(seoDO);
			seoBO.setSeoId(seoDO.getSeo_id());
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while adding data to seo table", cdExp);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
