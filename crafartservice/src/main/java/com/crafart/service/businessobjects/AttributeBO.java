package com.crafart.service.businessobjects;

public class AttributeBO {

	private long attributeId;
	
	private CategoryBO categoryBO;
	
	private CategoryBO subCategoryBO;
	
	private String attributeName;
	
	private int sortOrder;
	
	private boolean update;

	public long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}

	public CategoryBO getCategoryBO() {
		return categoryBO;
	}

	public void setCategoryBO(CategoryBO categoryBO) {
		this.categoryBO = categoryBO;
	}
	
	public CategoryBO getSubCategoryBO() {
		return subCategoryBO;
	}

	public void setSubCategoryBO(CategoryBO subCategoryBO) {
		this.subCategoryBO = subCategoryBO;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
	
}
