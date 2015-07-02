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
	private String symbolLeft;

	@Column(name = "symbol_right")
	private String symbolRight;

	//decimal place is of type small int, it can hold +32767 <--> -32767
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

	

	public String getSymbolRight() {
		return symbolRight;
	}

	public void setSymbolRight(String symbolRight) {
		this.symbolRight = symbolRight;
	}

	public String getSymbolLeft() {
		return symbolLeft;
	}

	public void setSymbolLeft(String symbolLeft) {
		this.symbolLeft = symbolLeft;
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
