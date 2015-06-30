package com.crafart.seller.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.AttributeBO;
import com.crafart.service.exception.CrafartServiceException;

@Service
public interface ManageAttributeService {

	public void addAttribute(AttributeBO attributeBO)throws CrafartServiceException;
	
	public void updateAttribute(AttributeBO attributeBO)throws CrafartServiceException;
	
	public Map<Long, AttributeBO> getAttributes() throws CrafartServiceException;
}
