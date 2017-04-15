package com.hl.loan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.ComBaseDataDao;
import com.hl.loan.pojo.ComBaseData;
import com.hl.loan.service.ComBaseDataDaoService;
import com.hl.loan.util.PageModel;

@Service("comBaseDataService")
public class ComBaseDataServiceImpl implements ComBaseDataDaoService{
	@Resource
	private ComBaseDataDao comBaseDataDao;
	@Override
	public PageModel<ComBaseData> showBase(PageModel<ComBaseData> pm,ComBaseData cbd){
		return comBaseDataDao.showBase(pm, cbd);
	}
	@Override
	public List<ComBaseData> getByClass(String baseDataList){
		return comBaseDataDao.getByClass(baseDataList);
	}
	@Override
	public int getBaseCount(String baseDataList){
		return comBaseDataDao.getBaseCount(baseDataList);
	}
	@Override
	public void addBase(ComBaseData comb){
		comBaseDataDao.addBase(comb);
	}
}
