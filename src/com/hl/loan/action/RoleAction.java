package com.hl.loan.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.SysDept;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.service.RoleService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.Buttons;

@Namespace("/action/role")
@ResultPath("/")
public class RoleAction extends BaseAction{
	@Autowired
	private RoleService roleService;
	private SysRole sysRole;
	private PageModel<SysRole> pm;
	
	
	public SysRole getSysRole() {
		return sysRole;
	}


	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}


	public PageModel<SysRole> getPm() {
		return pm;
	}


	public void setPm(PageModel<SysRole> pm) {
		this.pm = pm;
	}


	/*
	 * 按条件查找相应部门信息
	 */
	@Action(value="goRoleList", results={
			@Result(name="success",location="/SYS/SysRole/sys_role2.jsp")
	})
	public String RoleList(){
		List<Buttons> blist=this.getUrlRight(1);
		SysRole sysRole=getSysRole();
		if(sysRole!=null){
			String roleName = sysRole.getRoleName().trim();
			sysRole.setRoleName(roleName);
		}
		PageModel<SysRole> pm=new PageModel<>();
		if(getPm()!=null){
			pm=getPm();
		}
		pm=roleService.showRole(pm, sysRole);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("sysRole", sysRole);
		this.getRequest().setAttribute("blist", blist);
		return "success";	
	}
	/*
	 * 跳转到修改角色页面
	 */
	@Action(value="toUpdateRole", results={
			@Result(name="success",location="/SYS/SysRole/sys_update_role.jsp")
	})
	public String toUpdateDept(){
		this.getUrlRight(8);
		String roleId = this.getRequest().getParameter("roleId");
		List<SysRole> sysRoles = roleService.getRoleById(roleId);
		this.getRequest().setAttribute("sysRoles", sysRoles);
		return "success";
	}
	
	/*
	 * 修改部门信息
	 */
	@Action(value="UpdateRoles")
	public void UpdateDepts(){
		String roleId= this.getRequest().getParameter("roleId");
		String roleName = this.getRequest().getParameter("roleName");
		String roleState = this.getRequest().getParameter("roleState");
		SysRole sysRole = new SysRole();
		sysRole.setRoleId(Integer.valueOf(roleId));
		sysRole.setRoleName(roleName);
		sysRole.setRoleState(Integer.valueOf(roleState));
		int result= roleService.updateRoleByID(roleId, sysRole);
		try {
			if(result == 1){
				writeResult(true, "修改成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 
	 * 删除角色
	 */
	@Action(value="deleRole")
	public void deleRole(){
		this.getUrlRight(4);
		String roleId= this.getRequest().getParameter("roleId");
		int result = roleService.deleteRole(roleId);
		try {
			if(result == 1){
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 跳转到增加部门表页面
	 */
	@Action(value="toAddRole", results={
			@Result(name="success",location="/SYS/SysRole/role_add.jsp")
	})
	public String toAddDept(){
		this.getUrlRight(2);//权限控制
		return "success";
	}
	
	/*
	 * 添加角色信息
	 */
	@Action(value="AddRole")
	public void AddDept(){
		String RoleName= this.getRequest().getParameter("RoleName");
		String RoleState = this.getRequest().getParameter("RoleState");
		SysRole role = new SysRole();
		role.setRoleName(RoleName);
		role.setRoleState(Integer.valueOf(RoleState));
		role.setRoleAddTime(new Date());
		roleService.addRole(role);
		
		try {
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
