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
import javax.persistence.Table;
@Entity
@Table(name="City")

public class City implements Serializable{

	/**
	 * 角色
	 */
	@Id
	@Column(name="ID")
	private Long ID;
	@Column(name="CityID")
	private Long cityID;
	
	@Column(name="CityName")
	private String cityName;
	
	@Column(name="CityState")
	private Integer cityState; //0：显示 1：不显示
	
	@Column(name="Father")
	
	private String Father;
	
	/*@ManyToOne
	@JoinColumn(name="area_areaid")*/
	private Area area;
	
	

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Integer getCityState() {
		return cityState;
	}

	public void setCityState(Integer cityState) {
		this.cityState = cityState;
	}


	public Long getCityID() {
		return cityID;
	}

	public void setCityID(Long cityID) {
		this.cityID = cityID;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getFather() {
		return Father;
	}

	public void setFather(String father) {
		Father = father;
	}
	
	
	
}











