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
@Table(name="CustomerFance")
public class CustomerFance implements Serializable{
	/*
	 * 申请人财务信息
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="CustID")
	private Long custID;      //贷款申请人ID 外键 APPLYCustInfo
	@Column(name="Turnover")
	private BigDecimal turnover;          //年营业额
	@Column(name="OtherIncome")
	private BigDecimal otherIncome;		//其他收入
	@Column(name="Profits")
	private BigDecimal profits;			//净利润
	@Column(name="Liabilities")
	private BigDecimal liabilities;			//负债
	@Column(name="SalaryDay")
	private Date salaryDay;				//发薪日
	@Column(name="Salary")
	private BigDecimal salary;					//月薪
	@Column(name="PersonLiabilities")
	private BigDecimal personLiabilities;		//个人负债
	@Column(name="HouseAdress")
	private String houseAdress;					//房产地址
	@Column(name="BuyDate")
	private Date buyDate;						//购买日期
	@Column(name="BuyPrice")
	private BigDecimal buyPrice;			//购买价格
	@Column(name="BusState")
	private Integer busState;			//购买方式 1一次性2按揭
	@Column(name="AJBank")
	private String ajBank;				//按揭银行
	@Column(name="LoanAMT")
	private BigDecimal loanAMT;				//贷款总额
	@Column(name="PayMonth")
	private BigDecimal payMonth;			//月供金额
	@Column(name="LoanRemaining")
	private BigDecimal loanRemaining;		//贷款余额
	@Column(name="OtherHouse")
	private String otherHouse;				//其它房产总数及价值
	@Column(name="CarNum")
	private String carNum;					//车牌号码
	@Column(name="CarBuyDate")
	private Date carBuyDate;					//购买日期
	@Column(name="CarBuyPrice")					
	private BigDecimal carBuyPrice;				//车购买价格
	@Column(name="CarBusState")
	private Integer carBusState;				//车购买方式
	@Column(name="CarAJBank")
	private String carAJBank;				//车按揭银行
	@Column(name="CarLoanAMT")
	private BigDecimal carLoanAMT;				//车购买总额
	@Column(name="CarPayMonth")
	private BigDecimal carPayMonth;				//车月供
	@Column(name="CarLoanRemaining")
	private BigDecimal carLoanRemaining;			//车贷款余额
	@Column(name="OtherCar")
	private String otherCar;
	@Column(name="IsCard")
	private Integer isCard;					//1.是
	@Column(name="CardCount")
	private Integer cardCount;				//总张数
	@Column(name="CardTotal")
	private BigDecimal cardTotal;			//总额度
	@Column(name="Overdraft")
	private BigDecimal overdraft;				//总透支
	@Column(name="ModifyUID")
	private Integer modifyUID;				//修改人ID 员工表
	@Column(name="ModifyUName")
	private String modifyUName;				//修改人姓名
	@Column(name="ModifyDate")            
	private Date modifyDate;			//修改日期
	@Column(name="CreateUID")
	private Integer createUID;				//创建人Id
	@Column(name="CreateUName")
	private String createUName;				//创建人姓名
	@Column(name="CreateDate")
	private Date createDate;
	//创建时间
	public Long getId() {
		return id;
	}
	
	public BigDecimal getTurnover() {
		return turnover;
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
	public BigDecimal getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(BigDecimal otherIncome) {
		this.otherIncome = otherIncome;
	}
	public BigDecimal getProfits() {
		return profits;
	}
	public void setProfits(BigDecimal profits) {
		this.profits = profits;
	}
	public BigDecimal getLiabilities() {
		return liabilities;
	}
	public void setLiabilities(BigDecimal liabilities) {
		this.liabilities = liabilities;
	}
	
	
	public Date getSalaryDay() {
		return salaryDay;
	}

	public void setSalaryDay(Date salaryDay) {
		this.salaryDay = salaryDay;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public BigDecimal getPersonLiabilities() {
		return personLiabilities;
	}
	public void setPersonLiabilities(BigDecimal personLiabilities) {
		this.personLiabilities = personLiabilities;
	}
	public String getHouseAdress() {
		return houseAdress;
	}
	public void setHouseAdress(String houseAdress) {
		this.houseAdress = houseAdress;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Integer getBusState() {
		return busState;
	}
	public void setBusState(Integer busState) {
		this.busState = busState;
	}
	
	public String getAjBank() {
		return ajBank;
	}

	public void setAjBank(String ajBank) {
		this.ajBank = ajBank;
	}

	public BigDecimal getLoanAMT() {
		return loanAMT;
	}
	public void setLoanAMT(BigDecimal loanAMT) {
		this.loanAMT = loanAMT;
	}
	public BigDecimal getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(BigDecimal payMonth) {
		this.payMonth = payMonth;
	}
	public BigDecimal getLoanRemaining() {
		return loanRemaining;
	}
	public void setLoanRemaining(BigDecimal loanRemaining) {
		this.loanRemaining = loanRemaining;
	}
	public String getOtherHouse() {
		return otherHouse;
	}
	public void setOtherHouse(String otherHouse) {
		this.otherHouse = otherHouse;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public Date getCarBuyDate() {
		return carBuyDate;
	}
	public void setCarBuyDate(Date carBuyDate) {
		this.carBuyDate = carBuyDate;
	}
	public BigDecimal getCarBuyPrice() {
		return carBuyPrice;
	}
	public void setCarBuyPrice(BigDecimal carBuyPrice) {
		this.carBuyPrice = carBuyPrice;
	}
	public Integer getCarBusState() {
		return carBusState;
	}
	public void setCarBusState(Integer carBusState) {
		this.carBusState = carBusState;
	}
	public String getCarAJBank() {
		return carAJBank;
	}
	public void setCarAJBank(String carAJBank) {
		this.carAJBank = carAJBank;
	}
	public BigDecimal getCarLoanAMT() {
		return carLoanAMT;
	}
	public void setCarLoanAMT(BigDecimal carLoanAMT) {
		this.carLoanAMT = carLoanAMT;
	}
	public BigDecimal getCarPayMonth() {
		return carPayMonth;
	}
	public void setCarPayMonth(BigDecimal carPayMonth) {
		this.carPayMonth = carPayMonth;
	}
	public BigDecimal getCarLoanRemaining() {
		return carLoanRemaining;
	}
	public void setCarLoanRemaining(BigDecimal carLoanRemaining) {
		this.carLoanRemaining = carLoanRemaining;
	}
	
	public String getOtherCar() {
		return otherCar;
	}
	public void setOtherCar(String otherCar) {
		this.otherCar = otherCar;
	}
	public Integer getIsCard() {
		return isCard;
	}
	public void setIsCard(Integer isCard) {
		this.isCard = isCard;
	}
	public Integer getCardCount() {
		return cardCount;
	}
	public void setCardCount(Integer cardCount) {
		this.cardCount = cardCount;
	}
	public BigDecimal getCardTotal() {
		return cardTotal;
	}
	public void setCardTotal(BigDecimal cardTotal) {
		this.cardTotal = cardTotal;
	}
	public BigDecimal getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(BigDecimal overdraft) {
		this.overdraft = overdraft;
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




