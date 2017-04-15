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
@Table(name="CustomerCompany")
public class CustomerCompany implements Serializable{

	/**
	 * 申请人公司信息
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="CustID")
	private Long custID;   //贷款申请人ID	 外键	APPLYCustInfo
	
	@Column(name="CusName")
	private String cusName;				//公司名称
	
	@Column(name="CompanyCreateDate")
	private Date companyCreateDate;    				//公司成立日期	
	
	@Column(name="Dept")
	private String dept;					//部门
	
	@Column(name="Position")
	private String position;						//职位
	
	@Column(name="ComBusiness")
	private String comBusiness;					//公司业务
	
	@Column(name="ComAttribute")
	private Integer comAttribute;					//公司业务		1：国有企业，2：三资企业，3：集体企业，4：私营企业，5：其他	
	
	@Column(name="ComAdress")
	private String comAdress;					//公司地址
	
	@Column(name="ComTel")
	private String comTel;					//公司电话

	@Column(name="ComSize")
	private String comSize ;				//公司规模	
	
	@Column(name="ComClass")
	private String comClass;				//行业类型		
	
	@Column(name="ComHouseCategory")
	private Integer comHouseCategory;			//公司场所类别		1：自有，2：租赁
	
	@Column(name="ModifyUID")
	private Integer modifyUID;					//修改人ID 员工表
	
	@Column(name="ModifyUName")
	private String modifyUName;					//修改人姓名
	
	@Column(name="ModifyDate")
	private Date modifyDate;				//修改人日期
	
	@Column(name="CreateUID")
	private Integer createUID;					//创建人ID
	
	@Column(name="CreateUName")
	private String createUName;					//创建人姓名
	
	@Column(name="CreateDate")
	private Date createDate;					//创建时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public Long getCustID() {
		return custID;
	}

	public void setCustID(Long custID) {
		this.custID = custID;
	}

	public Date getCompanyCreateDate() {
		return companyCreateDate;
	}

	public void setCompanyCreateDate(Date companyCreateDate) {
		this.companyCreateDate = companyCreateDate;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getComBusiness() {
		return comBusiness;
	}

	public void setComBusiness(String comBusiness) {
		this.comBusiness = comBusiness;
	}

	public Integer getComAttribute() {
		return comAttribute;
	}

	public void setComAttribute(Integer comAttribute) {
		this.comAttribute = comAttribute;
	}

	public String getComTel() {
		return comTel;
	}

	public void setComTel(String comTel) {
		this.comTel = comTel;
	}

	public String getComSize() {
		return comSize;
	}

	public void setComSize(String comSize) {
		this.comSize = comSize;
	}

	public String getComClass() {
		return comClass;
	}

	public void setComClass(String comClass) {
		this.comClass = comClass;
	}

	public Integer getComHouseCategory() {
		return comHouseCategory;
	}

	public void setComHouseCategory(Integer comHouseCategory) {
		this.comHouseCategory = comHouseCategory;
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

	public String getComAdress() {
		return comAdress;
	}

	public void setComAdress(String comAdress) {
		this.comAdress = comAdress;
	}
	
	
}











