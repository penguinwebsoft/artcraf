/**
 * 
 */
package com.crafart.dataobjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "SELLER_ADDRESS")
public class SellerAddressDO {

	@Id
	@Column(name = "seller_address_id")
	@SequenceGenerator(name = "seq_selleraddress", sequenceName = "seq_selleraddress")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_selleraddress")
	private long sellerAddressId;

	@Column(name = "seller_id")
	private long sellerId;

	@Column(name = "address_id")
	private long addressId;

	public long getSellerAddressId() {
		return sellerAddressId;
	}

	public void setSellerAddressId(long sellerAddressId) {
		this.sellerAddressId = sellerAddressId;
	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
}
