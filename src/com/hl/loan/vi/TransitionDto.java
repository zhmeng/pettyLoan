package com.hl.loan.vi;

public class TransitionDto {
	private String curActName; // 当前步骤名称
	private String transName; // 流转路径名称
	private String nextActName; // 下个步骤名称

	public String getCurActName() {
		return curActName;
	}

	public String getTransName() {
		return transName;
	}

	public String getNextActName() {
		return nextActName;
	}

	public void setCurActName(String curActName) {
		this.curActName = curActName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public void setNextActName(String nextActName) {
		this.nextActName = nextActName;
	}

}
