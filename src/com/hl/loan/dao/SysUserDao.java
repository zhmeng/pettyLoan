package com.hl.loan.dao;

import java.util.List;

import com.hl.loan.pojo.SysUser;
import com.hl.loan.util.PageModel;

public interface SysUserDao {
	
	public List<SysUser> sysLogin(SysUser sysUser);

	// 查询所有员工
	public List<SysUser> getAllUser();

	// 根据员工编号、用户名和手机号号查出部门
	public SysUser getUser(String UserNO, String UserName, String UserMob);

	// 增加员工信息
	public void addUser(SysUser user);

	// 根据ID查出员工信息
	public SysUser getUserByID(String UserID);

	// 根据ID修改员工股信息
	public int updateUserByID(String UserID, SysUser sysUser);

	// 根据ID删除用户
	public int deleteUserByID(String UserID);

	public PageModel<SysUser> showUser(PageModel<SysUser> pm, SysUser users);

	// 得到所有员工编号，是唯一的
	public List<SysUser> getAllUserNo();
	
	public List<SysUser> exists(int status);
	public void updatePassword(SysUser sysUser);

	public void updateById(Long userId);
}
