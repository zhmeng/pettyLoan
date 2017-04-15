package com.hl.loan.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SysModule")
public class SysModule implements Serializable{
	/**
	 * 菜单
	 */

	@Id
	@Column(name="ModID")
	private String modID;
	@Column(name="ModTag")
	private String modTag;
	@Column(name="ModName")
	private String modName;
	@Column(name="ModUrl")
	private String modUrl;
	@Column(name="ModIcon")
	private String modIcon;
	@Column(name="ModFlag")
	private Integer modFlag;
	@Column(name="ModMenuOpen")
	private String modMenuOpen;
	@Column(name="ModMenuView")
	private Integer modMenuView;
	@Column(name="ModTabPage")
	private String modTabPage;
	@Column(name="ModOrder")
	private Integer modOrder;
	@Column(name="ModRightFlag")
	private Integer modRightFlag;
	@Column(name="ModDate")
	private Integer modDate;
	@Column(name="ModLog")
	private Integer modLog;
	@Column(name="ModBtnList")
	private String modBtnList;
	@Column(name="isSecurity")
	private Integer isSecurity;
	@Column(name="pagename")
	private String pagename;
	@Column(name="ModUPRight")
	private String modUPRight;
	@Column(name="BranchField")
	private String branchField;
	@Column(name="ModData")
	private Integer modData;
	@Column(name="PartId")
	private String partId;
	public Integer getModData() {
		return modData;
	}
	public void setModData(Integer modData) {
		this.modData = modData;
	}
	public String getModID() {
		return modID;
	}
	public void setModID(String modID) {
		this.modID = modID;
	}
	public String getModTag() {
		return modTag;
	}
	public void setModTag(String modTag) {
		this.modTag = modTag;
	}
	public String getModName() {
		return modName;
	}
	public void setModName(String modName) {
		this.modName = modName;
	}
	public String getModUrl() {
		return modUrl;
	}
	public void setModUrl(String modUrl) {
		this.modUrl = modUrl;
	}
	public String getModIcon() {
		return modIcon;
	}
	public void setModIcon(String modIcon) {
		this.modIcon = modIcon;
	}
	public Integer getModFlag() {
		return modFlag;
	}
	public void setModFlag(Integer modFlag) {
		this.modFlag = modFlag;
	}
	public String getModMenuOpen() {
		return modMenuOpen;
	}
	public void setModMenuOpen(String modMenuOpen) {
		this.modMenuOpen = modMenuOpen;
	}
	public Integer getModMenuView() {
		return modMenuView;
	}
	public void setModMenuView(Integer modMenuView) {
		this.modMenuView = modMenuView;
	}
	public String getModTabPage() {
		return modTabPage;
	}
	public void setModTabPage(String modTabPage) {
		this.modTabPage = modTabPage;
	}
	public Integer getModOrder() {
		return modOrder;
	}
	public void setModOrder(Integer modOrder) {
		this.modOrder = modOrder;
	}
	public Integer getModRightFlag() {
		return modRightFlag;
	}
	public void setModRightFlag(Integer modRightFlag) {
		this.modRightFlag = modRightFlag;
	}
	public Integer getModDate() {
		return modDate;
	}
	public void setModDate(Integer modDate) {
		this.modDate = modDate;
	}
	public Integer getModLog() {
		return modLog;
	}
	public void setModLog(Integer modLog) {
		this.modLog = modLog;
	}
	public String getModBtnList() {
		return modBtnList;
	}
	public void setModBtnList(String modBtnList) {
		this.modBtnList = modBtnList;
	}
	public Integer getIsSecurity() {
		return isSecurity;
	}
	public void setIsSecurity(Integer isSecurity) {
		this.isSecurity = isSecurity;
	}
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public String getModUPRight() {
		return modUPRight;
	}
	public void setModUPRight(String modUPRight) {
		this.modUPRight = modUPRight;
	}
	public String getBranchField() {
		return branchField;
	}
	public void setBranchField(String branchField) {
		this.branchField = branchField;
	}
	public String getPartId() {
		return partId;
	}
	public void setPartId(String partId) {
		this.partId = partId;
	}
	
}







