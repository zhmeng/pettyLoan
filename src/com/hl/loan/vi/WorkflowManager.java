package com.hl.loan.vi;

import java.io.File;
import java.util.Date;



public class WorkflowManager {
	private Long bsnId;
	private String bsnName;					//流程名称
	private String bsnDesc;			//说明
	private String crtVrsn;						//版本
	private String updVrsn;				
	private String bsnDplMet;
	private Date createDate;					//创建时间
	private Integer createUID;					//创建人ID
	private String createUName;					//创建人
	private Long vrsnId;
	private String processStep;				//步骤
	private File process;
	public Long getBsnId() {
		return bsnId;
	}
	public void setBsnId(Long bsnId) {
		this.bsnId = bsnId;
	}
	public String getBsnName() {
		return bsnName;
	}
	public void setBsnName(String bsnName) {
		this.bsnName = bsnName;
	}
	public String getBsnDesc() {
		return bsnDesc;
	}
	public void setBsnDesc(String bsnDesc) {
		this.bsnDesc = bsnDesc;
	}
	public String getCrtVrsn() {
		return crtVrsn;
	}
	public void setCrtVrsn(String crtVrsn) {
		this.crtVrsn = crtVrsn;
	}
	public String getUpdVrsn() {
		return updVrsn;
	}
	public void setUpdVrsn(String updVrsn) {
		this.updVrsn = updVrsn;
	}
	public String getBsnDplMet() {
		return bsnDplMet;
	}
	public void setBsnDplMet(String bsnDplMet) {
		this.bsnDplMet = bsnDplMet;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getCreateUID() {
		return createUID;
	}
	public void setCreateUID(Integer createUID) {
		this.createUID = createUID;
	}
	public String getCreateUName() {
		return createUName;
	}
	public void setCreateUName(String createUName) {
		this.createUName = createUName;
	}
	public Long getVrsnId() {
		return vrsnId;
	}
	public void setVrsnId(Long vrsnId) {
		this.vrsnId = vrsnId;
	}
	public String getProcessStep() {
		return processStep;
	}
	public void setProcessStep(String processStep) {
		this.processStep = processStep;
	}
	public File getProcess() {
		return process;
	}
	public void setProcess(File process) {
		this.process = process;
	}
	
}
