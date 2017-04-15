package com.hl.loan.service;

import java.util.List;

import com.hl.loan.pojo.ComBaseData;
import com.hl.loan.util.PageModel;

public interface ComBaseDataDaoService {

	public PageModel<ComBaseData> showBase(PageModel<ComBaseData> pm, ComBaseData cbd);

	public List<ComBaseData> getByClass(String baseDataList);

	public int getBaseCount(String baseDataList);

	public void addBase(ComBaseData comb);

	

}
