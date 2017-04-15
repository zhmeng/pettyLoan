package com.hl.loan.dao;

import java.util.List;

import com.hl.loan.pojo.ComBaseData;
import com.hl.loan.util.PageModel;

public interface ComBaseDataDao {

	public PageModel<ComBaseData> showBase(PageModel<ComBaseData> pm, ComBaseData cbd);

	public List<ComBaseData> getByClass(String baseDataList);

	public int getBaseCount(String baseDataList);

	public void addBase(ComBaseData comb);

	

}
