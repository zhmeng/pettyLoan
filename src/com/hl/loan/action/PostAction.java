package com.hl.loan.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.SysPost;
import com.hl.loan.service.PostService;

@Namespace("/action/post")
@ResultPath("/")
public class PostAction extends BaseAction{
	@Autowired
	private PostService postService;
	/*
	 * 显示公司职位
	 */
	@Action(value="goPost", results={
			@Result(name="success",location="/SysPost/sys_post")
	})
	public String goPost(){
		List<SysPost> sysPost= postService.getAllPost();
		this.getRequest().setAttribute("sysPost", sysPost);
		return "success";
		
	}
	
	/*
	 * 按条件查找公司职位信息
	 */
	@Action(value="PostList", results={
			@Result(name="success",location="/SysPost/sys_post_list")
	})
	public String PostList(){
		String PostName = this.getRequest().getParameter("PostName");
		String PostIsDept= this.getRequest().getParameter("PostIsDept");
		List list =  postService.getPost(PostName, PostIsDept);
		this.getRequest().setAttribute("list", list);
		return "success";
	}
	
	
	 // 跳转到公司职位表页面
	 
		@Action(value="toAddPost", results={
				@Result(name="success",location="/SysPost/sys_add_post")
		})
		public String toAddPost(){
			return "success";
		}
	
	 // 增加公司职位信息
	 
	@Action(value="AddPost"/*, results={
			@Result(name="success",location="/SysPost/sys_add_post")
	}*/)
	public void AddPost(){
		String PostName = this.getRequest().getParameter("PostName");
		String PostIsDept = this.getRequest().getParameter("PostIsDept");
		SysPost post = new SysPost();
		post.setPostName(PostName);
		post.setPostIsDept(PostIsDept);
		postService.addPost(post);
		try {
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return "success";
	}
}
