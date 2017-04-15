package com.hl.loan.vi;

public class Buttons {
	
	private  Integer CValue;
	private String cName;
	private String cid;
	private Integer isShow=0;
	private String urls;
	private String scripts;
	public Integer getCValue() {
		return CValue;
	}
	public void setCValue(Integer cValue) {
		CValue = cValue;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public String getScripts() {
		return scripts;
	}
	public void setScripts(String scripts) {
		this.scripts = scripts;
	}
	
}
