package com.hl.loan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl.loan.dao.DeptDao;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.service.DeptService;
import com.hl.loan.util.PageModel;

@Service("deptDao")
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao deptDao;

	@Override
	public List<SysDept> getDept(String deptID, String deptName) {
		return deptDao.getDept(deptID, deptName);
	}

	@Override
	public List<SysDept> getAllDept() {
		return deptDao.getAllDept();
	}

	@Override
	public void addDept(SysDept dept) {
		deptDao.addDept(dept);
	}

	@Override
	public int updateDeptByID(String deptID, SysDept dept) {
		int result = deptDao.updateDeptByID(deptID, dept);
		return result;
	}

	@Override
	public int deleteDept(String deptID) {
		int result = deptDao.deleteDept(deptID);
		return result;
	}

	@Override
	public PageModel<SysDept> showDept(PageModel<SysDept> pm, SysDept dept) {
		return deptDao.showDept(pm, dept);
	}
	
	@Override
	public SysDept getDeptByID(String deptID) {
		return deptDao.getDeptByID(deptID);
	}
}