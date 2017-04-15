package com.hl.loan.service;

import java.util.List;
import com.hl.loan.pojo.ComLp;
import com.hl.loan.util.PageModel;

public interface ComLpService {

	// 增加楼盘信息
	public void addComLp(ComLp comLp);

	public PageModel<ComLp> showComLp(PageModel<ComLp> pm, ComLp comLp);
	
	// 根据ID删除楼盘
	public int delComLp(String lpID);
	
	// 根据ID查出楼盘信息
	public List<ComLp> getComLpByID(String lpID);
	
	// 根据ID修改楼盘信息
	public int updateComLpByID(String lpID, ComLp comLp);
	
	public ComLp getComLp(String lpID);
	
	//查出所有楼盘信息
	public List<ComLp> getAllLp();
	
	//根据城市id获取对应楼盘
	public List<ComLp> getAllLnapByCityID(Long cityID);
}
