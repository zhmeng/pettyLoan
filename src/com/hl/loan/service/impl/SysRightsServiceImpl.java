package com.hl.loan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hl.loan.dao.SysModuleDao;
import com.hl.loan.dao.SysRightsDao;
import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysRights;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.SysModuleService;
import com.hl.loan.service.SysRightsService;
import com.hl.loan.util.PageModel;

@Service("sysRightsService")
public class SysRightsServiceImpl implements SysRightsService{
	@Resource
	private SysRightsDao rightsDao;

	@Override
	public List<SysRights> getSysRightsByID(String RoleID) {
		return rightsDao.getSysRightsByID(RoleID);
	}

	@Override
	public void add(SysRights rights) {
		rightsDao.add(rights);
	}

	@Override
	public List<SysRights> getAllsysrigh() {
		return rightsDao.getAllsysrigh();
	}

	@Override
	public List<SysRights> getSysRightsByModID(String RightsModID) {
		return rightsDao.getSysRightsByModID(RightsModID);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor= Exception.class)
	public int updateCheck(SysRights sysright,Integer roleID, Integer roleOruser, String mid) {
		// TODO Auto-generated method stub
		int rightsID= rightsDao.updateCheck(sysright,roleID, roleOruser, mid);
		sysright.setRightsID(rightsID);
		rightsDao.updates(sysright);
		return 1;
	}
	@Override
	public List<SysRights> getSysRightById(int right, int id,int isRight){
		return rightsDao.getSysRightById(right, id, isRight);
	}
	@Override
	public List<SysRights> getSysRightByIds(int right,int id,String  rightMidId){
		return rightsDao.getSysRightByIds(right, id, rightMidId);
	}
}



