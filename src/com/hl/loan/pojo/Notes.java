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
@Table(name = "notes")
public class Notes implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 流程记录实体
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NID")
	private Long nID; // ID

	@Column(name = "ApplyID")
	private Long applyID; // 贷款申请ID

	@Column(name = "UserID")
	private Integer userID; // 审核人ID
	
	@Column(name = "UserName")
	private String userName; // 审核人姓名
	
	@Column(name = "Status")
	private Integer status; // 当前状态

	@Column(name = "View")
	private String view; // 处理意见
	
	@Column(name = "NoteTime")
	private Date noteTime; // 处理时间
	
	@Column(name = "Examines")
	private Integer examines; // 1：同意 ，2：退回，3：拒绝 
	
	@Column(name = "NoteClass")
	private Integer noteClass; // 流程类型

	public Long getnID() {
		return nID;
	}

	public void setnID(Long nID) {
		this.nID = nID;
	}

	public Long getApplyID() {
		return applyID;
	}

	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public Date getNoteTime() {
		return noteTime;
	}

	public void setNoteTime(Date noteTime) {
		this.noteTime = noteTime;
	}

	public Integer getExamines() {
		return examines;
	}

	public void setExamines(Integer examines) {
		this.examines = examines;
	}

	public Integer getNoteClass() {
		return noteClass;
	}

	public void setNoteClass(Integer noteClass) {
		this.noteClass = noteClass;
	}
}