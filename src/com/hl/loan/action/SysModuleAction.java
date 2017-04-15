package com.hl.loan.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.SysModuleService;
import com.hl.loan.util.SystemSettings;

@Namespace("/sysModule")
@ResultPath("/")
public class SysModuleAction extends BaseAction{
	@Autowired
	private SysModuleService sysModuleService;
	@Action(value="showMenu", results={
			@Result(name="success",location="/home/home.jsp")
	})
	public String showMenu(){
		SysUser user=(SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
		//先取功能菜单
		List<SysModule> glist=sysModuleService.showAllModel(1,user);
		//去菜单
		List<SysModule> clisy=sysModuleService.showAllModel(2,user);
		this.getRequest().setAttribute("glist", glist);
		this.getRequest().setAttribute("clisy", clisy);
		return null;
	}
}







