package com.hl.loan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.SysModuleDao;
import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.SysModuleService;
import com.hl.loan.util.PageModel;

@Service("sysModuleService")
public class SysModuleServiceImpl implements SysModuleService{
	@Resource
	private SysModuleDao sysModuleDao;
	@Override
	public List<SysModule> showAllModel(int ModFlag,SysUser sysUser){
		return sysModuleDao.showAllModel(ModFlag,  sysUser);
	}
	@Override
	public List<SysModule> getAllSysModule() {
		return sysModuleDao.getAllSysModule();
	}
	@Override
	public List<SysModule> getAllSysModuleByModID(String modID) {
		return sysModuleDao.getAllSysModuleByModID(modID);
	}
	@Override
	public List<SysModule> getByUrl(String url){
		return sysModuleDao.getByUrl(url);
	}
}
