package com.hl.loan.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comBaseData")
public class ComBaseData implements Serializable{
	/*
	 * 数字字典
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BaseId")
	private Long baseId;
	@Column(name="BaseName")
	private String baseName;
	@Column(name="BaseDataList")
	private String baseDataList;
	@Column(name="BaseSplitChar")
	private String baseSplitChar;
	@Column(name="BaseDefault")
	private String baseDefault;
	@Column(name="BaseCtrl")
	private Integer baseCtrl;
	@Column(name="BaseDesc")
	private String baseDesc;
	public Long getBaseId() {
		return baseId;
	}
	public void setBaseId(Long baseId) {
		this.baseId = baseId;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getBaseDataList() {
		return baseDataList;
	}
	public void setBaseDataList(String baseDataList) {
		this.baseDataList = baseDataList;
	}
	public String getBaseSplitChar() {
		return baseSplitChar;
	}
	public void setBaseSplitChar(String baseSplitChar) {
		this.baseSplitChar = baseSplitChar;
	}
	public String getBaseDefault() {
		return baseDefault;
	}
	public void setBaseDefault(String baseDefault) {
		this.baseDefault = baseDefault;
	}
	public Integer getBaseCtrl() {
		return baseCtrl;
	}
	public void setBaseCtrl(Integer baseCtrl) {
		this.baseCtrl = baseCtrl;
	}
	public String getBaseDesc() {
		return baseDesc;
	}
	public void setBaseDesc(String baseDesc) {
		this.baseDesc = baseDesc;
	}
	
}





