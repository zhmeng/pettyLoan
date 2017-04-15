package com.hl.loan.action;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.Checkbox;
import com.hl.loan.pojo.Operator;
import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysRights;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.RoleService;
import com.hl.loan.service.SysModuleService;
import com.hl.loan.service.SysRightsService;
import com.hl.loan.service.SysUserService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.Radios;

@Namespace("/action/right")
@ResultPath("/")
public class RightAction extends BaseAction{
	@Autowired
	private RoleService roleService;
	private SysRole sysRole;
	private PageModel<SysRole> pm;
	
	@Autowired
	private SysUserService sysUserService;
	private SysUser users;
	private PageModel<SysUser> pms;
	
	@Autowired
	private SysRightsService sysRightsService;
	private SysModuleAction sysModuleAction;
	private PageModel<SysModuleAction> pmm;
	
	@Autowired
	private SysModuleService sysModuleService;
	
	private SysModule module;
	
	
	public SysModule getModule() {
		return module;
	}
	public void setModule(SysModule module) {
		this.module = module;
	}
	public PageModel<SysModuleAction> getPmm() {
		return pmm;
	}
	public void setPmm(PageModel<SysModuleAction> pmm) {
		this.pmm = pmm;
	}
	public SysModuleAction getSysModuleAction() {
		return sysModuleAction;
	}
	public void setSysModuleAction(SysModuleAction sysModuleAction) {
		this.sysModuleAction = sysModuleAction;
	}
	public PageModel<SysUser> getPms() {
		return pms;
	}
	public void setPms(PageModel<SysUser> pms) {
		this.pms = pms;
	}
	public SysUser getUsers() {
		return users;
	}
	public void setUsers(SysUser users) {
		this.users = users;
	}
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
	 * 权限
	 * 
	 */
	@Action(value="goRight", results={
			@Result(name="success",location="/SYS/Right/sys_right2.jsp")
	})
	public String rights(){
		return "success";	
	}
	/*
	 * 权限设置
	 */
	@Action(value="gosRights", results={
			@Result(name="success",location="/SYS/Right/sys_right2.jsp")
	})
	public String goRights(){
		String rights = this.getRequest().getParameter("rights");
		if(Integer.valueOf(rights)==1){
			SysUser users=getUsers();
			PageModel<SysUser> pms=new PageModel<>();
			if(getPm()!=null){
			}
			pms=sysUserService.showUser(pms,users);
			this.getSession().setAttribute("pms", pms);
			this.getSession().setAttribute("users", users);
			this.getRequest().setAttribute("rights", rights);
		}else if(Integer.valueOf(rights)==2){
			this.getRequest().setAttribute("rights", rights);
			SysRole sysRole=getSysRole();
			PageModel<SysRole> spm=new PageModel<>();
			if(getPm()!=null){
				spm=getPm();
			}
			spm=roleService.showRole(spm, sysRole);
			this.getSession().setAttribute("spm", spm);
			this.getSession().setAttribute("sysRole", sysRole);
		}
		return "success";	
	}
	
