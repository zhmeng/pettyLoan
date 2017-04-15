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
@Table(name = "PrintRecord")
public class PrintRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 打印记录实体
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id; // ID

	@Column(name = "PrintNo")
	private String printNo;       // 打印编号

	@Column(name = "UserID")
	private Integer userID;       // 打印人
	
	@Column(name = "PrintDate")
	private Date printDate;       // 打印时间
	
	@Column(name = "ContractNo")
	private String contractNo;    // 合同编号

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrintNo() {
		return printNo;
	}

	public void setPrintNo(String printNo) {
		this.printNo = printNo;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
}