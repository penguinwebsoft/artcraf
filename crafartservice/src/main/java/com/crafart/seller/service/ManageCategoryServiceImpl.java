/**
 * 
 */
package com.crafart.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.CategoryDO;
import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.CategoryDAO;
import com.crafart.inter.data.SeoDAO;
import com.crafart.inter.service.ManageCategoryService;
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
	private SeoDAO seoDAOImpl;

	@Autowired
	private BeanMapper beanMapper;

	/**
	 * getCategory() will get all details from database through
	 * {@link CategoryDAO} getCategory()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CategoryBO> getCategory() throws CrafartServiceException {
		List<CategoryBO> categoryBOs = new ArrayList<>();
		try {
			List<CategoryDO> categoryDOs = categoryDAOImpl.getCategory();
			for (CategoryDO categoryDO : categoryDOs) {
				CategoryBO categoryBO = beanMapper.mapCategoryDOToBO(categoryDO, new CategoryBO(), null);
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
	@Transactional(propagation = Propagation.REQUIRED)
	public void addCategory(CategoryBO categoryBO) throws CrafartServiceException {
		try {
			SeoDO seoDO = beanMapper.mapSeoBOToDO(categoryBO.getSeoBO(), new SeoDO());
			seoDAOImpl.addSeo(seoDO);
			CategoryDO categoryDO = beanMapper.mapCategoryBOToDO(categoryBO, new CategoryDO(), seoDO);
			categoryDAOImpl.addCategory(categoryDO);
			categoryBO.setCategoryId(categoryDO.getCategoryId());
		} catch (CrafartDataException e) {
			throw new CrafartServiceException("Error while adding category" + categoryBO.getCategoryId());
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CategoryBO> getSubCategory(long categoryId) throws CrafartServiceException {
		List<CategoryBO> categoryBOs = new ArrayList<>();
		try {
			List<CategoryDO> categoryDOs = categoryDAOImpl.getSubCategory(categoryId);
			for (CategoryDO categoryDO : categoryDOs) {
				CategoryBO categoryBO = beanMapper.mapCategoryDOToBO(categoryDO, new CategoryBO(), null);
				categoryBOs.add(categoryBO);
			}

		} catch (CrafartDataException cdExp) {
			throw new CrafartServiceException("Error while fetching sub-category", cdExp);
		}
		return categoryBOs;

	}

}
