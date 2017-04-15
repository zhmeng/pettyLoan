package com.hl.loan.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import java.util.Date;

@Entity
@Table(name = "comlp")
public class ComLp implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 楼盘实体
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LpID")
	private Long lpID; // ID

	@Column(name = "LpKey")
	private String lpKey; // 楼盘编码

	@Column(name = "LpName")
	private String lpName; // 楼盘名称

	@Column(name = "LpState")
	private Integer lpState; // 楼盘状态 0：无效，1：生效，2：过期，4：删除
	
	@Column(name = "LpAddr")
	private String lpAddr; // 楼盘详细地址
	
	@Column(name = "LpGM")
	private String lpGM; // 负责人姓名

	@Column(name = "LpTel")
	private String lpTel; // 负责人电话
	
	@Column(name = "CityID")
	private Long cityID; // 城市ID
	
	@Column(name = "CompanyID")
	private Long companyID; // 开发商ID
	
	@Column(name = "CreateById")
	private Long createById; // 创建人
	
	@Column(name = "UpdateById")
	private Long updateById; // 修改人
	
	@Column(name = "CreateTime")
	private Date createTime; // 创建时间
	
	@Column(name = "UpdateTime")
	private Date updateTime; // 修改时间
	
	@Column(name = "BankName")
	private String bankName; // 银行名称
	
	@Column(name = "BankAccount")
	private String bankAccount; // 银行帐号
	
	@Column(name = "BankMan")
	private String bankMan; // 银行帐号归属人
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getBankMan() {
		return bankMan;
	}
	public void setBankMan(String bankMan) {
		this.bankMan = bankMan;
	}

	//---------------------------------- Formula ----------------------------------
	@Formula("(select c.companyName from Company c where c.companyID = companyID)") 
	private String companyName;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	//---------------------------------- Formula ----------------------------------

	public Long getLpID() {
		return lpID;
	}

	public void setLpID(Long lpID) {
		this.lpID = lpID;
	}

	public String getLpKey() {
		return lpKey;
	}

	public void setLpKey(String lpKey) {
		this.lpKey = lpKey;
	}

	public String getLpName() {
		return lpName;
	}

	public void setLpName(String lpName) {
		this.lpName = lpName;
	}

	public Integer getLpState() {
		return lpState;
	}

	public void setLpState(Integer lpState) {
		this.lpState = lpState;
	}

	public String getLpAddr() {
		return lpAddr;
	}

	public void setLpAddr(String lpAddr) {
		this.lpAddr = lpAddr;
	}

	public String getLpGM() {
		return lpGM;
	}

	public void setLpGM(String lpGM) {
		this.lpGM = lpGM;
	}

	public String getLpTel() {
		return lpTel;
	}

	public void setLpTel(String lpTel) {
		this.lpTel = lpTel;
	}

	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public Long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	public Long getCreateById() {
		return createById;
	}

	public void setCreateById(Long createById) {
		this.createById = createById;
	}

	public Long getUpdateById() {
		return updateById;
	}

	public void setUpdateById(Long updateById) {
		this.updateById = updateById;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}