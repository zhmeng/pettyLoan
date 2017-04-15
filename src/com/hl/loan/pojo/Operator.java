package com.hl.loan.pojo;

import java.util.List;

import com.hl.loan.vi.Radios;

public class Operator {
	private String mid;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	private Integer look;				//查  1
	private Integer islook;
	private Integer add;				//增  2
	private Integer isadd;
	private Integer update;				// 改4
	private Integer isupdate;	
	private Integer delete;				//删  8
	private Integer isdelete;	
	public Integer getLook() {
		return look;
	}
	public void setLook(Integer look) {
		this.look = look;
	}
	public Integer getAdd() {
		return add;
	}
	public void setAdd(Integer add) {
		this.add = add;
	}
	public Integer getUpdate() {
		return update;
	}
	public void setUpdate(Integer update) {
		this.update = update;
	}
	public Integer getDelete() {
		return delete;
	}
	public void setDelete(Integer delete) {
		this.delete = delete;
	}
	public Integer getIslook() {
		return islook;
	}
	public void setIslook(Integer islook) {
		this.islook = islook;
	}
	public Integer getIsadd() {
		return isadd;
	}
	public void setIsadd(Integer isadd) {
		this.isadd = isadd;
	}
	public Integer getIsupdate() {
		return isupdate;
	}
	public void setIsupdate(Integer isupdate) {
		this.isupdate = isupdate;
	}
	public Integer getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	
	private List<Checkbox> checkboxList;
	public List<Checkbox> getCheckboxList() {
		return checkboxList;
	}
	public void setCheckboxList(List<Checkbox> checkboxList) {
		this.checkboxList = checkboxList;
	}
	private List<Radios> radiosList;
	public List<Radios> getRadiosList() {
		return radiosList;
	}
	public void setRadiosList(List<Radios> radiosList) {
		this.radiosList = radiosList;
	}
	
	
}
