package com.hl.loan.action;

import java.io.IOException;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.NoteAndUserService;
import com.hl.loan.service.SysUserService;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;

@Namespace("/action/noteAndUser")
@ResultPath("/")
public class NoteAndUserAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);

	@Autowired
	private NoteAndUserService noteAndUserService;
	private NoteAndUser noteAndUser;
	private PageModel<NoteAndUser> pm;
	private SysUserService sysUserService;

	public SysUserService getSysUserService() {
		return sysUserService;
	}
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	public PageModel<NoteAndUser> getPm() {
		return pm;
	}
	public void setPm(PageModel<NoteAndUser> pm) {
		this.pm = pm;
	}
	public NoteAndUserService getNoteAndUserService() {
		return noteAndUserService;
	}
	public void setNoteAndUserService(NoteAndUserService noteAndUserService) {
		this.noteAndUserService = noteAndUserService;
	}
	public NoteAndUser getNoteAndUser() {
		return noteAndUser;
	}
	public void setNoteAndUser(NoteAndUser noteAndUser) {
		this.noteAndUser = noteAndUser;
	}

	@Action(value = "goNoteAndUserList", results = { @Result(name = "success", location = "/noteAndUser/noteAndUser_list.jsp") })
	public String goNoteAndUserList() {
		NoteAndUser noteAndUser = getNoteAndUser();
		PageModel<NoteAndUser> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = noteAndUserService.showNoteAndUser(pm, noteAndUser);
		this.getRequest().setAttribute("pm", pm);
		return "success";
	}
	
	@Action(value = "toAdd", results = { @Result(name = "success", location = "/noteAndUser/noteAndUser_add.jsp") })
	public String toAdd() {
		return "success";
	}

	@Action(value = "delete")
	public void delete() {
		String id = this.getRequest().getParameter("id");
		try {
			NoteAndUser nu = noteAndUserService.getNoteAndUserById(id);
			noteAndUserService.delNoteAndUser(nu);
			writeResult(true, "删除成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Action(value = "getNoteAndUserByStatus", results = { @Result(name = "success", location = "/noteAndUser/noteAndUser_update.jsp") })
	public void getNoteAndUserByStatus() {
		String status = this.getRequest().getParameter("status");
		try {
			List<NoteAndUser> noteUserlist = noteAndUserService.getNoteAndUserByStatus(Integer.valueOf(status));
			this.getRequest().setAttribute("noteUserlist", noteUserlist);
			String str = "";
			if (noteUserlist != null && noteUserlist.size() > 0) {
				for (NoteAndUser noteAndUser : noteUserlist) {
					str += "<option value=\"" + noteAndUser.getUserId() + "\">" + noteAndUser.getUserName() + "</option>";
				}
			}
			str += ";";
			List<SysUser> userList = sysUserService.exists(Integer.valueOf(status));
			if (userList != null && userList.size() > 0) {
				for (SysUser user : userList) {
					str += "<option value=\"" + user.getUserID() + "\">" + user.getUserName() + "</option>";
				}
			}
			writeResult(true, str, this.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Action(value = "addNoteAndUser")
	public void addNoteAndUser() {
		String userSelect1 = this.getRequest().getParameter("userSelect1");
		Integer status = Integer.valueOf(this.getRequest().getParameter("status"));
		try {
			String[] str = userSelect1.split(",");
			List<NoteAndUser> noteUserlist = noteAndUserService.getNoteAndUserByStatus(Integer.valueOf(status));
			if(null != noteUserlist && noteUserlist.size() > 0){
				for (NoteAndUser noteAndUser : noteUserlist) {
					noteAndUserService.delNoteAndUser(noteAndUser);
				}
			}
			if (!userSelect1.equals("")) {
				for (String userId : str) {
					SysUser user = sysUserService.getUserByID(userId);
					
					NoteAndUser noteAndUser = new NoteAndUser();
					noteAndUser.setUserId(user.getUserID());
					noteAndUser.setUserName(user.getUserFullName());
					noteAndUser.setStatus(status);
					if (status == 201) 
						noteAndUser.setStatusName("审批专员");
					if (status == 202) 
						noteAndUser.setStatusName("审批主管");
					if (status == 203) 
						noteAndUser.setStatusName("审批经理");
					noteAndUserService.addNote(noteAndUser);
				}
			}
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}