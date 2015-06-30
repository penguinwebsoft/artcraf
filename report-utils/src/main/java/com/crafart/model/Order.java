package com.crafart.model;


public class Order implements ReportModel{
	
	private String QTY;
	
	private String DESC;
	
	private String GROSS_AMT;

	private String DISCOUNT;

	private String NET_AMT;

	private String TAX_RATE;

	private String TAX_TYPE;

	private String TAX_AMOUNT;
	
	
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
