/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;
import java.util.List;

/**
 * @author Karthi
 * 
 */
public class TaxRateBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6568227143824018160L;

	private long taxRateId;

	private long sellerId;

	private ProductBO productBO;

	private String name;

	private int rate;

	private String type;

	private List<TaxRuleBO> taxRuleBOs;

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProductBO getProductBO() {
		return productBO;
	}

	public void setProductBO(ProductBO productBO) {
		this.productBO = productBO;
	}

	public long getTaxRateId() {
		return taxRateId;
	}

	public void setTaxRateId(long taxRateId) {
		this.taxRateId = taxRateId;
	}

	public List<TaxRuleBO> getTaxRuleBOs() {
		return taxRuleBOs;
	}

	public void setTaxRuleBOs(List<TaxRuleBO> taxRuleBOs) {
		this.taxRuleBOs = taxRuleBOs;
	}

}
