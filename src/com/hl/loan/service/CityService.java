package com.hl.loan.service;

import java.util.List;
import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.util.PageModel;

public interface CityService {
	// 查出所有城市
	public List<City> getAllCity();
		
	public PageModel<City> showCity(PageModel<City> pm, City city);
	
	// 根据ID查出城市信息
	public List<City> getCityByID(String cityID);
		
	// 根据ID修改城市信息
	public int updateCityByID(String cityID, City city);
		
	// 增加城市信息
	public void addCity(City city);
		
	// 根据ID删除城市
	public int deleteCity(String cityID);
	
	// 查出所有区域
	public List<Area> getAllArea();
}
