package com.hl.loan.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="SysRights")

public class SysRights implements Serializable{
	/**
	 * 菜单权限
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RightsID")
	private Integer rightsID;
	@Column(name="RightsRoleID")
	private Integer rightsRoleID;
	@Column(name="RightsRoleOrUser")
	private Integer rightsRoleOrUser;
	@Column(name="RightsUserID")
	private Integer rightsUserID;
	@Column(name="RightsModID")
	private String rightsModID;
	@Column(name="RightsModCtrl")
	private Integer rightsModCtrl;
	@Column(name="RightsModData")
	private Integer rightsModData;
	@Column(name="IsRight")
	private Integer isRight;
	public Integer getRightsID() {
		return rightsID;
	}
	public void setRightsID(Integer rightsID) {
		this.rightsID = rightsID;
	}
	public Integer getRightsRoleID() {
		return rightsRoleID;
	}
	public void setRightsRoleID(Integer rightsRoleID) {
		this.rightsRoleID = rightsRoleID;
	}
	public Integer getRightsRoleOrUser() {
		return rightsRoleOrUser;
	}
	public void setRightsRoleOrUser(Integer rightsRoleOrUser) {
		this.rightsRoleOrUser = rightsRoleOrUser;
	}
	public Integer getRightsUserID() {
		return rightsUserID;
	}
	public void setRightsUserID(Integer rightsUserID) {
		this.rightsUserID = rightsUserID;
	}
	public String getRightsModID() {
		return rightsModID;
	}
	public void setRightsModID(String rightsModID) {
		this.rightsModID = rightsModID;
	}
	public Integer getRightsModCtrl() {
		return rightsModCtrl;
	}
	public void setRightsModCtrl(Integer rightsModCtrl) {
		this.rightsModCtrl = rightsModCtrl;
	}
	public Integer getRightsModData() {
		return rightsModData;
	}
	public void setRightsModData(Integer rightsModData) {
		this.rightsModData = rightsModData;
	}
	public Integer getIsRight() {
		return isRight;
	}
	public void setIsRight(Integer isRight) {
		this.isRight = isRight;
	}
	
}
