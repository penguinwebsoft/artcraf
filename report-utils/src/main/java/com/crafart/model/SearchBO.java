package com.crafart.model;

import java.util.Map;

public class SearchBO {

	private String searchTerm;

	private Map<String, String> searchAttributes;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public Map<String, String> getSearchAttributes() {
		return searchAttributes;
	}

	public void setSearchAttributes(Map<String, String> searchAttributes) {
		this.searchAttributes = searchAttributes;
	}

}
