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
@Table(name = "ImgInfo")
public class ImgInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 图片
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long ID;

	@Column(name = "ImgName")
	private String imgName;

	@Column(name = "ImgUrl")
	private String imgUrl;

	@Column(name = "Time")
	private Date time;

	@Column(name = "State")
	private int state;

	@Column(name = "ApplyID")
	private Long applyID;

	@Column(name = "ImgChinaName")
	private String imgChinaName;
	
	@Column(name = "Type")
	private int type;    // 1：贷款文件，2：合同文件
	
	@Column(name = "ProductID")
	private Long productID; 

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImgChinaName() {
		return imgChinaName;
	}

	public void setImgChinaName(String imgChinaName) {
		this.imgChinaName = imgChinaName;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Long getApplyID() {
		return applyID;
	}

	public void setApplyID(Long applyID) {
		this.applyID = applyID;
	}
}