/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
/**
 * @author Deepam
 *
 */
@Entity
@Table(name = "TAX_RATE")
public class TaxRateDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6964002572272935301L;
	

	@Id
	@Column(name = "tax_rate_id")
	@SequenceGenerator(name = "seq_taxrate", sequenceName = "seq_taxrate", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_taxrate")
	private long taxRateId;

	@Column(name = "seller_id")
	private long sellerId;

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private ProductDO productDO;

	@Column(name = "name")
	private String name;

	@Column(name = "rate")
	private int rate;

	@Column(name = "type")
	private String type;

	@OneToMany(mappedBy="taxRateDO")
	private List<TaxRuleDO> taxRuleDOs;
	
	
	public List<TaxRuleDO> getTaxRuleDO() {
		return taxRuleDOs;
	}

	public void setTaxRuleDO(List<TaxRuleDO> taxRuleDO) {
		this.taxRuleDOs = taxRuleDO;
	}

	public long getTaxRateId() {
		return taxRateId;
	}

	public void setTaxRateId(long taxRateId) {
		this.taxRateId = taxRateId;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public ProductDO getProductDO() {
		return productDO;
	}

	public void setProductDO(ProductDO productDO) {
		this.productDO = productDO;
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
}
