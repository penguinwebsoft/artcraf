/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "TAX_RULE")
public class TaxRuleDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8516553669476251903L;

	@Id
	@Column(name = "tax_rule_id")
	@SequenceGenerator(name = "seq_taxrule", sequenceName = "seq_taxrule", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_taxrule")
	private long taxRuleId;

	@Column(name = "tax_class_id")
	private long taxClassId;

	@ManyToOne
	@JoinColumn(name = "tax_rate_id")
	private TaxRateDO taxRateDO;
	
	
	@Column(name = "value")
	private String value;

	@Column(name = "based")
	private String based;

	@Column(name = "priority")
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

	public TaxRateDO getTaxRateDO() {
		return taxRateDO;
	}

	public void setTaxRateDO(TaxRateDO taxRateDOs) {
		this.taxRateDO = taxRateDOs;
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