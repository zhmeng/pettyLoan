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
@Table(name = "contract")
public class Contract implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 合同实体
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ContractID")
	private Long contractID; // 合同ID

	@Column(name = "ApplyID")
	private Long applyID; // 贷款申请单记录ID,贷款申请单信息表的记录ID
	
	@Column(name = "ContractNo")
	private String contractNo; // 合同编号，自动带贷款申请号
	
	@Column(name = "ContractName")
	private String contractName; // 合同名称 
	
	@Column(name = "CustName")
	private String custName; // 客户名称
	
	@Column(name = "CustNo")
	private String custNo; // 客户证件号
	
	@Column(name = "Addr")
	private String addr; // 住所
	
	@Column(name = "Amt")
	private BigDecimal amt; // 贷款金额
	
	@Column(name = "Payment")
	private Integer payment; // 还款方式
	
	@Column(name = "Rate")
	private BigDecimal rate; // 财务顾问费率
	
	@Column(name = "FeeRate")
	private BigDecimal feeRate; // 贷款手续费率
	
	@Column(name = "Fees")
	private BigDecimal fees; // 贷款手续费
	
	@Column(name = "ManageFeeRate")
	private BigDecimal manageFeeRate; // 行政管理费率
	
	@Column(name = "ManageFees")
	private BigDecimal manageFees; // 行政管理费
	
	@Column(name = "DelayFeeRate")
	private BigDecimal delayFeeRate; // 延迟还款手续费

	@Column(name = "DelayCostRate")
	private BigDecimal delayCostRate; // 逾期本金扣罚费率
	
	@Column(name = "DelayInterestRate")
	private BigDecimal delayInterestRate; // 逾期利息扣罚费率

	@Column(name = "LoanStatus")
	private int loanStatus; // 放款状态 0：未放款，1：已放款，默认0
	
	@Column(name = "ReturnStatus")
	private int returnStatus; // 回款状态 0：未结清，1：已结清，默认0
	
	@Column(name = "Remark")
	private String remark; // 备注
	
	@Column(name = "CreateBy")
	private String createBy; // 建档人姓名
	
	@Column(name = "CreateByID")
	private int createByID; // 建档人ID
	
	@Column(name = "CreateTime")
	private Date createTime; // 建档时间

	@Column(name = "ModifyBy")
	private String modifyBy; // 修改人姓名
	
	@Column(name = "ModifyByID")
	private int modifyByID; // 修改人ID

	@Column(name = "ModifyTime")
	private Date modifyTime; // 修改时间
	
	@Column(name = "LoanTime")
	private int loanTime; // 贷款期限
	
	@Column(name = "ContractDate")
	private Date contractDate; // 合同日期

	@Column(name = "SignMan")
	private String signMan; // 确认人姓名
	
	@Column(name = "SignManID")
	private int signManID; // 确认人ID
	
	@Column(name = "Status")
	private int status; // 合同状态 0：未签订，1：已申请，2：已复核，3：已审核，4：已打印，5：已作废，6：确认签订
	
	@Column(name = "CheckDate")
	private Date checkDate; // 复核日期
	
	@Column(name = "CheckMan")
	private String checkMan; // 复核人姓名
	
	@Column(name = "CheckManID")
	private int checkManID; // 复核人ID
	
	@Column(name = "ConfirmMan")
	private String confirmMan; // 审核人姓名
	
	@Column(name = "ConfirmManID")
	private int confirmManID; // 审核人ID
	
	@Column(name = "ConfirmDate")
	private Date confirmDate; // 审核日期
	
	@Column(name = "PrintMan")
	private String printMan; // 打印人姓名
	
	@Column(name = "PrintManID")
	private int printManID; // 打印人ID
	
	@Column(name = "PrintDate")
	private Date printDate; // 打印日期
	
	@Column(name = "ChksignDate")
	private Date chksignDate; // 确认签订日期
	
	@Column(name = "ChksignMan")
	private String chksignMan; // 确认签订人姓名
	
	@Column(name = "ChksignManID")
	private int chksignManID; // 确认签订人ID
	
	@Column(name = "BankName")
	private String bankName; // 银行名称
	
	@Column(name = "BankAccount")
	private String bankAccount; // 银行帐号
	
	@Column(name = "BankMan")
	private String bankMan; // 银行帐号归属人
	
	@Column(name = "Interest")
	private BigDecimal interest; // 贷款利息   贷款金额(amt) x 贷款利率(rate) 
	
	@Column(name = "StartInterestDate")
	private Date startInterestDate;    // 起息时间

	public Date getStartInterestDate() {
		return startInterestDate;
	}

	public void setStartInterestDate(Date startInterestDate) {
		this.startInterestDate = startInterestDate;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

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

	public Long getContractID() {
		return contractID;
	}

	public void setContractID(Long contractID) {
		this.contractID = contractID;
	}

	public Long getApplyID() {
		return applyID;
	}

	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public BigDecimal getManageFeeRate() {
		return manageFeeRate;
	}

	public void setManageFeeRate(BigDecimal manageFeeRate) {
		this.manageFeeRate = manageFeeRate;
	}

	public BigDecimal getManageFees() {
		return manageFees;
	}

	public void setManageFees(BigDecimal manageFees) {
		this.manageFees = manageFees;
	}

	public BigDecimal getDelayFeeRate() {
		return delayFeeRate;
	}

	public void setDelayFeeRate(BigDecimal delayFeeRate) {
		this.delayFeeRate = delayFeeRate;
	}

	public BigDecimal getDelayCostRate() {
		return delayCostRate;
	}

	public void setDelayCostRate(BigDecimal delayCostRate) {
		this.delayCostRate = delayCostRate;
	}

	public BigDecimal getDelayInterestRate() {
		return delayInterestRate;
	}

	public void setDelayInterestRate(BigDecimal delayInterestRate) {
		this.delayInterestRate = delayInterestRate;
	}

	public int getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(int loanStatus) {
		this.loanStatus = loanStatus;
	}

	public int getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(int returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public int getCreateByID() {
		return createByID;
	}

	public void setCreateByID(int createByID) {
		this.createByID = createByID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public int getModifyByID() {
		return modifyByID;
	}

	public void setModifyByID(int modifyByID) {
		this.modifyByID = modifyByID;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public int getLoanTime() {
		return loanTime;
	}

	public void setLoanTime(int loanTime) {
		this.loanTime = loanTime;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public String getSignMan() {
		return signMan;
	}

	public void setSignMan(String signMan) {
		this.signMan = signMan;
	}

	public int getSignManID() {
		return signManID;
	}

	public void setSignManID(int signManID) {
		this.signManID = signManID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public int getCheckManID() {
		return checkManID;
	}

	public void setCheckManID(int checkManID) {
		this.checkManID = checkManID;
	}

	public String getConfirmMan() {
		return confirmMan;
	}

	public void setConfirmMan(String confirmMan) {
		this.confirmMan = confirmMan;
	}

	public int getConfirmManID() {
		return confirmManID;
	}

	public void setConfirmManID(int confirmManID) {
		this.confirmManID = confirmManID;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getPrintMan() {
		return printMan;
	}

	public void setPrintMan(String printMan) {
		this.printMan = printMan;
	}

	public int getPrintManID() {
		return printManID;
	}

	public void setPrintManID(int printManID) {
		this.printManID = printManID;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public Date getChksignDate() {
		return chksignDate;
	}

	public void setChksignDate(Date chksignDate) {
		this.chksignDate = chksignDate;
	}

	public String getChksignMan() {
		return chksignMan;
	}

	public void setChksignMan(String chksignMan) {
		this.chksignMan = chksignMan;
	}

	public int getChksignManID() {
		return chksignManID;
	}

	public void setChksignManID(int chksignManID) {
		this.chksignManID = chksignManID;
	}
}