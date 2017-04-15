package com.hl.loan.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Team")

public class Team implements Serializable{

	/**
	 *  团队
	 */
	@Id
	@Column(name="ID")
	private String ID;
	
	@Column(name="TeamName")
	private String teamName;
	
	@Column(name="TeamState")
	private Integer teamState;
	
	@Column(name="TeamCreateTime")
	
	private String teamCreateTime;
	
	/*@OneToMany
	@JoinColumn(name="user_userid")
	private SysUser sysUser;
	*/
}











