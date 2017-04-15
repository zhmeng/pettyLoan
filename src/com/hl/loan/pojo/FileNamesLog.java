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
@Table(name = "fileNamesLog")
public class FileNamesLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "zipCode")
	private String zipCode;

	@Column(name = "address")
	private String address;

	@Column(name = "compnyName")
	private String compnyName;

	@Column(name = "department")
	private String department;

	@Column(name = "linkmn")
	private String linkmn;

	@Column(name = "sex")
	private String sex;

	@Column(name = "post")
	private String post;

	@Column(name = "officePhone")
	private String officePhone;

	@Column(name = "phone")
	private String phone;

	@Column(name = "qq")
	private String qq;

	@Column(name = "email")
	private String email;

	@Column(name = "fimallyPhone")
	private String fimallyPhone;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "remark")
	private String remark;

	@Column(name = "url")
	private String url;

	@Column(name = "fbak1")
	private String fbak1;

	@Column(name = "fbak2")
	private String fbak2;

	@Column(name = "pid")
	private Long pid;

	@Column(name = "fmonily")
	private Integer fmonily;

	@Column(name = "fstate")
	private Integer fstate;

	@Column(name = "fileId")
	private Long fileId;

	@Column(name = "compClass")
	private String compClass;

	@Column(name = "addTime")
	private Date addTime;

	@Column(name = "changeTime")
	private Date changeTime;

	@Column(name = "userId")
	private Integer userId;

	@Column(name = "operId")
	private Integer operId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompnyName() {
		return this.compnyName;
	}

	public void setCompnyName(String compnyName) {
		this.compnyName = compnyName;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLinkmn() {
		return this.linkmn;
	}

	public void setLinkmn(String linkmn) {
		this.linkmn = linkmn;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFimallyPhone() {
		return this.fimallyPhone;
	}

	public void setFimallyPhone(String fimallyPhone) {
		this.fimallyPhone = fimallyPhone;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFbak1() {
		return this.fbak1;
	}

	public void setFbak1(String fbak1) {
		this.fbak1 = fbak1;
	}

	public String getFbak2() {
		return this.fbak2;
	}

	public void setFbak2(String fbak2) {
		this.fbak2 = fbak2;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Integer getFmonily() {
		return this.fmonily;
	}

	public void setFmonily(Integer fmonily) {
		this.fmonily = fmonily;
	}

	public Integer getFstate() {
		return this.fstate;
	}

	public void setFstate(Integer fstate) {
		this.fstate = fstate;
	}

	public Long getFileId() {
		return this.fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getCompClass() {
		return this.compClass;
	}

	public void setCompClass(String compClass) {
		this.compClass = compClass;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOperId() {
		return this.operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}
}