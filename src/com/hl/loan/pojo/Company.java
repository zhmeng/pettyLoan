package com.hl.loan.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 开发商实体
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CompanyID")
	private Long companyID; // ID

	@Column(name = "CompanyKey")
	private String companyKey; // 开发商编码

	@Column(name = "CompanyName")
	private String companyName; // 开发商名称

	@Column(name = "CompanyState")
	private Integer companyState; // 开发商状态 0：无效，1：生效，2：过期，4：删除
	
	@Column(name = "CompanyFName")
	private String companyFName; // 法人代表姓名
	
	@Column(name = "CompanyFTel")
	private String companyFTel; // 法人代表电话

	@Column(name = "CompanyBankNameA")
	private String companyBankNameA; // 银行名称A
	
	@Column(name = "CompanyBankNameB")
	private String companyBankNameB; // 银行名称B
	
	@Column(name = "CompanyAccoutA")
	private String companyAccoutA; // 银行帐号A
	
	@Column(name = "CompanyAccoutB")
	private String companyAccoutB; // 银行帐号B
	
	@Column(name = "CreateById")
	private Long createById; // 创建人
	
	@Column(name = "UpdateById")
	private Long updateById; // 修改人
	
	@Column(name = "CreateTime")
	private Date createTime; // 创建时间
	
	@Column(name = "UpdateTime")
	private Date updateTime; // 修改时间
	
	@Column(name = "DelayCostRate")
	private BigDecimal delayCostRate; // 逾期本金扣罚费率

	@Column(name = "DelayInterestRate")
	private BigDecimal delayInterestRate; // 逾期利息扣罚费率

	public BigDecimal getDelayInterestRate() {
		return delayInterestRate;
	}

	public void setDelayInterestRate(BigDecimal delayInterestRate) {
		this.delayInterestRate = delayInterestRate;
	}

	public BigDecimal getDelayCostRate() {
		return delayCostRate;
	}

	public void setDelayCostRate(BigDecimal delayCostRate) {
		this.delayCostRate = delayCostRate;
	}

	public Long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	public String getCompanyKey() {
		return companyKey;
	}

	public void setCompanyKey(String companyKey) {
		this.companyKey = companyKey;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyState() {
		return companyState;
	}

	public void setCompanyState(Integer companyState) {
		this.companyState = companyState;
	}

	public String getCompanyFName() {
		return companyFName;
	}

	public void setCompanyFName(String companyFName) {
		this.companyFName = companyFName;
	}

	public String getCompanyFTel() {
		return companyFTel;
	}

	public void setCompanyFTel(String companyFTel) {
		this.companyFTel = companyFTel;
	}

	public String getCompanyBankNameA() {
		return companyBankNameA;
	}

	public void setCompanyBankNameA(String companyBankNameA) {
		this.companyBankNameA = companyBankNameA;
	}

	public String getCompanyBankNameB() {
		return companyBankNameB;
	}

	public void setCompanyBankNameB(String companyBankNameB) {
		this.companyBankNameB = companyBankNameB;
	}

	public String getCompanyAccoutA() {
		return companyAccoutA;
	}

	public void setCompanyAccoutA(String companyAccoutA) {
		this.companyAccoutA = companyAccoutA;
	}

	public String getCompanyAccoutB() {
		return companyAccoutB;
	}

	public void setCompanyAccoutB(String companyAccoutB) {
		this.companyAccoutB = companyAccoutB;
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