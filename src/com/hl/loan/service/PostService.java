package com.hl.loan.service;

import java.util.List;

import com.hl.loan.dao.BaseDao;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.pojo.SysPost;
import com.hl.loan.pojo.SysUser;



public interface PostService {
	//查出所有公司职位
	public List<SysPost> getAllPost();
	
	//根据职位名称和所属部门查出公司职位
	public List getPost(String PostName,String PostIsDept);
	
	//增加公司职位信息
	public void addPost(SysPost post);
	
}
