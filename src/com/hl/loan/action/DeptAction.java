package com.hl.loan.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.SysDept;
import com.hl.loan.service.DeptService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.Buttons;

@Namespace("/action/dept")
@ResultPath("/")
public class DeptAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DeptService deptService;
	private SysDept sysDept;
	private PageModel<SysDept> pm;
	
	public SysDept getSysDept() {
		return sysDept;
	}

	public void setSysDept(SysDept sysDept) {
		this.sysDept = sysDept;
	}

	public PageModel<SysDept> getPm() {
		return pm;
	}

	public void setPm(PageModel<SysDept> pm) {
		this.pm = pm;
	}

	// search dept list
	@Action(value = "goDeptList", results = { @Result(name = "success", location = "/SYS/SysDept/dept_list.jsp") })
	public String DeptList() {
		List<Buttons> blist=this.getUrlRight(1);//权限控制
		SysDept dept = getSysDept();
		PageModel<SysDept> pm = new PageModel<SysDept>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = deptService.showDept(pm, dept);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}
	
	@Action(value = "toAddDept", results = { @Result(name = "success", location = "/SYS/SysDept/dept_add.jsp") })
	public String toAddDept() {
		this.getUrlRight(2);//权限控制
		List<SysDept> deptList = deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		return "success";
	}
	
	@Action(value = "addDept")
	public void addDept(){
		String deptName = this.getRequest().getParameter("deptName");
		
		String deptState = this.getRequest().getParameter("deptState");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String strdt=sdf.format(new Date());
		SysDept dept = new SysDept();
		dept.setDeptName(deptName);
		dept.setDeptID(strdt+(int)(Math.random()*1000) + "");
		dept.setDeptState(Integer.valueOf(deptState));
		
		deptService.addDept(dept);
		try {
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 删除部门
	@Action(value = "delDept")
	public void delDept() {
		this.getUrlRight(4);//权限判断
		String deptID = this.getRequest().getParameter("deptID");
		int result = deptService.deleteDept(deptID);
		try {
			if (result == 1) {
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 跳转到修改部门页面
	@Action(value = "toUpdateDept", results = { @Result(name = "success", location = "/SYS/SysDept/dept_update.jsp") })
	public String toUpdateDept() {
		this.getUrlRight(8);//权限判断
		String deptID = this.getRequest().getParameter("deptID");
		SysDept dept = deptService.getDeptByID(deptID);
		this.getRequest().setAttribute("dept", dept);
		return "success";
	}
	
	@Action(value = "updateDept")
	public void updateDept(){
		String deptID = this.getRequest().getParameter("deptID");
		String deptName = this.getRequest().getParameter("deptName");
		// String parentDeptID = this.getRequest().getParameter("parentDeptID");
	/*	String deptMG = this.getRequest().getParameter("deptMG");
		String deptMGTel = this.getRequest().getParameter("deptMGTel");
		String deptTel = this.getRequest().getParameter("deptTel");
		String deptFax = this.getRequest().getParameter("deptFax");
		String deptAddr = this.getRequest().getParameter("deptAddr");
		String deptPost = this.getRequest().getParameter("deptPost");
		String deptState = this.getRequest().getParameter("deptState");
		String deptBranchID = this.getRequest().getParameter("deptBranchID");
		String deptFlag = this.getRequest().getParameter("deptFlag");
		String deptIsBR = this.getRequest().getParameter("deptIsBR");
		String deptIsCR = this.getRequest().getParameter("deptIsCR");
		String deptIsCS = this.getRequest().getParameter("deptIsCS");
		String deptDesc = this.getRequest().getParameter("deptDesc");
*/
		SysDept dept = deptService.getDeptByID(deptID);
		dept.setDeptName(deptName);
		// dept.setDeptID(parentDeptID);
		/*dept.setDeptMG(Integer.valueOf(deptMG));
		dept.setDeptMGTel(deptMGTel);
		dept.setDeptTel(deptTel);
		dept.setDeptFax(deptFax);
		dept.setDeptAddr(deptAddr);
		dept.setDeptPost(deptPost);
		dept.setDeptState(Integer.valueOf(deptState));
		dept.setDeptBranchID(Integer.valueOf(deptBranchID));
		dept.setDeptFlag(Integer.valueOf(deptFlag));
		dept.setDeptIsBR(Integer.valueOf(deptIsBR));
		dept.setDeptIsCR(Integer.valueOf(deptIsCR));
		dept.setDeptIsCS(Integer.valueOf(deptIsCS));
		dept.setDeptDesc(deptDesc);*/
		deptService.updateDeptByID(deptID, dept);
		try {
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}