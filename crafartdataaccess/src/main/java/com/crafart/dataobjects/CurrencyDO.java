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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Karthi
 * 
 */
@Entity
@Table(name = "Currency")
public class CurrencyDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3624386195708211631L;

	@Id
	@Column(name = "currency_id")
	@SequenceGenerator(name = "seq_currency", sequenceName = "seq_currency", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_currency")
	private long currencyId;

	@Column(name = "title")
	private String title;

	@Column(name = "code")
	private String code;

	@Column(name = "symbol_left")
	private char symbolLeft;

	@Column(name = "symbol_right")
	private char symbolRight;

	@Column(name = "decimal_place")
	private int decimalPlace;

	@Column(name = "value")
	private double value;

	@Column(name = "status")
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
