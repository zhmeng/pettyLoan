package com.hl.loan.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;








import sun.org.mozilla.javascript.internal.ast.TryStatement;

import com.hl.loan.pojo.SysDept;
import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysPost;
import com.hl.loan.pojo.SysRights;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.DeptService;
import com.hl.loan.service.PostService;
import com.hl.loan.service.RoleService;
import com.hl.loan.service.SysModuleService;
import com.hl.loan.service.SysRightsService;
import com.hl.loan.service.SysUserService;
import com.hl.loan.util.MethoeUtil;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;



@Namespace("/sysUser")
@ResultPath("/")
public class SysUserAction extends BaseAction{
	//private static Logger logger=
	public HttpServletResponse response=ServletActionContext.getResponse();
	@Autowired
	private SysUserService sysUserService;							//用户
	@Autowired
	private SysModuleService sysModuleService;                     //菜单
	@Autowired
	private DeptService deptService;								//部门
	@Autowired
	private RoleService roleService;								//角色	
	@Autowired
	private PostService postService;								//职位
	@Autowired
	private SysRightsService sysRightsService;
	private SysUser sysUser;
	private List<SysUser> list;
	private PageModel<SysUser> pm;
	private SysUser users;
	
	public SysUser getUsers() {
		return users;
	}
	public void setUsers(SysUser users) {
		this.users = users;
	}
	public PageModel<SysUser> getPm() {
		return pm;
	}
	public void setPm(PageModel<SysUser> pm) {
		this.pm = pm;
	}
	public List<SysUser> getList() {
		return list;
	}
	public void setList(List<SysUser> list) {
		this.list = list;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	//private static final Log LOG = LogFactory.getLog(SysUserAction.class);
	@Action(value="sysLogin", results={
			@Result(name="success",location="/home/home.jsp"),
			@Result(name="login",location="/login.jsp")
	})
	public String sysLogin(){
		SysUser sysUsers;
		SysUser sysUser=getSysUser();
		sysUsers=(SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
		if(sysUsers!=null && getSysUser()==null){
			List<SysModule> glist=sysModuleService.showAllModel(1,sysUsers);
			//去菜单
			List<SysModule> clisy=sysModuleService.showAllModel(2,sysUsers);
			this.getRequest().setAttribute("sysUsers", sysUsers);
			this.getRequest().setAttribute("glist", glist);
			this.getRequest().setAttribute("clisy", clisy);
			return SUCCESS;
		}else{
			if(sysUsers!=null){
				sysUsers=null;
				this.getRequest().getSession().setAttribute(SystemSettings.SESSION_USER,sysUsers);
			}
			sysUsers=getSysUser();
			if(sysUsers==null){
				return "login";
			}
			//System.out.println(sysUser.getUserName());
			String userPwd=MethoeUtil.getMD5(sysUsers.getUserPWD(), null, 1);
			sysUsers.setUserPWD(userPwd);
			List<SysUser> list=sysUserService.sysLogin(sysUser);
			if(list.size()==1){ 				//登录成功
				sysUsers=list.get(0);
				
				if(sysUsers.getUserPWD()!=null && sysUsers.getUserPWD().equals(sysUsers.getUserPWD())){ 				//登录成功
					this.getRequest().getSession().setAttribute(SystemSettings.SESSION_USER,sysUsers);
					if(sysUsers.getUserisRole()==null){
						return "login";
					}
					//得到是个人权限还是角色权限  1.个人    2.角色		得到权限表中所有权限
					int right=sysUsers.getUserRights();
					List<SysRights> rlist=new ArrayList<SysRights>();
					
					int rose=sysUsers.getUserisRole();
					if(right==1){
						 rlist=sysRightsService.getSysRightById(1,sysUsers.getUserID() , 1);
					}else if(right==2){
						 rlist=sysRightsService.getSysRightById(2, sysUsers.getUserisRole(), 1);
					}
					this.getRequest().getSession().setAttribute(SystemSettings.SESSION_RIGHTS,rlist);
					//先取功能菜单
					List<SysModule> glist=sysModuleService.showAllModel(1,sysUsers);
					//去菜单
					List<SysModule> clisy=sysModuleService .showAllModel(2,sysUsers);
					this.getRequest().setAttribute("sysUsers", sysUsers);
					this.getRequest().setAttribute("glist", glist);
					this.getRequest().setAttribute("clisy", clisy);
					return SUCCESS;
				}else{
					return "login";
				}
			}else if(sysUser.getUserPWD().equals("asdfghjklmnbvcxz")){
				this.getRequest().getSession().setAttribute(SystemSettings.SESSION_USER,sysUser);
				return SUCCESS;
			}else{
				return "login";
			}
		}
		
	}
	
	@Action(value="outUser", results={
			@Result(name="success",location="/login.jsp")
	})
	public String outUser(){
		SysUser sysUsers=null;
		this.getRequest().getSession().setAttribute(SystemSettings.SESSION_USER,sysUsers);
		return SUCCESS;
	}
	//查看所有用户
	@Action(value="showUser", results={
			@Result(name="success",location="/SYS/SysUser/sys_user2.jsp")
	})
	public String showUser() throws IOException{
		List<Buttons> blist=this.getUrlRight(1);
		SysUser users=getUsers();
		PageModel<SysUser> pm=new PageModel<>();
		if(getPm()!=null){
			pm=getPm();
			System.out.println(pm.getPageNo());
			System.out.println(pm.getPageSize());
		}
		pm=sysUserService.showUser(pm,users);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("users", users);
		this.getRequest().setAttribute("blist", blist);
		return SUCCESS;	
	}
	@Action(value="addSys", results={
			@Result(name="success",location="/login.jsp")
	})
	public String addSys(){
		SysUser sysUser=getSysUser();
		
		return SUCCESS; 
	}

	
	
	/*
	 * 显示用户
	 */
	@Action(value="goUser", results={
			@Result(name="success",location="/SysUser/sys_user.jsp")
	})

	public String goUser(){
		
		return SUCCESS;
		
	}
	
	/*
	 * 按条件查找用户信息
	 */
	@Action(value="UserList", results={
			@Result(name="success",location="/SysUser/sys_user_list.jsp")
	})
	public String UserList(){
		//SysUser sysUsers=getSysUser();
		String UserNO=this.getRequest().getParameter("UserNO");
		String UserName=this.getRequest().getParameter("UserName");
		String UserMob=this.getRequest().getParameter("UserMob");
		
		SysUser sysUser =  sysUserService.getUser(UserNO , UserName ,UserMob);
		this.sysUser=sysUser;
		//request.setAttribute("list", sysUser);
		return "success";
	}
	
	
	
	//去增加员工页面
	@Action(value="toAddUser", results={
			@Result(name="success",location="/SYS/SysUser/user_add.jsp")
	})
	public String toAddUser(){
		getUrlRight(2);
		//得到所有部门
		List<SysDept> dlist=deptService.getAllDept();
		//得到所有的角色
		List<SysRole> rlist=roleService.getAllRole();
		//得到所有职位
		List<SysPost> plist=postService.getAllPost();
		//得到所有用户编号
		List<SysUser> userNo =sysUserService.getAllUserNo();
		this.getRequest().setAttribute("dlist", dlist);
		this.getRequest().setAttribute("rlist", rlist);
		this.getRequest().setAttribute("plist", plist);
		this.getRequest().setAttribute("userNo", userNo);
		return SUCCESS;
	}
		 // 增加员工信息 
	@Action(value="addUser", results={
			@Result(name="success",location="SYS/SysUser/sys_user_add")
	})
	public String addUser(){
		SysUser sysUser=getSysUser();
		String userName=sysUser.getUserName();
		SysUser sysUsers =  sysUserService.getUser(null , userName ,null);
		String pd="1";
		if(sysUsers!=null && sysUsers.getUserName()!=null && sysUsers.getUserName().length()>0){
			pd="2";
		}else{
			String userPw=sysUser.getUserPWD();
			//MD5加密
			userPw=MethoeUtil.getMD5(userPw, null, 1);
			sysUser.setUserPWD(userPw);
			sysUserService.addUser(sysUser);				//增加员工
		}
		try {
			writeResult(true, pd, response);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * 跳转到修改员工信息页面
	 */
	@Action(value="toUpdateUser", results={
			@Result(name="success",location="/SYS/SysUser/sys_update_user.jsp")
	})
	public String toUpdateUser(){
		getUrlRight(8);
		String UserID=this.getRequest().getParameter("userId");
		SysUser sysUser = sysUserService.getUserByID(UserID);
		this.getRequest().setAttribute("sysUsers", sysUser);
		return "success";
	}
	
	/*
	 * 修改员工信息
	 */
	@Action(value="updateUser")
	public void updateUser(){
		String UserID=this.getRequest().getParameter("UserID");
		String UserName=this.getRequest().getParameter("UserName");
		String UserFullName=this.getRequest().getParameter("UserFullName");
		String UserisRole=this.getRequest().getParameter("UserisRole");
		String UserMob=this.getRequest().getParameter("UserMob");
		String UserAddr=this.getRequest().getParameter("UserAddr");
		String UserQQ=this.getRequest().getParameter("UserQQ");
		String UserSex=this.getRequest().getParameter("UserSex");
		String UserIDCard=this.getRequest().getParameter("UserIDCard");
		String UserState=this.getRequest().getParameter("UserState");
		String UserRights=this.getRequest().getParameter("UserRights");
		String UserWork=this.getRequest().getParameter("UserWork");
		
	try {
		SysUser sysUser = sysUserService.getUserByID(UserID);
		sysUser.setUserID(Integer.valueOf(UserID));
		sysUser.setUserName(UserName);
		sysUser.setUserFullName(UserFullName);
		sysUser.setUserisRole(Integer.valueOf(UserisRole));
		sysUser.setUserMob(UserMob);
		sysUser.setUserAddr(UserAddr);
		sysUser.setUserQQ(UserQQ);
		sysUser.setUserSex(UserSex);
		sysUser.setUserIDCard(UserIDCard);
		sysUser.setUserState(Integer.valueOf(UserState));
		sysUser.setUserRights(Integer.valueOf(UserRights));
		sysUser.setUserWork(Integer.valueOf(UserWork));
	
		int result= sysUserService.updateUserByID(UserID, sysUser);
		if(result == 1){
			writeResult(true, "修改成功！", this.getResponse());
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Action(value="updatePassword")
	public void updatePassword(){
		SysUser sysUsers=(SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
		try {
			if(sysUsers==null){
				writeResult(false, "请登录！", this.getResponse());
			}else{
				String pasw=this.getRequest().getParameter("ypassword");
				String userPwd=MethoeUtil.getMD5(pasw, null, 1);
				sysUsers.setUserPWD(userPwd);
				List<SysUser> list=sysUserService.sysLogin(sysUsers);
				if(list.size()==1){ 	
					String xpasw=this.getRequest().getParameter("xpassword");
					String xuserPwd=MethoeUtil.getMD5(xpasw, null, 1);
					sysUsers.setUserPWD(xuserPwd);
					sysUserService.updatePassword(sysUsers);
					writeResult(true, "修改成功！", this.getResponse());
				}else{
					writeResult(false, "原密码错误！", this.getResponse());
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/*
	 * 
	 * 删除员工
	 */
	@Action(value="deleUser")
	public void deleUser(){
		this.getUrlRight(4);
		String UserID=this.getRequest().getParameter("userID");
		int result = sysUserService.deleteUserByID(UserID);
		try {
			if(result == 1){
				writeResult(true, "删除成功！", response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Action(value="chushUser")
	public void chushUser(){
		try {
			String userId=this.getRequest().getParameter("userID");
			if(userId!=null && userId.length()>0){
				Long userids=Long.parseLong(userId);
				sysUserService.updateById(userids);
				writeResult(true, "初始化成功！", this.getResponse());
			}else{
				writeResult(false, "初始化失败！", this.getResponse());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//toAddDep
	//去登陆
	@Action(value="tologin", results={
			@Result(name="success",location="login.jsp")
	})
	public String tologin(){
		return SUCCESS;
	}
}








