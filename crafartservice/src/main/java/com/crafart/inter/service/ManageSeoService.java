package com.crafart.inter.service;

import org.springframework.stereotype.Service;

import com.crafart.service.businessobjects.SeoBO;
import com.crafart.service.exception.CrafartServiceException;

/**
 * @author Karthi
 *
 */
@Service("manageSeoService")
public interface ManageSeoService {
	public void addSeo(SeoBO seoBO) throws CrafartServiceException;
}
