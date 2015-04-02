/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class TaxRuleBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7665585177807453957L;

	private long taxRuleId;

	private long taxClassId;

	private TaxRateBO taxRateBO;

	private String value;

	private String based;

	private int priority;

	public long getTaxRuleId() {
		return taxRuleId;
	}

	public void setTaxRuleId(long taxRuleId) {
		this.taxRuleId = taxRuleId;
	}

	public long getTaxClassId() {
		return taxClassId;
	}

	public void setTaxClassId(long taxClassId) {
		this.taxClassId = taxClassId;
	}

	public TaxRateBO getTaxRateBO() {
		return taxRateBO;
	}

	public void setTaxRateBO(TaxRateBO taxRateBO) {
		this.taxRateBO = taxRateBO;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBased() {
		return based;
	}

	public void setBased(String based) {
		this.based = based;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
