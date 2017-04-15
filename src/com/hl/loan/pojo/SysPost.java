package com.hl.loan.pojo;

import java.io.Serializable;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="SysPost")


public class SysPost implements Serializable{

	/**
	 * 公司职位
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PostID")
	private Integer postID;
	@Column(name="PostName")
	private String postName;
	@Column(name="PostIsDept")
	private String postIsDept;
	@Column(name="istrue")
	private Integer istrue;
	public Integer getPostID() {
		return postID;
	}
	public void setPostID(Integer postID) {
		this.postID = postID;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostIsDept() {
		return postIsDept;
	}
	public void setPostIsDept(String postIsDept) {
		this.postIsDept = postIsDept;
	}
	public Integer getIstrue() {
		return istrue;
	}
	public void setIstrue(Integer istrue) {
		this.istrue = istrue;
	}
	
}












