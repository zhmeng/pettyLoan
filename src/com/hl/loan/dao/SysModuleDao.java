package com.hl.loan.dao;

import java.util.List;

import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.util.PageModel;

public interface SysModuleDao {

	public List<SysModule> showAllModel(int ModFlag, SysUser sysUser);
	
	public List<SysModule> getAllSysModule();
	
	public List<SysModule> getAllSysModuleByModID(String modID);

	public List<SysModule> getByUrl(String url);
	
	
}
