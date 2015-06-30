package com.crafart.seller.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AttributeDO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AttributeDAO;
import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.service.ManageCategoryService;
import com.crafart.service.businessobjects.AttributeBO;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.businessobjects.SeoBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

@Service("manageAttributeServiceImpl")
public class ManageAttributeServiceImpl implements ManageAttributeService {

	private static final Logger log = Logger.getLogger(ManageAttributeServiceImpl.class);

	@Autowired
	private AttributeDAO attributeDAOImpl;

	@Autowired
	private CategoryDAO categoryDAOImpl;

	@Autowired
	private ManageCategoryService manageCategoryServiceImpl;

	@Autowired
	private BeanMapper mapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addAttribute(AttributeBO attributeBO) throws CrafartServiceException {
		AttributeDO attributeDO = mapper.mapAttributeBOToDO(attributeBO, new AttributeDO());
		CategoryDO categoryDO = mapper.mapCategoryBOToDO(attributeBO.getSubCategoryBO(), new CategoryDO(), new SeoDO());
		List<CategoryDO> categoryDOs = new ArrayList<>();
		categoryDOs.add(categoryDO);
		attributeDO.setCategoryDOs(categoryDOs);

		try {
			attributeDAOImpl.addAttribute(attributeDO);
			attributeBO.setAttributeId(attributeDO.getAttributeId());
		} catch (CrafartDataException cExp) {
			throw new CrafartServiceException("Service error - error while adding attribute", cExp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Map<Long, AttributeBO> getAttributes() throws CrafartServiceException {
		try {
			List<AttributeDO> attributeDOs = attributeDAOImpl.getAllAttributes();
			Map<Long, AttributeBO> attributeBOs = new HashMap<>();
			for (AttributeDO attributeDO : attributeDOs) {
				AttributeBO attributeBO = mapper.mapAttributeDOToBO(attributeDO, new AttributeBO());
				if (attributeDO.getCategoryDOs().size() > 0) {
					CategoryBO subCategoryBO = mapper.mapCategoryDOToBO(attributeDO.getCategoryDOs().get(0), new CategoryBO(), new SeoBO());
					// setting subcategory
					attributeBO.setSubCategoryBO(subCategoryBO);
					// getting category which sub category belongs
					System.out.println("attribute id - " + attributeBO.getAttributeId());
					System.out.println("category id is - " + subCategoryBO.getParentId());
					CategoryBO categoryBO = manageCategoryServiceImpl.getCategory(subCategoryBO.getParentId());
					attributeBO.setCategoryBO(categoryBO);
				}
				attributeBOs.put(attributeBO.getAttributeId(), attributeBO);
			}
			return attributeBOs;
		} catch (CrafartDataException cExp) {
			throw new CrafartServiceException("Servce error - error while retrieving all attributes", cExp);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateAttribute(AttributeBO attributeBO) throws CrafartServiceException {
		try {
			log.info("service layer ********************** attribute id is - " + attributeBO.getAttributeId());
			AttributeDO attributeDO = attributeDAOImpl.getAttributeDO(attributeBO.getAttributeId());

			CategoryDO categoryDO = mapper.mapCategoryBOToDO(attributeBO.getSubCategoryBO(), new CategoryDO(), new SeoDO());
			List<CategoryDO> categoryDOs = new ArrayList<>();
			categoryDOs.add(categoryDO);
			attributeDO.setCategoryDOs(categoryDOs);
			/*CategoryDO subCategoryDO = attributeDO.getCategoryDOs().get(0);
			mapper.mapCategoryBOToDO(attributeBO.getSubCategoryBO(), subCategoryDO, subCategoryDO.getSeoDO());*/
			// getting category addtribute do from the list
			
			
			attributeDAOImpl.updateAttribute(attributeDO);
		} catch (CrafartDataException cExp) {
			throw new CrafartServiceException("Service error - error while updating attribute", cExp);
		}
	}
}