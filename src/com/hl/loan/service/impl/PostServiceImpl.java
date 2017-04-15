package com.hl.loan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.DeptDao;
import com.hl.loan.dao.PostDao;
import com.hl.loan.dao.impl.BaseDaoImpl;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.pojo.SysPost;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.DeptService;
import com.hl.loan.service.PostService;

@Service("postDao")
public class PostServiceImpl  implements PostService{
	@Autowired
	private PostDao postDao;
	@Override
	public List<SysPost> getAllPost() {
		return postDao.getAllPost();
	}

	@Override
	public List getPost(String PostName, String PostIsDept) {
		return (List) postDao.getPost(PostName, PostIsDept);
	}

	@Override
	public void addPost(SysPost post) {
		postDao.addPost(post);
	}

	
}
