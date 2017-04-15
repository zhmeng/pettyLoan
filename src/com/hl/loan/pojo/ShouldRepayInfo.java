package com.hl.loan.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ShouldRepayInfo")
public class ShouldRepayInfo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	     
	     @Id
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	 @Column(name = "ID")
	     private Long ID ;
	     
	     @Column(name = "ApplyID")
	     private Long applyID ;//'贷款申请id',
	    
	     @Column(name = "ContractID")
	     private Long contractID;//'贷款合同id'
	     
	     @Column(name = "ShouldRepayAmount")
	     private Double shouldRepayAmount ;//'应还本金金额'
	     
	     @Column(name = "FactRepayAmount")
	     private Double factRepayAmount ;//'实还本金金额'
	    
	     @Column(name = "ShouldRepayInterst")
	     private Double shouldRepayInterst;//'应还利息'
	     
	     @Column(name = "FactRepayInterst")
	     private Double factRepayInterst ;//'实还利息'
	    
	     @Column(name = "ShouldRepayLateAmount")
	     private Double shouldRepayLateAmount ;//'应还逾期本金罚息金额'
	     
	     @Column(name = "FactRepayLateAmount")
	     private Double factRepayLateAmount;//'实还逾期本金罚息金额'
	     
	     @Column(name = "ShouldRepayLateInterst")
	     private Double shouldRepayLateInterst ;//'应还逾期罚息利息金额'
	     
	     @Column(name = "FactRepayLateInterst")
	     private Double factRepayLateInterst;//'实还逾期罚息利息金额'
	     
	     @Column(name = "CollectLoanInterest")
	     private Double collectLoanInterest;// '手续费'
	     
	     @Column(name = "repayDate")
	     private Date repayDate ;// '还款时间'
	     
	     @Column(name = "loanTime")
	     private Integer loanTime ;//'期限'
	     
	     @Column(name = "style")
	     private Integer style ;//--1 已结清，2 逾期，3 待还，4，提前结清

		public Long getID() {
			return ID;
		}

		public void setID(Long iD) {
			ID = iD;
		}

		public Long getApplyID() {
			return applyID;
		}

		public void setApplyID(Long applyID) {
			this.applyID = applyID;
		}

		public Long getContractID() {
			return contractID;
		}

		public void setContractID(Long contractID) {
			this.contractID = contractID;
		}

		public Double getShouldRepayAmount() {
			return shouldRepayAmount;
		}

		public void setShouldRepayAmount(Double shouldRepayAmount) {
			this.shouldRepayAmount = shouldRepayAmount;
		}

		public Double getFactRepayAmount() {
			return factRepayAmount;
		}

		public void setFactRepayAmount(Double factRepayAmount) {
			this.factRepayAmount = factRepayAmount;
		}

		public Double getShouldRepayInterst() {
			return shouldRepayInterst;
		}

		public void setShouldRepayInterst(Double shouldRepayInterst) {
			this.shouldRepayInterst = shouldRepayInterst;
		}

		public Double getFactRepayInterst() {
			return factRepayInterst;
		}

		public void setFactRepayInterst(Double factRepayInterst) {
			this.factRepayInterst = factRepayInterst;
		}

		public Double getShouldRepayLateAmount() {
			return shouldRepayLateAmount;
		}

		public void setShouldRepayLateAmount(Double shouldRepayLateAmount) {
			this.shouldRepayLateAmount = shouldRepayLateAmount;
		}

		public Double getFactRepayLateAmount() {
			return factRepayLateAmount;
		}

		public void setFactRepayLateAmount(Double factRepayLateAmount) {
			this.factRepayLateAmount = factRepayLateAmount;
		}

		public Double getShouldRepayLateInterst() {
			return shouldRepayLateInterst;
		}

		public void setShouldRepayLateInterst(Double shouldRepayLateInterst) {
			this.shouldRepayLateInterst = shouldRepayLateInterst;
		}

		public Double getFactRepayLateInterst() {
			return factRepayLateInterst;
		}

		public void setFactRepayLateInterst(Double factRepayLateInterst) {
			this.factRepayLateInterst = factRepayLateInterst;
		}

		public Double getCollectLoanInterest() {
			return collectLoanInterest;
		}

		public void setCollectLoanInterest(Double collectLoanInterest) {
			this.collectLoanInterest = collectLoanInterest;
		}

		public Date getRepayDate() {
			return repayDate;
		}

		public void setRepayDate(Date repayDate) {
			this.repayDate = repayDate;
		}

		public Integer getLoanTime() {
			return loanTime;
		}

		public void setLoanTime(Integer loanTime) {
			this.loanTime = loanTime;
		}

		public Integer getStyle() {
			return style;
		}

		public void setStyle(Integer style) {
			this.style = style;
		}
	     
	     
	    
}
