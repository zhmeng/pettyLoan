package com.hl.loan.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustomerLoan")
public class CustomerLoan implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="CustID")
	private Long custID;						//申请人外键
	
	@Column(name="LoanBank")
	private String loanBank;					//申请银行
	
	@Column(name="LoanAmt")
	private BigDecimal loanAmt;						//贷款金额
	
	@Column(name="PayDate")
	private Date payDate;						//贷款日期
	
	@Column(name="PayMonth")
	private BigDecimal payMonth;				//月还款金额
	
	@Column(name="IsoOverdue")
	private Integer isoOverdue;						//是否逾期   1是  2否
	
	@Column(name="ModifyUID")
	private Integer modifyUID;				//修改人ID
	
	@Column(name="ModifyUName")
	private String modifyUName;					//修改人姓名
	
	@Column(name="ModifyDate")
	private Date modifyDate;				//修改时间
	
	@Column(name="CreateUID")
	private Integer createUID;			//创建人ID
	
	@Column(name="CreateUName")
	private String createUName;				//创建人姓名
	
	@Column(name="CreateDate")
	private Date createDate;				//创建时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	public String getLoanBank() {
		return loanBank;
	}

	public void setLoanBank(String loanBank) {
		this.loanBank = loanBank;
	}

	public BigDecimal getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(BigDecimal loanAmt) {
		this.loanAmt = loanAmt;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public BigDecimal getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(BigDecimal payMonth) {
		this.payMonth = payMonth;
	}

	public Integer getIsoOverdue() {
		return isoOverdue;
	}

	public void setIsoOverdue(Integer isoOverdue) {
		this.isoOverdue = isoOverdue;
	}

	public Integer getModifyUID() {
		return modifyUID;
	}

	public void setModifyUID(Integer modifyUID) {
		this.modifyUID = modifyUID;
	}

	public String getModifyUName() {
		return modifyUName;
	}

	public void setModifyUName(String modifyUName) {
		this.modifyUName = modifyUName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}










