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
@Table(name="APPLYCustInfo")
public class APPLYCustInfo implements Serializable{

	/**
	 * 贷款申请人基本信息表
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="ApplyID")
	private Long applyID;			//贷款申请编号
	@Column(name="CustName")
	private String custName;			//姓名		
	@Column(name="Gender")
	private String gender;				//性别
	@Column(name="Marry")
	private String marry;			//婚姻状况
	@Column(name="DocNo")
	private String docNo;				//身份证号码
	@Column(name="SonCount")
	private Integer sonCount;			//子女数
	@Column(name="Birthday")
	private Date birthday;				//出生日期
	@Column(name="Household")
	private String household;				//户籍地址
	@Column(name="Education")
	private String education;				//教育程度
	@Column(name="Mobile")
	private String mobile;					//移动电话
	@Column(name="Telephone")
	private String telephone;				//电话
	@Column(name="LiveStatus")
	private Integer liveStatus;			//居住状况		1：按揭中，2：非按揭，3：租赁，4：其他
	@Column(name="LeaseMoney")
	private Double leaseMoney;			//租赁金额（元）		如果“LiveStatus”为“3” 保存相应租赁金额
	@Column(name="OtherContact")
	private String otherContact;			//其他联系方式
	@Column(name="WokTime")
	private Date wokTime;						//当地工作时间
	@Column(name="Address")
	private String address;						//现居住地址	1住宅2单位 基础数据
	@Column(name="ZXInsider")
	private String zxInsider;				//直系人姓名
	@Column(name="ZXRelation")
	private String zxRelation;				//直系人关系
	@Column(name="ZXMobile")
	private String zxMobile;				//直系人手机
	@Column(name="ZXTel")
	private String zxTel;						//直系人固话	
	@Column(name="ZXCompany")
	private String zxCompany;				//直系人公司
	@Column(name="ZXAdress")
	private String zxAdress;					//直系人住址
	@Column(name="ZXKonw")
	private Integer zxKonw;					//是否知道		1：是，2:否
	@Column(name="QSName")
	private String qsName;					//亲属姓名
	@Column(name="QSMobile")
	private String qsMobile;				//亲属手机
	@Column(name="QSCorp")
	private String qsCorp;					//亲属单位名称
	@Column(name="QSAddr")
	private String qsAddr;					//亲属住址	
	@Column(name="QSCorpTel")
	private String qsCorpTel;				//亲属单位电话
	@Column(name="QSKonw")
	private Integer qsKonw;				//亲属是否知道		1：是，2:否
	@Column(name="TSName")
	private String tsName;				//同事姓名
	@Column(name="TSMobile")
	private String tsMobile;				//同事手机
	@Column(name="TSPosition")
	private String tsPosition;				//同事职务
	@Column(name="TSAddr")
	private String tsAddr;					//同事住址
	@Column(name="TSTel")
	private String tsTel;					//同事固定电话
	@Column(name="TSKonw")
	private Integer tsKonw;					//同事是否知道	1：是，2:否
	@Column(name="OtherName")
	private String otherName;				//其他联系人姓名	
	@Column(name="OtherRelation")
	private String otherRelation;			//其他联系人关系
	@Column(name="OtherMobile")
	private String otherMobile;				//其他联系人手机
	@Column(name="OtherKonw")
	private Integer otherKonw;				//其他联系人是否知道	1：是，2:否	
	@Column(name="OtherAddr")
	private String otherAddr;				//其他联系人住址	
	@Column(name="OtherTel")
	private String otherTel;				//其他联系人固定电话
	@Column(name="OtherCompany")
	private String otherCompany;			//其他联系人公司
	@Column(name="ModifyUID")
	private Integer modifyUID;				//修改人ID		员工表
	@Column(name="ModifyUName")
	private String modifyUName;				//修改人姓名
	@Column(name="ModifyDate")
	private Date modifyDate;				//修改日期
	@Column(name="CreateUID")
	private Integer createUID;					//创建人ID	
	@Column(name="CreateUName")
	private String createUName;					//创建人姓名
	@Column(name="CreateDate")
	private Date createDate;					//创建人时间

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getApplyID() {
		return applyID;
	}
	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarry() {
		return marry;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Integer getSonCount() {
		return sonCount;
	}
	public void setSonCount(Integer sonCount) {
		this.sonCount = sonCount;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHousehold() {
		return household;
	}
	public void setHousehold(String household) {
		this.household = household;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getLiveStatus() {
		return liveStatus;
	}
	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}
	public Double getLeaseMoney() {
		return leaseMoney;
	}
	public void setLeaseMoney(Double leaseMoney) {
		this.leaseMoney = leaseMoney;
	}
	public String getOtherContact() {
		return otherContact;
	}
	public void setOtherContact(String otherContact) {
		this.otherContact = otherContact;
	}
	public Date getWokTime() {
		return wokTime;
	}
	public void setWokTime(Date wokTime) {
		this.wokTime = wokTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZxInsider() {
		return zxInsider;
	}
	public void setZxInsider(String zxInsider) {
		this.zxInsider = zxInsider;
	}
	public String getZxRelation() {
		return zxRelation;
	}
	public void setZxRelation(String zxRelation) {
		this.zxRelation = zxRelation;
	}
	public String getZxMobile() {
		return zxMobile;
	}
	public void setZxMobile(String zxMobile) {
		this.zxMobile = zxMobile;
	}
	public String getZxTel() {
		return zxTel;
	}
	public void setZxTel(String zxTel) {
		this.zxTel = zxTel;
	}
	public String getZxCompany() {
		return zxCompany;
	}
	public void setZxCompany(String zxCompany) {
		this.zxCompany = zxCompany;
	}
	public String getZxAdress() {
		return zxAdress;
	}
	public void setZxAdress(String zxAdress) {
		this.zxAdress = zxAdress;
	}
	public Integer getZxKonw() {
		return zxKonw;
	}
	public void setZxKonw(Integer zxKonw) {
		this.zxKonw = zxKonw;
	}
	public String getQsName() {
		return qsName;
	}
	public void setQsName(String qsName) {
		this.qsName = qsName;
	}
	public String getQsMobile() {
		return qsMobile;
	}
	public void setQsMobile(String qsMobile) {
		this.qsMobile = qsMobile;
	}
	public String getQsCorp() {
		return qsCorp;
	}
	public void setQsCorp(String qsCorp) {
		this.qsCorp = qsCorp;
	}
	public String getQsAddr() {
		return qsAddr;
	}
	public void setQsAddr(String qsAddr) {
		this.qsAddr = qsAddr;
	}
	public String getQsCorpTel() {
		return qsCorpTel;
	}
	public void setQsCorpTel(String qsCorpTel) {
		this.qsCorpTel = qsCorpTel;
	}
	public Integer getQsKonw() {
		return qsKonw;
	}
	public void setQsKonw(Integer qsKonw) {
		this.qsKonw = qsKonw;
	}
	public String getTsName() {
		return tsName;
	}
	public void setTsName(String tsName) {
		this.tsName = tsName;
	}
	public String getTsMobile() {
		return tsMobile;
	}
	public void setTsMobile(String tsMobile) {
		this.tsMobile = tsMobile;
	}
	public String getTsPosition() {
		return tsPosition;
	}
	public void setTsPosition(String tsPosition) {
		this.tsPosition = tsPosition;
	}
	public String getTsAddr() {
		return tsAddr;
	}
	public void setTsAddr(String tsAddr) {
		this.tsAddr = tsAddr;
	}
	public String getTsTel() {
		return tsTel;
	}
	public void setTsTel(String tsTel) {
		this.tsTel = tsTel;
	}
	public Integer getTsKonw() {
		return tsKonw;
	}
	public void setTsKonw(Integer tsKonw) {
		this.tsKonw = tsKonw;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getOtherRelation() {
		return otherRelation;
	}
	public void setOtherRelation(String otherRelation) {
		this.otherRelation = otherRelation;
	}
	public String getOtherMobile() {
		return otherMobile;
	}
	public void setOtherMobile(String otherMobile) {
		this.otherMobile = otherMobile;
	}
	public Integer getOtherKonw() {
		return otherKonw;
	}
	public void setOtherKonw(Integer otherKonw) {
		this.otherKonw = otherKonw;
	}
	public String getOtherAddr() {
		return otherAddr;
	}
	public void setOtherAddr(String otherAddr) {
		this.otherAddr = otherAddr;
	}
	public String getOtherTel() {
		return otherTel;
	}
	public void setOtherTel(String otherTel) {
		this.otherTel = otherTel;
	}
	public String getOtherCompany() {
		return otherCompany;
	}
	public void setOtherCompany(String otherCompany) {
		this.otherCompany = otherCompany;
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












