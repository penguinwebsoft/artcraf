/**
 * 
 */
package com.crafart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.CategoryDAO;
import com.crafart.dataobjects.CategoryDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.service.businessobjects.CategoryBO;
import com.crafart.service.exception.CrafartServiceException;
import com.crafart.service.mapper.BeanMapper;

/**
 * @author Deepam
 * 
 */
@Service("manageCategoryServiceImpl")
public class ManageCategoryServiceImpl implements ManageCategoryService {

	private static final Logger log = Logger.getLogger(ManageCategoryServiceImpl.class);

	@Autowired
	private CategoryDAO categoryDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	/**
	 * getCategory() will get all details from database through
	 * {@link CategoryDAO} getCategory()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<CategoryBO> getCategory() throws CrafartServiceException {
		List<CategoryBO> categoryBOs = new ArrayList<>();
		try {
			List<CategoryDO> categoryDOs = categoryDAOImpl.getCategory();
			for (CategoryDO categoryDO : categoryDOs) {
				CategoryBO categoryBO = beanMapper.mapCategoryDOToBO(categoryDO, new CategoryBO());
				categoryBOs.add(categoryBO);
			}
		} catch (CrafartDataException e) {
			log.error("error while reteriving category");
		}
		return categoryBOs;
	}

	/**
	 * addCategory() will add the category details to database by using
	 * {@link CategoryDAO} addCategory()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addCategory(CategoryBO categoryBO) throws CrafartServiceException {
		CategoryDO categoryDO = beanMapper.mapCategoryBOToDO(categoryBO, new CategoryDO());
		try {
			categoryDAOImpl.addCategory(categoryDO);
			categoryBO.setCategoryId(categoryDO.getCategoryId());
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("Error while adding category" + categoryBO.getCategoryId());
		}
	}

}
