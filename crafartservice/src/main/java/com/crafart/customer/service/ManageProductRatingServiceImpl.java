/**
 * 
 */
package com.crafart.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.ProductRatingDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductRatingDAO;
import com.crafart.inter.service.ManageProductRatingService;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductRatingBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("ManageProductRatingServiceImpl")
public class ManageProductRatingServiceImpl implements ManageProductRatingService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private ProductRatingDAO productRatingDAOImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<ProductRatingBO> getProductRating(long customerId) throws CrafartServiceException {
		List<ProductRatingBO> productRatingBOs = new ArrayList<>();
		try {
			List<ProductRatingDO> productRatingDOs = productRatingDAOImpl.getProductRating(customerId);
			if (productRatingDOs == null)
				return null;
			for (ProductRatingDO productRatingDO : productRatingDOs) {
				ProductRatingBO productRatingBO = beanMapper.mapProductRatingDOToBO(productRatingDO, new ProductRatingBO(),
						beanMapper.mapCustomerDOToBO(productRatingDO.getCustomerDO(), new CustomerBO(), null, null),
						beanMapper.mapProductDOToBO(productRatingDO.getProductDO(), new ProductBO(), new SellerBO(), null, null));
				productRatingBOs.add(productRatingBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while getting prodct rating from table", cdExp);
		}
		return productRatingBOs;
	}

}
