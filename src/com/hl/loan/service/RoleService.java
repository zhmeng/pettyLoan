package com.hl.loan.service;

import java.util.List;

import com.hl.loan.dao.BaseDao;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.util.PageModel;



public interface RoleService {
	
	public PageModel<SysRole> showRole(PageModel<SysRole> pm, SysRole sysRole);

	// 根据ID修改角色信息
	public int updateRoleByID(String roleId, SysRole sysRole);

	// 根据roleID查出部门信息
	public List<SysRole> getRoleById(String RoleId);

	// 根据ID删除角色
	public int deleteRole(String roleId);

	// 增加角色信息
	public void addRole(SysRole role);
	
	public List<SysRole> getAllRole();
	
}
