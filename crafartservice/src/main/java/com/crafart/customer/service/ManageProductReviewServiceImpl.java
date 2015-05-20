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

import com.crafart.dataobjects.ProductReviewDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.ProductReviewDAO;
import com.crafart.inter.service.ManageProductReviewService;
import com.crafart.service.businessobjects.AddressBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.ProductReviewBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("ManageProductReviewServiceImpl")
public class ManageProductReviewServiceImpl implements ManageProductReviewService {

	@Autowired
	private ProductReviewDAO productReviewDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<ProductReviewBO> getProductReview(long customerId) throws CrafartServiceException {
		List<ProductReviewBO> productReviewBOs = new ArrayList<>();
		try {
			List<ProductReviewDO> productReviewDOs = productReviewDAOImpl.getProductReview(customerId);
			if (productReviewDOs == null)
				return null;
			for (ProductReviewDO productReviewDO : productReviewDOs) {
				ProductReviewBO productReviewBO = beanMapper.mapProductReviewDOToBO(productReviewDO, new ProductReviewBO(),
						beanMapper.mapCustomerDOToBO(productReviewDO.getCustomerDO(), new CustomerBO(), new AddressBO(), null),
						beanMapper.mapProductDOToBO(productReviewDO.getProductDO(), new ProductBO(), new SellerBO(), null, null));
				productReviewBOs.add(productReviewBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriving product review details", cdExp);
		}
		return productReviewBOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<ProductReviewBO> getSingleProductReviews(long productId) throws CrafartServiceException {
		List<ProductReviewBO> productReviewBOs = new ArrayList<>();
		List<ProductReviewDO> productReviewDOs;
		try {
			productReviewDOs = productReviewDAOImpl.getSingleProductReviews(productId);
			if (productReviewDOs == null)
				return null;
			for (ProductReviewDO productReviewDO : productReviewDOs) {
				ProductReviewBO productReviewBO = beanMapper.mapProductReviewDOToBO(productReviewDO, new ProductReviewBO(), null,
						beanMapper.mapProductDOToBO(productReviewDO.getProductDO(), new ProductBO(), null, null, null));
				productReviewBOs.add(productReviewBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while getting single product review details", cdExp);
		}

		return productReviewBOs;
	}
}
