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
@Table(name="SYSUSER")
public class SysUser implements Serializable{

	/**
	 * 用户
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UserID")
	private Integer userID;
	@Column(name="UserName")
	private String userName;
	@Column(name="UserPWD")
	private String userPWD;
	@Column(name="UserNO")
	private String userNO;
	@Column(name="UserFullName")
	private String userFullName;
	@Column(name="UserIsDept")
	private String userIsDept;
	@Column(name="UserIsPost")
	private String userIsPost;
	@Column(name="UserisRole")
	private Integer userisRole;
	@Column(name="UserRights")
	private Integer userRights;
	@Column(name="UserWork")
	private Integer userWork;
	@Column(name="UserState")
	private Integer userState;
	@Column(name="UserHomeTel")
	private String userHomeTel;
	@Column(name="UserTel")
	private String userTel;
	@Column(name="UserMob")
	private String userMob;
	@Column(name="UserMail")
	private String userMail;
	@Column(name="UserAddr")
	private String userAddr;
	@Column(name="UserPost")
	private String userPost;
	@Column(name="userQQ")
	private String userQQ;
	
	@Column(name="UserMSN")
	private String userMSN;
	
	@Column(name="UserDesc")
	private String userDesc;
	
	@Column(name="UserLODate")
	private String UserLODate;
	
	@Column(name="UserAODate")
	private String userAODate;
	
	@Column(name="UserSex")
	private String userSex;
	
	@Column(name="UserIDCard")
	private String userIDCard;
	
	@Column(name="UserAddTime")
	private Date userAddTime;
	
	@Column(name="UserAddByUser")
	private Integer userAddByUser;
	
	@Column(name="UserDelTime")
	private Date userDelTime;
	
	@Column(name="UserDelByUser")
	private Integer userDelByUser;
	
	@Column(name="UserLastTime")
	private Date userLastTime;
	
	@Column(name="UserLPWDTime")
	private Date userLPWDTime;

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

	public String getUserPWD() {
		return userPWD;
	}

	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}

	public String getUserNO() {
		return userNO;
	}

	public void setUserNO(String userNO) {
		this.userNO = userNO;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserIsDept() {
		return userIsDept;
	}

	public void setUserIsDept(String userIsDept) {
		this.userIsDept = userIsDept;
	}

	public String getUserIsPost() {
		return userIsPost;
	}

	public void setUserIsPost(String userIsPost) {
		this.userIsPost = userIsPost;
	}

	public Integer getUserisRole() {
		return userisRole;
	}

	public void setUserisRole(Integer userisRole) {
		this.userisRole = userisRole;
	}

	
	public Integer getUserRights() {
		return userRights;
	}

	public void setUserRights(Integer userRights) {
		this.userRights = userRights;
	}

	public Integer getUserWork() {
		return userWork;
	}

	public void setUserWork(Integer userWork) {
		this.userWork = userWork;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public String getUserHomeTel() {
		return userHomeTel;
	}

	public void setUserHomeTel(String userHomeTel) {
		this.userHomeTel = userHomeTel;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserPost() {
		return userPost;
	}

	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	public String getUserQQ() {
		return userQQ;
	}

	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}

	public String getUserMSN() {
		return userMSN;
	}

	public void setUserMSN(String userMSN) {
		this.userMSN = userMSN;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getUserLODate() {
		return UserLODate;
	}

	public void setUserLODate(String userLODate) {
		UserLODate = userLODate;
	}

	public String getUserAODate() {
		return userAODate;
	}

	public void setUserAODate(String userAODate) {
		this.userAODate = userAODate;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserIDCard() {
		return userIDCard;
	}

	public void setUserIDCard(String userIDCard) {
		this.userIDCard = userIDCard;
	}

	public Date getUserAddTime() {
		return userAddTime;
	}

	public void setUserAddTime(Date userAddTime) {
		this.userAddTime = userAddTime;
	}

	public Integer getUserAddByUser() {
		return userAddByUser;
	}

	public void setUserAddByUser(Integer userAddByUser) {
		this.userAddByUser = userAddByUser;
	}

	public Date getUserDelTime() {
		return userDelTime;
	}

	public void setUserDelTime(Date userDelTime) {
		this.userDelTime = userDelTime;
	}

	public Integer getUserDelByUser() {
		return userDelByUser;
	}

	public void setUserDelByUser(Integer userDelByUser) {
		this.userDelByUser = userDelByUser;
	}

	public Date getUserLastTime() {
		return userLastTime;
	}

	public void setUserLastTime(Date userLastTime) {
		this.userLastTime = userLastTime;
	}

	public Date getUserLPWDTime() {
		return userLPWDTime;
	}

	public void setUserLPWDTime(Date userLPWDTime) {
		this.userLPWDTime = userLPWDTime;
	}
	
}












