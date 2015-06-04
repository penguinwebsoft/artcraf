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

import com.crafart.dataobjects.CommissionDO;
import com.crafart.dataobjects.CourierDO;
import com.crafart.dataobjects.CrafartOrderDO;
import com.crafart.dataobjects.CrafartUserDO;
import com.crafart.dataobjects.CurrencyDO;
import com.crafart.dataobjects.CustomerDO;
import com.crafart.dataobjects.InvoiceDO;
import com.crafart.dataobjects.ProductDO;
import com.crafart.dataobjects.StoreDO;
import com.crafart.dataobjects.TaxRateDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CrafartOrderDAO;
import com.crafart.inter.service.ManageCrafartOrderService;
import com.crafart.service.businessobjects.AddressBO;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.crafart.inter.service.ManageCrafartOrderService#getCrafartOrder(com
	 * .crafart.service.businessobjects.SellerBO)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<CrafartOrderBO> getCrafartOrder(SellerBO sellerBO) throws CrafartServiceException {
		List<CrafartOrderBO> crafartOrderBOs = new ArrayList<>();
		try {
			List<CrafartOrderDO> crafartOrderDOs = crafartOrderDAOImpl.getCrafartOrder();
			for (CrafartOrderDO crafartOrderDO : crafartOrderDOs) {
				CrafartOrderBO crafartOrderBO = beanMapper.mapCrafartOrderDOToBO(
						crafartOrderDO,
						new CrafartOrderBO(),
						beanMapper.mapCommissionDOToBO(crafartOrderDO.getCommissionDO(), new CommissionBO()),
						beanMapper.mapCourierDOToBO(crafartOrderDO.getCourierDO(), new CourierBO()),
						beanMapper.mapCrafartUserDOToBO(crafartOrderDO.getCrafartUserDO(), new CrafartUserBO()),
						beanMapper.mapCurrencyDOToBO(crafartOrderDO.getCurrencyDO(), new CurrencyBO()),
						beanMapper.mapCustomerDOToBO(crafartOrderDO.getCustomerDO(), new CustomerBO(), null, null),
						beanMapper.mapInvoiceDOToBO(crafartOrderDO.getInvoiceDO(), new InvoiceBO(), sellerBO,
								beanMapper.mapCustomerDOToBO(crafartOrderDO.getCustomerDO(), new CustomerBO(), null, null)),
						beanMapper.mapProductDOToBO(crafartOrderDO.getProductDO(), new ProductBO(), new SellerBO(), null, null), beanMapper.mapStoreDOToBO(crafartOrderDO.getStoreDO(), new StoreBO(), sellerBO),
						beanMapper.mapTaxRateDOToBO(crafartOrderDO.getTaxRateDO(), new TaxRateBO(), beanMapper.mapProductDOToBO(crafartOrderDO.getProductDO(), new ProductBO(), new SellerBO(), null, null)));
				crafartOrderBOs.add(crafartOrderBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriving order details", cdExp);
		}
		return crafartOrderBOs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<CrafartOrderBO> getCustomerOrder(long customerId) throws CrafartServiceException {
		List<CrafartOrderBO> crafartOrderBOs = new ArrayList<>();
		try {
			List<CrafartOrderDO> crafartOrderDOs = crafartOrderDAOImpl.getCustomerOrder(customerId);
			if (crafartOrderDOs == null)
				return null;
			for (CrafartOrderDO crafartOrderDO : crafartOrderDOs) {
				CrafartOrderBO crafartOrderBO = beanMapper.mapCrafartOrderDOToBO(
						crafartOrderDO,
						new CrafartOrderBO(),
						beanMapper.mapCommissionDOToBO(crafartOrderDO.getCommissionDO(), new CommissionBO()),
						beanMapper.mapCourierDOToBO(crafartOrderDO.getCourierDO(), new CourierBO()),
						beanMapper.mapCrafartUserDOToBO(crafartOrderDO.getCrafartUserDO(), new CrafartUserBO()),
						beanMapper.mapCurrencyDOToBO(crafartOrderDO.getCurrencyDO(), new CurrencyBO()),
						beanMapper.mapCustomerDOToBO(crafartOrderDO.getCustomerDO(), new CustomerBO(), null, null),
						beanMapper.mapInvoiceDOToBO(crafartOrderDO.getInvoiceDO(), new InvoiceBO(),
								beanMapper.mapSellerDOToBO(crafartOrderDO.getStoreDO().getSellerDO(), new SellerBO(), new AddressBO(), new StoreBO(), null),
								beanMapper.mapCustomerDOToBO(crafartOrderDO.getCustomerDO(), new CustomerBO(), null, null)),
						beanMapper.mapProductDOToBO(crafartOrderDO.getProductDO(), new ProductBO(), new SellerBO(), null, null),
						beanMapper.mapStoreDOToBO(crafartOrderDO.getStoreDO(), new StoreBO(),
								beanMapper.mapSellerDOToBO(crafartOrderDO.getStoreDO().getSellerDO(), new SellerBO(), new AddressBO(), new StoreBO(), null)),
						beanMapper.mapTaxRateDOToBO(crafartOrderDO.getTaxRateDO(), new TaxRateBO(),
								beanMapper.mapProductDOToBO(crafartOrderDO.getProductDO(), new ProductBO(), new SellerBO(), null, null)));
				crafartOrderBOs.add(crafartOrderBO);
			}

		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriving order details for customer id " + customerId, cdExp);
		}
		return crafartOrderBOs;
	}

	@Override
	public CrafartOrderBO addCustomerOrder(CrafartOrderBO crafartOrderBO) throws CrafartServiceException {
		CrafartOrderDO crafartOrderDO = beanMapper.mapCrafartOrderBOToDO(crafartOrderBO, new CrafartOrderDO(), new CommissionDO(), new CourierDO(), new CrafartUserDO(), new CurrencyDO(),
				new CustomerDO(), new InvoiceDO(), new ProductDO(), new StoreDO(), new TaxRateDO());
		try {
			crafartOrderDAOImpl.addCrafartOrder(crafartOrderDO);
		} catch (CrafartDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
