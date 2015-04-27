/**
 * 
 */
package com.crafart.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CrafartOrderDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CrafartOrderDAO;
import com.crafart.inter.service.ManageCrafartOrderService;
import com.crafart.service.businessobjects.CommissionBO;
import com.crafart.service.businessobjects.CourierBO;
import com.crafart.service.businessobjects.CrafartOrderBO;
import com.crafart.service.businessobjects.CrafartUserBO;
import com.crafart.service.businessobjects.CurrencyBO;
import com.crafart.service.businessobjects.CustomerBO;
import com.crafart.service.businessobjects.InvoiceBO;
import com.crafart.service.businessobjects.ProductBO;
import com.crafart.service.businessobjects.SellerBO;
import com.crafart.service.businessobjects.StoreBO;
import com.crafart.service.businessobjects.TaxRateBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageCrafartOrderServiceImpl")
public class ManageCrafartOrderServiceImpl implements ManageCrafartOrderService {

	@Autowired
	private CrafartOrderDAO crafartOrderDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<CrafartOrderBO> getCrafartOrder(SellerBO sellerBO) throws CrafartServiceException {
		List<CrafartOrderBO> crafartOrderBOs = new ArrayList<>();
		try {
			List<CrafartOrderDO> crafartOrderDOs = crafartOrderDAOImpl.getCrafartOrder();
			for (CrafartOrderDO crafartOrderDO : crafartOrderDOs) {
				CrafartOrderBO crafartOrderBO = beanMapper.mapCrafartOrderDOToBO(crafartOrderDO, new CrafartOrderBO(),
						beanMapper.mapCommissionDOToBO(crafartOrderDO.getCommissionDO(), new CommissionBO()), beanMapper.mapCourierDOToBO(crafartOrderDO.getCourierDO(), new CourierBO()),
						beanMapper.mapCrafartUserDOToBO(crafartOrderDO.getCrafartUserDO(), new CrafartUserBO()), beanMapper.mapCurrencyDOToBO(crafartOrderDO.getCurrencyDO(), new CurrencyBO()),
						beanMapper.mapCustomerDOToBO(crafartOrderDO.getCustomerDO(), new CustomerBO()),
						beanMapper.mapInvoiceDOToBO(crafartOrderDO.getInvoiceDO(), new InvoiceBO(), sellerBO, beanMapper.mapCustomerDOToBO(crafartOrderDO.getCustomerDO(), new CustomerBO())),
						beanMapper.mapProductDOToBO(crafartOrderDO.getProductDO(), new ProductBO()), beanMapper.mapStoreDOToBO(crafartOrderDO.getStoreDO(), new StoreBO(), sellerBO),
						beanMapper.mapTaxRateDOToBO(crafartOrderDO.getTaxRateDO(), new TaxRateBO(), beanMapper.mapProductDOToBO(crafartOrderDO.getProductDO(), new ProductBO())));
				crafartOrderBOs.add(crafartOrderBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriving order details", cdExp);
		}
		return crafartOrderBOs;
	}
}