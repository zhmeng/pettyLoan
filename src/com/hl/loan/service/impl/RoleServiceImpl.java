package com.hl.loan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.RoleDao;

import com.hl.loan.pojo.SysRole;
import com.hl.loan.service.RoleService;
import com.hl.loan.util.PageModel;

@Service("roleDao")
public class RoleServiceImpl  implements RoleService{
	@Autowired
	private RoleDao roleDao;

	@Override
	public PageModel<SysRole> showRole(PageModel<SysRole> pm, SysRole sysRole) {
		return roleDao.showRole(pm, sysRole);
	}


	@Override
	public int updateRoleByID(String roleId, SysRole sysRole) {
		int result = roleDao.updateRoleById(roleId, sysRole);
		return result;
	}


	@Override
	public List<SysRole> getRoleById(String RoleId) {
		return roleDao.getRoleByID(RoleId);
	}
	
	@Override
	public int deleteRole(String roleId) {
		int result = roleDao.deleteRole(roleId);
		return result;
	}
	
	@Override
	public void addRole(SysRole role) {
		roleDao.addRole(role);
	}
	
	@Override
	public List<SysRole> getAllRole(){
		return roleDao.getAllRole();
	}
}
