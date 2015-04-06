/**
 * 
 */
package com.crafart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AttributeGroupDescDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeGroupDescDAO;
import com.crafart.inter.service.ManageAttributeGroupDescService;
import com.crafart.service.businessobjects.AttributeGroupDescBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Karthi
 * 
 */
@Service("manageAttributeGroupDescServiceImpl")
public class ManageAttributeGroupDescServiceImpl implements ManageAttributeGroupDescService {

	@Autowired
	private BeanMapper beanMapper;

	@Autowired
	private AttributeGroupDescDAO attributeGroupDescDAOImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<AttributeGroupDescBO> getAttributeGroupDesc() throws CrafartServiceException {
		List<AttributeGroupDescBO> attributeGroupDescBOs = new ArrayList<>();
		try {
			List<AttributeGroupDescDO> attributeGroupDescDOs = attributeGroupDescDAOImpl.getAttributeGroupDesc();
			for (AttributeGroupDescDO attributeGroupDescDO : attributeGroupDescDOs) {
				AttributeGroupDescBO attributeGroupDescBO = beanMapper.mapAttributeGroupDescDOToBO(attributeGroupDescDO, new AttributeGroupDescBO());
				attributeGroupDescBOs.add(attributeGroupDescBO);
			}
		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while retriving detail", cdExp);
		}

		return attributeGroupDescBOs;
	}

}
