package com.hl.loan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.SysUserDao;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.SysUserService;
import com.hl.loan.util.PageModel;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Resource
	private SysUserDao sysUserDao;

	@Override
	public List<SysUser> sysLogin(SysUser sysUser) {
		return sysUserDao.sysLogin(sysUser);
	}

	@Override
	public List<SysUser> getAllUser() {
		return sysUserDao.getAllUser();
	}

	@Override
	public SysUser getUser(String UserNO, String UserName, String UserMob) {
		return sysUserDao.getUser(UserNO, UserName, UserMob);
	}

	@Override
	public void addUser(SysUser user) {
		sysUserDao.addUser(user);
	}

	@Override
	public SysUser getUserByID(String UserID) {
		return sysUserDao.getUserByID(UserID);
	}

	@Override
	public int updateUserByID(String UserID, SysUser sysUser) {
		int result = sysUserDao.updateUserByID(UserID, sysUser);
		return result;
	}

	@Override
	public int deleteUserByID(String UserID) {
		sysUserDao.deleteUserByID(UserID);
		return 1;
	}

	@Override
	public PageModel<SysUser> showUser(PageModel<SysUser> pm, SysUser users) {
		return sysUserDao.showUser(pm, users);
	}

	@Override
	public List<SysUser> getAllUserNo() {
		return sysUserDao.getAllUserNo();
	}

	@Override
	public List<SysUser> exists(int status) {
		return sysUserDao.exists(status);
	}
	@Override
	public void updatePassword(SysUser sysUser){
		sysUserDao.updatePassword(sysUser);
	}
	@Override
	public void updateById(Long userId){
		sysUserDao.updateById(userId);
	}
}
