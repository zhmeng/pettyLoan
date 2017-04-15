package com.hl.loan.vi;

public class Radios {
	public Radios(String cValue,String name,String iD,Integer isCheck){
		setCValue(cValue);
		setcName(name);
		setID(iD);
		setIsCheck(isCheck);
	}
	private  String CValue;
	private String cName;
	private String ID;
	private Integer IsCheck=0;
	public String getCValue() {
		return CValue;
	}
	public void setCValue(String cValue) {
		CValue = cValue;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Integer getIsCheck() {
		return IsCheck;
	}
	public void setIsCheck(Integer isCheck) {
		IsCheck = isCheck;
	}
}
