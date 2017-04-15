package com.hl.loan.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SysDept")
public class SysDept implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 部门实体
	 */
	@Id
	@Column(name="DeptID")
	private String deptID;          // ID
	
	@Column(name="DeptName")
	private String deptName;        // 部门名称
	
	@Column(name="DeptMG")
	private Integer deptMG;         // 用户表，部门负责人
	
	@Column(name="DeptDesc")
	private String deptDesc;        // 部门描述
	
	@Column(name="DeptFlag")
	private Integer deptFlag;      // 分公司标志，1公司级标志 用于数据权限为100＝4或1000＝8时，所要上推的部门
	
	@Column(name="DeptMGTel")
	private String deptMGTel;      // 部门负责人电话
	
	@Column(name="DeptIsBR")
	private Integer deptIsBR;      // 是否网点
	
	@Column(name="DeptBranchID")
	private Integer deptBranchID;  // 所属网点
	
	@Column(name="DeptIsCR")
	private Integer deptIsCR;      // 是否信审部
	
	@Column(name="DeptIsCS")
	private Integer deptIsCS;      // 是否客服
	
	@Column(name="DeptNo")
	private String deptNo;         // 原系统组织机构编号
	
	@Column(name="DeptTel")
	private String deptTel;        // 办公电话
	
	@Column(name="DeptFax")
	private String deptFax;        // 传真
	
	@Column(name="DeptAddr")
	private String deptAddr;       // 办公地址
	
	@Column(name="DeptPost")
	private String deptPost;       // 邮编
	
	@Column(name="DeptState")
	private Integer deptState;     // 部门标志，0：有效，1：无效，2：历史用过 过期，3：删除
	
	@Column(name="DeptFlagList")
	private String deptFlagList;   // 部门性质标志，0：否，1：是  第一位代表是否审核组
	
	@Column(name="DeptByCity")
	private String deptByCity;     // 基础数据 SZ：深圳，FS：佛山，CQ：重庆

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeptMG() {
		return deptMG;
	}

	public void setDeptMG(Integer deptMG) {
		this.deptMG = deptMG;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public Integer getDeptFlag() {
		return deptFlag;
	}

	public void setDeptFlag(Integer deptFlag) {
		this.deptFlag = deptFlag;
	}

	public String getDeptMGTel() {
		return deptMGTel;
	}

	public void setDeptMGTel(String deptMGTel) {
		this.deptMGTel = deptMGTel;
	}

	public Integer getDeptIsBR() {
		return deptIsBR;
	}

	public void setDeptIsBR(Integer deptIsBR) {
		this.deptIsBR = deptIsBR;
	}

	public Integer getDeptBranchID() {
		return deptBranchID;
	}

	public void setDeptBranchID(Integer deptBranchID) {
		this.deptBranchID = deptBranchID;
	}

	public Integer getDeptIsCR() {
		return deptIsCR;
	}

	public void setDeptIsCR(Integer deptIsCR) {
		this.deptIsCR = deptIsCR;
	}

	public Integer getDeptIsCS() {
		return deptIsCS;
	}

	public void setDeptIsCS(Integer deptIsCS) {
		this.deptIsCS = deptIsCS;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptTel() {
		return deptTel;
	}

	public void setDeptTel(String deptTel) {
		this.deptTel = deptTel;
	}

	public String getDeptFax() {
		return deptFax;
	}

	public void setDeptFax(String deptFax) {
		this.deptFax = deptFax;
	}

	public String getDeptAddr() {
		return deptAddr;
	}

	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}

	public String getDeptPost() {
		return deptPost;
	}

	public void setDeptPost(String deptPost) {
		this.deptPost = deptPost;
	}

	public Integer getDeptState() {
		return deptState;
	}

	public void setDeptState(Integer deptState) {
		this.deptState = deptState;
	}

	public String getDeptFlagList() {
		return deptFlagList;
	}

	public void setDeptFlagList(String deptFlagList) {
		this.deptFlagList = deptFlagList;
	}

	public String getDeptByCity() {
		return deptByCity;
	}

	public void setDeptByCity(String deptByCity) {
		this.deptByCity = deptByCity;
	}
}