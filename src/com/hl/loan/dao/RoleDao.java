package com.hl.loan.dao;

import java.util.List;



import com.hl.loan.pojo.SysRole;
import com.hl.loan.util.PageModel;

public interface RoleDao {
	
	public PageModel<SysRole> showRole(PageModel<SysRole> pm, SysRole sysRole);

	// 根据ID修改部门信息
	public int updateRoleById(String RoleId, SysRole sysRole);

	// 根据roleID查出角色信息
	public List<SysRole> getRoleByID(String RoleID);

	// 根据ID删除角色
	public int deleteRole(String roleId);

	// 增加角色
	public void addRole(SysRole role);
	
	public List<SysRole> getAllRole();
}
