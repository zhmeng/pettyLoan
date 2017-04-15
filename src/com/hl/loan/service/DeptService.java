package com.hl.loan.service;

import java.util.List;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.util.PageModel;

public interface DeptService {
	
	// 查出所有部门
	public List<SysDept> getAllDept();

	// 根据部门名称和机构编号查出部门
	public List<SysDept> getDept(String deptID, String deptName);

	// 增加部门信息
	public void addDept(SysDept dept);

	// 根据ID修改部门信息
	public int updateDeptByID(String deptID, SysDept dept);

	// 根据ID删除部门信息
	public int deleteDept(String deptID);

	public PageModel<SysDept> showDept(PageModel<SysDept> pm, SysDept dept);
	
	// 根据ID查出部门信息
	public SysDept getDeptByID(String deptID);
}
