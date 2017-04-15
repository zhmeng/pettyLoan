package com.hl.loan.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 联系人实体
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ContactID")
	private Long contactID; // ID

	@Column(name = "ContactName")
	private String contactName; // 联系人姓名

	@Column(name = "ContactPost")
	private String contactPost; // 联系人职务
	
	@Column(name = "ContactTel")
	private String contactTel; // 联系人电话
	
	@Column(name = "ContactEmail")
	private String contactEmail; // 联系人电子邮箱
	
	@Column(name = "ContactRemark")
	private String contactRemark; // 备注
	
	@Column(name = "CreateById")
	private Long createById; // 创建人
	
	@Column(name = "UpdateById")
	private Long updateById; // 修改人
	
	@Column(name = "CreateTime")
	private Date createTime; // 创建时间
	
	@Column(name = "UpdateTime")
	private Date updateTime; // 修改时间

	public Long getContactID() {
		return contactID;
	}

	public void setContactID(Long contactID) {
		this.contactID = contactID;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPost() {
		return contactPost;
	}

	public void setContactPost(String contactPost) {
		this.contactPost = contactPost;
	}

	public String getContactTel() {
		return contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactRemark() {
		return contactRemark;
	}

	public void setContactRemark(String contactRemark) {
		this.contactRemark = contactRemark;
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
