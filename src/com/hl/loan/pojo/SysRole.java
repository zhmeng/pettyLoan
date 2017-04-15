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
@Table(name="SysRole")

public class SysRole implements Serializable{

	/**
	 * 角色
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoleId")
	private Integer roleId;
	
	@Column(name="RoleName")
	private String roleName;
	
	@Column(name="RoleState")
	private Integer roleState;
	
	@Column(name="RoleAddTime")
	private Date roleAddTime;
	
	@Column(name="RoleAddByUser")
	private Integer roleAddByUser;
	
	@Column(name="RoleDelTime")
	private Date roleDelTime;
	
	@Column(name="RoleDelByUser")
	private Integer roleDelByUser;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleState() {
		return roleState;
	}

	public void setRoleState(Integer roleState) {
		this.roleState = roleState;
	}

	public Date getRoleAddTime() {
		return roleAddTime;
	}

	public void setRoleAddTime(Date roleAddTime) {
		this.roleAddTime = roleAddTime;
	}

	public Integer getRoleAddByUser() {
		return roleAddByUser;
	}

	public void setRoleAddByUser(Integer roleAddByUser) {
		this.roleAddByUser = roleAddByUser;
	}

	public Date getRoleDelTime() {
		return roleDelTime;
	}

	public void setRoleDelTime(Date roleDelTime) {
		this.roleDelTime = roleDelTime;
	}

	public Integer getRoleDelByUser() {
		return roleDelByUser;
	}

	public void setRoleDelByUser(Integer roleDelByUser) {
		this.roleDelByUser = roleDelByUser;
	}
	
}











