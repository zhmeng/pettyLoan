package com.hl.loan.pojo;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "ApplyInfo")
public class ApplyInfo implements Serializable {

	/**
	 * 贷款申请表
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ApplyID")
	private Long applyID; // ID

	@Column(name = "ApplyCode")
	private String applyCode; // 贷款申请编号

	@Column(name = "PID")
	private Integer pID; // 对应产品编号

	@Column(name = "Amount")
	private BigDecimal amount; // 申请额度（万元）

	@Column(name = "BigAmount")
	private String bigAmount; // 申请额度（万元）大写

	@Column(name = "loanTime")
	private Integer loanTime; // 贷款期限，贷款总月数

	@Column(name = "UID")
	private Integer uID; // 外键(员工表)，客户经理

	@Column(name = "UName")
	private String uName; // 客户经理名称

	@Column(name = "Status")
	private Integer status; // '贷款状态 贷款状态 1;客户资料维护中;201;贷款审批1;202
							// ;贷款审批2;203;贷款审批3;301;合同申请；302;合同签订；303；合同复核;401；确认收款；402;待放款;
							// 5;正常还款;6;逾期;7;结清;8;申请被拒绝;9;申请被回退;10;放款未成功(贷款作废);11;客户取消;12;预留;13;合同作废;14;业务中止;15；财务确认
	@Column(name = "ApplyDate")
	private String applyDate; // 申请日期

	@Column(name = "ProjectID")
	private Integer projectID; // 项目ID

	@Column(name = "ProjectName")
	private String projectName; // 项目名称

	@Column(name = "Rate")
	private BigDecimal rate; // 贷款利率（财务顾问利率）

	@Column(name = "FeeRate")
	private BigDecimal feeRate; // 手续费率

	@Column(name = "IsFirstHouse")
	private Integer isFirstHouse; // 是否是首套房 1：是，2：否

	@Column(name = "HouseAdress")
	private String houseAdress; // 所购房产地址

	@Column(name = "FirstPayPercent")
	private Integer firstPayPercent; // 首付成数(%)

	@Column(name = "HousePrice")
	private BigDecimal housePrice; // 房屋总价

	@Column(name = "HouseArea")
	private Double houseArea; // 房屋面积

	@Column(name = "MetersPrice")
	private BigDecimal metersPrice; // 多少钱一平米

	@Column(name = "ModifyUID")
	private Integer modifyUID; // 修改人ID，员工表

	@Column(name = "ModifyUName")
	private String modifyUName; // 修改人姓名

	@Column(name = "ModifyDate")
	private Date modifyDate; // 修改日期

	@Column(name = "CreateUID")
	private Integer createUID; // 创建人ID

	@Column(name = "CreateUName")
	private String createUName; // 创建人姓名

	@Column(name = "CreateDate")
	private Date createDate; // 创建时间

	@Column(name = "DelayCostRate")
	private BigDecimal delayCostRate; // 逾期本金扣罚费率

	@Column(name = "DelayInterestRate")
	private BigDecimal delayInterestRate; // 逾期利息扣罚费率
	
	@Column(name = "sendDate")
	private Date sendDate; // 发放时间
	
	private String applyDateStart;
	
	private String applyDateEnd;
	
    @Transient
	public String getApplyDateStart() {
		return applyDateStart;
	}

	public void setApplyDateStart(String applyDateStart) {
		this.applyDateStart = applyDateStart;
	}
	@Transient
	public String getApplyDateEnd() {
		return applyDateEnd;
	}

	public void setApplyDateEnd(String applyDateEnd) {
		this.applyDateEnd = applyDateEnd;
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

	// ---------------------------------- Formula
	// ----------------------------------
	@Formula("(select c.status from Contract c where c.applyID = applyID)")
	private String contractStatus;

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	@Formula("(select c.contractName from Contract c where c.applyID = applyID)")
	private String contractName;

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	// ---------------------------------- Formula
	// ----------------------------------

	@Column(name = "firstUserId")
	private Integer firstUserId;

	@Column(name = "CompanyID")
	private Long CompanyID;

	@Column(name = "CityID")
	private Long CityID;

	@Column(name = "LpID")
	private Long LpID;

	@Column(name = "ProductID")
	private Long ProductID;

	@Column(name="rooms")
	private Integer rooms;                           //几房
	
	@Column(name="hall")
	private Integer hall;							//几厅
	
	@Column(name="toilet")
	private Integer toilet;							//卫生间
	
	@Column(name="balcony")
	private Integer balcony;							//阳台
	
	@Column(name="aspect")
	private String aspect;							//朝向
	
	@Column(name="roomNumber")
	private String roomNumber;						//房号
	
	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public Integer getHall() {
		return hall;
	}

	public void setHall(Integer hall) {
		this.hall = hall;
	}

	public Integer getToilet() {
		return toilet;
	}

	public void setToilet(Integer toilet) {
		this.toilet = toilet;
	}

	public Integer getBalcony() {
		return balcony;
	}

	public void setBalcony(Integer balcony) {
		this.balcony = balcony;
	}

	public String getAspect() {
		return aspect;
	}

	public void setAspect(String aspect) {
		this.aspect = aspect;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Long getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(Long companyID) {
		CompanyID = companyID;
	}

	public Long getCityID() {
		return CityID;
	}

	public void setCityID(Long cityID) {
		CityID = cityID;
	}

	public Long getLpID() {
		return LpID;
	}

	public void setLpID(Long lpID) {
		LpID = lpID;
	}

	public Long getProductID() {
		return ProductID;
	}

	public void setProductID(Long productID) {
		ProductID = productID;
	}

	public Long getApplyID() {
		return applyID;
	}

	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}

	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public Integer getpID() {
		return pID;
	}

	public void setpID(Integer pID) {
		this.pID = pID;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getLoanTime() {
		return loanTime;
	}

	public void setLoanTime(Integer loanTime) {
		this.loanTime = loanTime;
	}

	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public Integer getProjectID() {
		return projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public Integer getIsFirstHouse() {
		return isFirstHouse;
	}

	public void setIsFirstHouse(Integer isFirstHouse) {
		this.isFirstHouse = isFirstHouse;
	}

	public String getHouseAdress() {
		return houseAdress;
	}

	public void setHouseAdress(String houseAdress) {
		this.houseAdress = houseAdress;
	}

	public Integer getFirstPayPercent() {
		return firstPayPercent;
	}

	public void setFirstPayPercent(Integer firstPayPercent) {
		this.firstPayPercent = firstPayPercent;
	}

	public BigDecimal getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(BigDecimal housePrice) {
		this.housePrice = housePrice;
	}

	public Double getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(Double houseArea) {
		this.houseArea = houseArea;
	}

	public BigDecimal getMetersPrice() {
		return metersPrice;
	}

	public void setMetersPrice(BigDecimal metersPrice) {
		this.metersPrice = metersPrice;
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

	public String getBigAmount() {
		return bigAmount;
	}

	public void setBigAmount(String bigAmount) {
		this.bigAmount = bigAmount;
	}

	public Integer getFirstUserId() {
		return firstUserId;
	}

	public void setFirstUserId(Integer firstUserId) {
		this.firstUserId = firstUserId;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
}