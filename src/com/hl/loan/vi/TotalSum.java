package com.hl.loan.vi;

import java.io.Serializable;

public class TotalSum implements Serializable{
	private Integer sum;
	private Integer upsum;
	private Integer addsum;
	private Integer passsum;
	private Integer userId;
	private String times;
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
	}
	public Integer getUpsum() {
		return upsum;
	}
	public void setUpsum(Integer upsum) {
		this.upsum = upsum;
	}
	public Integer getAddsum() {
		return addsum;
	}
	public void setAddsum(Integer addsum) {
		this.addsum = addsum;
	}
	public Integer getPasssum() {
		return passsum;
	}
	public void setPasssum(Integer passsum) {
		this.passsum = passsum;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	
}
