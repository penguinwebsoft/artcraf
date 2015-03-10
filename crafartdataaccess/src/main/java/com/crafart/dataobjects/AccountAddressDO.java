/**
 * 
 */
package com.crafart.dataobjects;

/**
 * @author Karthi
 *
 */
public class AccountAddressDO {

	private long accountAddressId;
	
	private long accountId;
	
	private long addressId;

	public long getAccountAddressId() {
		return accountAddressId;
	}

	public void setAccountAddressId(long accountAddressId) {
		this.accountAddressId = accountAddressId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
}