	/*
	 * 用户权限
	 */
	@Action(value="userRight", results={
			@Result(name="success",location="/SYS/Right/sys_user_right.jsp")
	})
	public String userRight(){
		return "success";
	}
	
	
	/*
	 * 角色权限
	 */
	@Action(value="roleRight", results={
			@Result(name="success",location="/SYS/Right/sys_role_right.jsp")
	})
	public String roleRight(){
		int pds=2;
		int rpd=0;
		String strpd=this.getRequest().getParameter("rpd");
		if(strpd!="" && strpd!=null){
			rpd=Integer.parseInt(strpd);
		}
		int roleIds=0;
		int id=0;
		if(rpd==2){
			String RoleID = this.getRequest().getParameter("RoleID");
			if(RoleID!=null && RoleID!=""){
				roleIds=Integer.parseInt(RoleID);
			}
			id=roleIds;
		}
		int userId=0;
		if(rpd==1){
			String struserId = this.getRequest().getParameter("UserID");
			if(struserId!=null && struserId!=""){
				userId=Integer.parseInt(struserId);
			}
			id=userId;
		}
		List<SysModule> modules=sysModuleService.getAllSysModule();
		List<SysRights> rightlist=sysRightsService.getSysRightById(rpd, id,1);					//第一个0表示角色           1表示有效的权限
		
		/*List<SysRights> rightlist=sysRightsService.getAllsysrigh();*/
		/*List<SysRights> rightlist=sysRightsService.getSysRightsByModID("001");*/
		List<Operator> oplist=new ArrayList<>();
		for (SysModule sysModule : modules) {
			List<Checkbox> cboxList=new ArrayList<Checkbox>();
			List<Radios> radiosList=new ArrayList<Radios>();
			int look=0;
			int add=0;
			int update=0;				// 改4
			int delete=0;				//删  8
			Operator op=new Operator();
			op.setMid(sysModule.getModID());
			if((Integer.parseInt(sysModule.getModUPRight()) & 1) ==1){
				look=1;
				Integer checked=0;
				int rchecked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&1)==1))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("1","查看","1",checked));
				
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 2) ==2){
				add=2;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&2)==2))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("2","增加","2",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 4) ==4){
				update=4;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&4)==4))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("4","删除","4",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 8) ==8){
				delete=8;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&8)==8))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("8","编辑","8",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 16) ==16){
				delete=8;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&16)==16))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("16","待申请","16",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 32) ==32){
				delete=8;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&32)==32))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("32","待申请","32",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 64) ==64){
				delete=8;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&64)==64))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("64","待签订","64",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 128) ==128){
				delete=8;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&128)==128))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("128","待复核","128",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 256) ==256){
				delete=8;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&256)==256))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("256","待收手续费","256",checked));
			}
			if((Integer.parseInt(sysModule.getModUPRight()) & 512) ==512){
				delete=8;
				Integer checked=0;
				for (SysRights dd : rightlist) {
					if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModCtrl()&512)==512))
					{
						checked=1;
					}
					
				}
				cboxList.add(new Checkbox("512","待放款","512",checked));
			}
			int rchecked=0;
			int rchecked2=0;
			int rchecked3=0;
			for (SysRights dd : rightlist) {
				if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModData()==1)))
				{
					rchecked=1;
				}
			}
			radiosList.add(new Radios("1", "个人权限", "1", rchecked));
			for (SysRights dd : rightlist) {
				if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModData()==2)))
				{
					rchecked2=1;
				}
			}
			radiosList.add(new Radios("2", "团队权限", "2", rchecked2));
			for (SysRights dd : rightlist) {
				if((dd.getRightsModID().equals(sysModule.getModID()))&&((dd.getRightsModData()==3)))
				{
					rchecked3=1;
				}
			}
			radiosList.add(new Radios("3", "所有权限", "3", rchecked3));
			op.setMid(sysModule.getModID());
			op.setLook(look);
			op.setAdd(add);
			op.setUpdate(update);
			op.setDelete(delete);
			op.setCheckboxList(cboxList);
			op.setRadiosList(radiosList);
			oplist.add(op);
			
			
		}
		this.getRequest().setAttribute("rightlist", rightlist);
		this.getRequest().setAttribute("modules", modules);
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("rpd", rpd);
		this.getRequest().setAttribute("oplist", oplist);
		this.getRequest().setAttribute("pds", pds);
		return "success";
	}
	
	@Action(value="AddRights", results={
			@Result(name="success",location="/SYS/Right/sys_role_right.jsp")
	})
	public String AddRights(){
		//角色id
		int rpd=0;
		String strpd=this.getRequest().getParameter("rpd");
		if(strpd!="" && strpd!=null){
			rpd=Integer.parseInt(strpd);
		}
		int roleIds=0;
		int id=0;
		if(rpd==2){
			String RoleID = this.getRequest().getParameter("id");
			if(RoleID!=null && RoleID!=""){
				roleIds=Integer.parseInt(RoleID);
			}
			id=roleIds;
		}
		int userId=0;
		if(rpd==1){
			String struserId = this.getRequest().getParameter("id");
			if(struserId!=null && struserId!=""){
				userId=Integer.parseInt(struserId);
			}
			id=userId;
		}
		//根据角色获取所有权限
		List<SysRights> rlist=sysRightsService.getSysRightById(rpd, id,3);
		List<SysModule> list=sysModuleService.getAllSysModule();
		for (SysModule sysModule : list) {
			int rightsModData=0;
			String qtnames=sysModule.getModID()+"s";
			String[] modString=this.getRequest().getParameterValues(qtnames);
			//范围权限
			String rtname=sysModule.getModID()+"r";
			String strrightsModData=this.getRequest().getParameter(rtname);
			if(strrightsModData!=null && strrightsModData!=""){
				rightsModData=Integer.parseInt(strrightsModData);
			}
			if (modString!=null && modString.length>0){
				int sum=0;
				for(int i=0;i<modString.length;i++){
					sum=sum+Integer.parseInt(modString[i]);
				}
				int pds=0;
				for (SysRights sysRights : rlist) {
				//	String RightsModID=sysRights.getRightsModID();
					if(sysRights.getRightsModID().equals(sysModule.getModID())){
						pds=1;
					}
				}
				SysRights sysRight = new SysRights();
				sysRight.setRightsModID(sysModule.getModID());
				sysRight.setRightsRoleID(roleIds);
				sysRight.setRightsUserID(userId);
				sysRight.setRightsModCtrl(sum);     //权限
				sysRight.setRightsRoleOrUser(rpd);    //角色关联0
				sysRight.setRightsModData(rightsModData); //1个人权限 2部门权限3公司权限
				sysRight.setIsRight(1);
				//加判断功能(如果modid存在，则修改，不存在则增加)
				if(pds==0){
					sysRightsService.add(sysRight);
				}else if(pds==1){ 							//修改
					sysRightsService.updateCheck(sysRight,id, rpd, sysModule.getModID());
				}
			}else{
				int pds1=0;
				for (SysRights sysRights : rlist) {
					//	String RightsModID=sysRights.getRightsModID();
					if(sysRights.getRightsModID().equals(sysModule.getModID())){
						 pds1=1;
					}
				}
				SysRights sysRight = new SysRights();
				sysRight.setRightsModID(sysModule.getModID());
				sysRight.setRightsRoleID(roleIds);
				sysRight.setRightsUserID(userId);
				sysRight.setRightsModCtrl(0);     //权限
				sysRight.setRightsRoleOrUser(rpd);    
				sysRight.setRightsModData(rightsModData); //1个人权限 2部门权限3公司权限
				sysRight.setIsRight(2);
				if(pds1==1){
					sysRightsService.updateCheck(sysRight,id, rpd, sysModule.getModID());
				}
			}
		}
		/*try {
			writeResult(true, "设置成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		int pds=1;
		this.getRequest().setAttribute("pds", pds);
		return SUCCESS;
	}
	

	
	
	
}










