/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;

/**
 * @author Karthi
 * 
 */
public class CurrencyBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6724863802773364598L;

	private long currencyId;

	private String title;

	private String code;

	private char symbolLeft;

	private char symbolRight;

	private int decimalPlace;

	private double value;

	private String status;

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public char getSymbolLeft() {
		return symbolLeft;
	}

	public void setSymbolLeft(char symbolLeft) {
		this.symbolLeft = symbolLeft;
	}

	public char getSymbolRight() {
		return symbolRight;
	}

	public void setSymbolRight(char symbolRight) {
		this.symbolRight = symbolRight;
	}

	public int getDecimalPlace() {
		return decimalPlace;
	}

	public void setDecimalPlace(int decimalPlace) {
		this.decimalPlace = decimalPlace;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
