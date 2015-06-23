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

	private Integer decimalPlace;

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

	public void setSymbolLeft(char c) {
		this.symbolLeft = c;
	}

	public char getSymbolRight() {
		return symbolRight;
	}

	public void setSymbolRight(char c) {
		this.symbolRight = c;
	}

	public Integer getDecimalPlace() {
		return decimalPlace;
	}

	public void setDecimalPlace(Integer decimalPlace) {
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
