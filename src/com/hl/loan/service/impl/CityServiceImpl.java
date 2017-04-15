package com.hl.loan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.CityDao;
import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.service.CityService;
import com.hl.loan.util.PageModel;

@Service("cityDao")
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao cityDao;

	@Override
	public PageModel<City> showCity(PageModel<City> pm, City city) {
		return cityDao.showCity(pm, city);
	}

	@Override
	public List<City> getCityByID(String cityID) {
		return cityDao.getCityByID(cityID);
	}

	@Override
	public int updateCityByID(String cityID, City city) {
		int result = cityDao.updateCityByID(cityID, city);
		return result;
	}

	@Override
	public void addCity(City city) {
		cityDao.addCity(city);
	}

	@Override
	public int deleteCity(String cityID) {
		int result = cityDao.deleteCity(cityID);
		return result;
	}

	@Override
	public List<Area> getAllArea() {
		return cityDao.getAllArea();
	}

	@Override
	public List<City> getAllCity() {
		return cityDao.getAllCity();
	}

}