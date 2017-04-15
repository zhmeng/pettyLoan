package com.hl.loan.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CollectLoanInfo")
public class CollectLoanInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collectloanId")
	private Integer collectloanId;//确认贷款id
	

	@Column(name = "applyCode")
	private String applyCode; // 贷款申请编号
	
	@Column(name = "applyID")
	private Long applyID; // ID
	
	@Column(name = "loanTime")
	private Integer loanTime; // 还款期限，贷款总月数
	
	@Column(name = "collectLoanDate")
	private String collectLoanDate;//收款时间
	
	@Column(name = "collectLoanInterest")
	private BigDecimal collectLoanInterest;//实收金额
	
	@Column(name = "status")
	private Integer status;

	public Integer getCollectloanId() {
		return collectloanId;
	}

	public void setCollectloanId(Integer collectloanId) {
		this.collectloanId = collectloanId;
	}


	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public Long getApplyID() {
		return applyID;
	}

	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}
	public Integer getLoanTime() {
		return loanTime;
	}

	public void setLoanTime(Integer loanTime) {
		this.loanTime = loanTime;
	}

	

	public String getCollectLoanDate() {
		return collectLoanDate;
	}

	public void setCollectLoanDate(String collectLoanDate) {
		this.collectLoanDate = collectLoanDate;
	}

	public BigDecimal getCollectLoanInterest() {
		return collectLoanInterest;
	}

	public void setCollectLoanInterest(BigDecimal collectLoanInterest) {
		this.collectLoanInterest = collectLoanInterest;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
	

}
