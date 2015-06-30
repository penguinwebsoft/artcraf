package com.crafart.model;

import java.util.List;


public class OrderDeclarationBO implements ReportModel {
	
	private String FIRST_NAME;
	
	private String LAST_NAME;
	
	private String ORDER_ID;
	
	private String QTY;
	
	private String DESC;
	
	private String STREET_NAME;
	
	private String LANDMARK;
	
	private String STATE;
	
	private String CITY;
	
	private String PIN_CODE;
	
	private String GROSS_AMT;

	private String DISCOUNT;

	private String NET_AMT;

	private String TAX_RATE;

	private String TAX_TYPE;

	private String TAX_AMOUNT;
	
	private List<Order> customerOrderList;

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String firstName) {
		this.FIRST_NAME = firstName;
	}


	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(String oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public String getQTY() {
		return QTY;
	}

	public void setQTY(String qTY) {
		QTY = qTY;
	}

	public String getDESC() {
		return DESC;
	}

	public void setDESC(String dESC) {
		DESC = dESC;
	}

	public String getSTREET_NAME() {
		return STREET_NAME;
	}

	public void setSTREET_NAME(String sTREET_NAME) {
		STREET_NAME = sTREET_NAME;
	}

	public String getLANDMARK() {
		return LANDMARK;
	}

	public void setLANDMARK(String lANDMARK) {
		LANDMARK = lANDMARK;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getPIN_CODE() {
		return PIN_CODE;
	}

	public void setPIN_CODE(String pINCODE) {
		PIN_CODE = pINCODE;
	}

	public List<Order> getCustomerOrderList() {
		return customerOrderList;
	}

	public void setCustomerOrderList(List<Order> customerOrderList) {
		this.customerOrderList = customerOrderList;
	}

	public String getGROSS_AMT() {
		return GROSS_AMT;
	}

	public void setGROSS_AMT(String gROSS_AMT) {
		GROSS_AMT = gROSS_AMT;
	}

	public String getDISCOUNT() {
		return DISCOUNT;
	}

	public void setDISCOUNT(String dISCOUNT) {
		DISCOUNT = dISCOUNT;
	}

	public String getNET_AMT() {
		return NET_AMT;
	}

	public void setNET_AMT(String nET_AMT) {
		NET_AMT = nET_AMT;
	}

	public String getTAX_RATE() {
		return TAX_RATE;
	}

	public void setTAX_RATE(String tAX_RATE) {
		TAX_RATE = tAX_RATE;
	}

	public String getTAX_TYPE() {
		return TAX_TYPE;
	}

	public void setTAX_TYPE(String tAX_TYPE) {
		TAX_TYPE = tAX_TYPE;
	}

	public String getTAX_AMOUNT() {
		return TAX_AMOUNT;
	}

	public void setTAX_AMOUNT(String tAX_AMOUNT) {
		TAX_AMOUNT = tAX_AMOUNT;
	}

}