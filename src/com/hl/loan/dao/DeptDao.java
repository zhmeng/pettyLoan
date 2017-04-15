package com.hl.loan.dao;

import java.util.List;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.util.PageModel;

public interface DeptDao {
	// 查出所有部门
	public List<SysDept> getAllDept();

	public List<SysDept> getDept(String deptID, String deptName);

	// 增加部门
	public void addDept(SysDept dept);

	// 根据ID修改部门信息
	public int updateDeptByID(String deptID, SysDept dept);
	
	// 根据ID删除部门信息
	public int deleteDept(String deptID);

	public PageModel<SysDept> showDept(PageModel<SysDept> pm, SysDept dept);
	
	// 根据ID查出部门信息
	public SysDept getDeptByID(String deptID);
}