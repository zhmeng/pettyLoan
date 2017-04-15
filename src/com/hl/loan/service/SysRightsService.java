package com.hl.loan.service;

import java.util.List;

import com.hl.loan.pojo.SysRights;

public interface SysRightsService {


		public List<SysRights> getSysRightsByID(String RoleID);
		
		public void add(SysRights rights);
		
		public List<SysRights> getAllsysrigh();
		
		public List<SysRights> getSysRightsByModID(String RightsModID);
		
		//复选框修改
		public int updateCheck(SysRights sysright,Integer roleID,Integer roleOruser,String mid);

		public List<SysRights> getSysRightById(int right, int id,int isRight);

		public List<SysRights> getSysRightByIds(int right, int id, String rightMidId);
}
