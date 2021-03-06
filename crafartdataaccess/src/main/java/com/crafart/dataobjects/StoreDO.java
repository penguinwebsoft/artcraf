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
 * store entity data object maps to store table in crafart database. Property
 * belongs to store table and store_id is primary key which is generated by db
 * sequence <blockquote>seq_store<blockquote>
 * 
 * @author Karthi
 * @version 1.0
 * 
 */
@Entity
@Table(name = "STORE")
public class StoreDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3168290124126749175L;

	@Id
	@Column(name = "store_id")
	@SequenceGenerator(name = "seq_store", sequenceName = "seq_store", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_store")
	private long storeId;

	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private SellerDO sellerDO;

	@Column(name = "name")
	private String name;

	@Column(name = "store_url")
	private String storeUrl;

	@Column(name = "store_description")
	private String storeDescription;

	@Column(name = "return")
	private String storeReturn;

	public SellerDO getSellerDO() {
		return sellerDO;
	}

	public void setSellerDO(SellerDO sellerDO) {
		this.sellerDO = sellerDO;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public void setStoreDescription(String store_Description) {
		this.storeDescription = store_Description;
	}

	public String getStoreReturn() {
		return storeReturn;
	}

	public void setStoreReturn(String store_Return) {
		this.storeReturn = store_Return;
	}

}
