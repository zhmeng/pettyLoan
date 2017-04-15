package com.hl.loan.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "excel")
public class Excel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "down_time")
	private String downTime;

	@Column(name = "file_id")
	private Long fileId;
	@Column(name="status")
	private Integer status;
	@Column(name="remark")
	private String remark;
	@Column(name="clss")
	private Integer clss;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDownTime() {
		return this.downTime;
	}

	public void setDownTime(String downTime) {
		this.downTime = downTime;
	}

	public Long getFileId() {
		return this.fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Integer getClss() {
		return clss;
	}

	public void setClss(Integer clss) {
		this.clss = clss;
	}
}