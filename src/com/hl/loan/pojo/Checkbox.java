package com.hl.loan.pojo;

public class Checkbox {
	public Checkbox(String cValue,String name,String iD,Integer isCheck){
		setCValue(cValue);
		setCName(name);
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
	public String getCName() {
		return cName;
	}
	public void setCName(String name) {
		cName = name;
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
