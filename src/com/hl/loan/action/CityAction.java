package com.hl.loan.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.service.CityService;
import com.hl.loan.service.RoleService;
import com.hl.loan.util.PageModel;

@Namespace("/action/city")
@ResultPath("/")
public class CityAction extends BaseAction{
	@Autowired
	private CityService cityService;
	private City city;
	private PageModel<City> pm;

	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public PageModel<City> getPm() {
		return pm;
	}


	public void setPm(PageModel<City> pm) {
		this.pm = pm;
	}


	/*
	 * 按条件查找相应部门信息
	 */
	@Action(value="goCityList", results={
			@Result(name="success",location="/SYS/SysCity/sys_city2.jsp")
	})
	public String CityList(){
		City city=getCity();
		if(city!=null){
			String cityName =city.getCityName().trim();
			city.setCityName(cityName);
		}
		PageModel<City> pm=new PageModel<City>();
		if(getPm()!=null){
			pm=getPm();
		}
		pm=cityService.showCity(pm, city);
		this.getSession().setAttribute("pm", pm);
		this.getSession().setAttribute("city", city);
		return "success";	
	}
	
	// 跳转到修改角色页面
	 
	@Action(value="toUpdateCity", results={
			@Result(name="success",location="/SYS/SysCity/sys_update_city.jsp")
	})
	public String toUpdateCity(){
		String cityID = this.getRequest().getParameter("cityID");
		List<City> city = cityService.getCityByID(cityID);
		this.getRequest().setAttribute("city", city);
		return "success";
	}
	
	
	// 修改城市信息
	 
	@Action(value="UpdateCity")
	public void UpdateCity(){
		String cityID= this.getRequest().getParameter("cityID");
		String cityName = this.getRequest().getParameter("cityName");
		City city = new City();
		city.setCityID(Long.valueOf(cityID));
		city.setCityName(cityName);
		int result= cityService.updateCityByID(cityID, city);
		try {
			if(result == 1){
				writeResult(true, "修改成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 // 跳转到增加部门表页面
	 
		@Action(value="toAddCity", results={
				@Result(name="success",location="/SYS/SysCity/city_add.jsp")
		})
		public String toAddCity(){
			List<Area> areas = cityService.getAllArea();
			this.getRequest().setAttribute("areas", areas);
			return "success";
		}
		
		//* 添加角色信息
		 
		@Action(value="AddCity")
		public void AddCity(){
			String areaName= this.getRequest().getParameter("areaName");
			String cityID= this.getRequest().getParameter("cityID");
			String cityName = this.getRequest().getParameter("cityName");
			String cityState = this.getRequest().getParameter("cityState");
			City city = new City();
			city.setCityID(Long.valueOf(cityID));
			city.setCityName(cityName);
			city.setCityState(Integer.valueOf(cityState));
			city.setFather(areaName);
			cityService.addCity(city);
			try {
				writeResult(true, "保存成功！", this.getResponse());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 /* 
	 * 修改城市状态
	 */
	@Action(value="deleCity")
	public void deleCity(){
		String cityID= this.getRequest().getParameter("cityID");
		int result = cityService.deleteCity(cityID);
		try {
			if(result == 1){
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
