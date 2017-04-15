package com.hl.loan.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noteAndUser")
public class NoteAndUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "status")
	private Integer status; // 审核状态
	
	@Column(name = "userId")
	private Integer userId; // 用户ID
	
	@Column(name = "userName")
	private String userName; // 用户名
	
	@Column(name = "statusName")
	private String statusName; // 审核名称
	
	@Column(name = "noteClass")
	private Integer noteClass; // 类型

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getNoteClass() {
		return noteClass;
	}

	public void setNoteClass(Integer noteClass) {
		this.noteClass = noteClass;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}