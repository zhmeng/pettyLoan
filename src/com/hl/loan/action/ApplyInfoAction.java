package com.hl.loan.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.ApplyInfo;
import com.hl.loan.pojo.ComBaseData;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.pojo.Notes;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.ApplyInfoService;
import com.hl.loan.service.ComBaseDataDaoService;
import com.hl.loan.service.NoteAndUserService;
import com.hl.loan.service.NotesService;
import com.hl.loan.service.ProcedureService;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;
import com.hl.loan.vi.Procedure;

@Namespace("/action/applyInfo")
@ResultPath("/")
public class ApplyInfoAction extends BaseAction {
	private static final Log LOG = LogFactory.getLog(BaseAction.class);
	private static final long serialVersionUID = 1L;

	SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
	@Autowired
	private NotesService notesService;
	@Autowired
	private ApplyInfoService applyInfoService;
	@Autowired
	private NoteAndUserService noteAndUserService;
	@Autowired
	private ProcedureService procedureService;
	@Autowired
	private ComBaseDataDaoService comBaseDataDaoService;
	
	private ApplyInfo applyInfo;
	private PageModel<ApplyInfo> pm;

	public ApplyInfo getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(ApplyInfo applyInfo) {
		this.applyInfo = applyInfo;
	}

	public PageModel<ApplyInfo> getPm() {
		return pm;
	}

	public void setPm(PageModel<ApplyInfo> pm) {
		this.pm = pm;
	}

	@Action(value = "goApplyInfoList", results = { @Result(name = "success", location = "/apply/applyInfo_list.jsp") })
	public String goApplyInfoList() {
		List<Buttons> blist=this.getUrlRight(1);				//权限管理
		//得到数字字典
		List<ComBaseData> comList=comBaseDataDaoService.getByClass("DKZT");
		ApplyInfo applyInfo = getApplyInfo();
		PageModel<ApplyInfo> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = applyInfoService.showApplyInfo(pm, applyInfo);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("applyInfo", applyInfo);
		this.getRequest().setAttribute("blist", blist);
		this.getRequest().setAttribute("comList", comList);
		return "success";
	}

	@Action(value = "toAddApplyInfo", results = { @Result(name = "success", location = "/apply/applyInfo_add.jsp") })
	public String toAddApplyInfo() {
		return "success";
	}

	@Action(value = "addApplyInfo")
	public void addApplyInfo() {
		String applyCode = this.getRequest().getParameter("applyCode");
		try {
			ApplyInfo applyInfo = new ApplyInfo();
			applyInfo.setApplyCode(applyCode);
			applyInfoService.addApplyInfo(applyInfo);
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Action(value = "delApplyInfo")
	public void delApplyInfo() {
		String applyID = this.getRequest().getParameter("applyID");
		try {
			int result = applyInfoService.delApplyInfo(applyID);
			if (result == 1) {
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Action(value = "toUpdateApplyInfo", results = { @Result(name = "success", location = "/apply/product_update.jsp") })
	public String toUpdateApplyInfo() {
		String applyID = this.getRequest().getParameter("applyID");
		ApplyInfo applyInfo = applyInfoService.getApplyInfoByID(applyID);
		this.getRequest().setAttribute("applyInfo", applyInfo);
		return "success";
	}

	@Action(value = "updateApplyInfo")
	public void updateProduct() {
		String applyID = this.getRequest().getParameter("applyID");
		String applyCode = this.getRequest().getParameter("applyCode");
		
		try {
			ApplyInfo applyInfo = applyInfoService.getApplyInfoByID(applyID);
			applyInfo.setApplyCode(applyCode);
			applyInfoService.updateApplyInfo(applyInfo);
			writeResult(true, "修改成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//获取申请流程申请单
	@Action(value = "showOa", results = { @Result(name = "success", location = "/apply/oa/showOa.jsp") })
	public String showOa() {
		try {
			SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
			int userId=sysUser.getUserID();
			String exClas=this.getRequest().getParameter("exClas");
			//得到自己审批的流程节点
			List<NoteAndUser> ntlist=noteAndUserService.getNoteByUser(userId);
			//根据流程得到需要的审批
			PageModel<ApplyInfo> pm = new PageModel<>();
			//得到数字字典
			List<ComBaseData> comList=comBaseDataDaoService.getByClass("DKZT");
			String statused=this.getRequest().getParameter("statused");
			ApplyInfo applyInfo=new ApplyInfo();
			if(getPm()!=null){
				pm=getPm();
			}
			if(getApplyInfo()!=null){
				applyInfo=getApplyInfo();
			}
			if(statused!=null && statused.trim().length()>0){
				applyInfo.setStatus(Integer.parseInt(statused));
			}
			if(exClas==null || exClas==""){
				exClas="2";
				pm=applyInfoService.showApplyOaInfo(pm, ntlist, userId, applyInfo);
			}else{
				if(exClas=="1" || exClas.equals("1")){
					//查询所有
					pm=applyInfoService.showApplyInfo(pm, applyInfo);
					//得到我的审批
					List<ApplyInfo> appList=applyInfoService.getAllMyOa(ntlist, userId, applyInfo);
					this.getRequest().setAttribute("appList", appList);
				}else if(exClas=="2" || exClas.equals("2")){
					//查询审批
					pm=applyInfoService.showApplyOaInfo(pm, ntlist, userId, applyInfo);
				}
			}
			this.getRequest().setAttribute("statused", statused);
			this.getRequest().setAttribute("exClas", exClas);
			this.getRequest().setAttribute("comList", comList);
			this.pm=pm;
			this.applyInfo=applyInfo;
		} catch (Exception e) {
			// TODO: handle exception
			LOG.debug(e.getMessage());
		}
		
		return SUCCESS;
	}
	//去审批页面
	@Action(value = "toOa", results = { @Result(name = "success", location = "/apply/oa/approve.jsp"),
									@Result(name="exist",location="/apply/oa/exist.jsp")})
	public String toOa() {
		int status=0;
		String applyID=this.getRequest().getParameter("applyID");
		String strstatus=this.getRequest().getParameter("status");
		if(strstatus!=null && strstatus.trim().length()>0){
			status=Integer.parseInt(strstatus);
		}else{
			return "exist";
		}
		ApplyInfo applyInfo=applyInfoService.load(applyID);
		int dstatus=applyInfo.getStatus();
		if(status!=dstatus){
			return "exist";
		}
		List<Notes> ntList=null;
		if(applyID!=null && applyID.trim().length()>0){
			 ntList=notesService.getOaNotes(Long.parseLong(applyID), 201);
		}
		//得到数字字典
		List<ComBaseData> comList=comBaseDataDaoService.getByClass("DKZT");
		this.applyInfo=applyInfo;
		this.getRequest().setAttribute("comList", comList);
		this.getRequest().setAttribute("ntList", ntList);
		return SUCCESS;
	}
	@Action(value = "examineOa", results = { @Result(name = "success", location = "/apply/oa/approve.jsp") })
	public String examineOa() throws IOException {
		SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
		int userId=sysUser.getUserID();
		String pd="0";
		String strExamines=this.getRequest().getParameter("examines");
		String strapplyId=this.getRequest().getParameter("applyID");
		String strstatus=this.getRequest().getParameter("status");
		String strbigAmount=this.getRequest().getParameter("bigAmount");
		String stramount=this.getRequest().getParameter("amount");
		String strloanTime=this.getRequest().getParameter("loanTime");
		String strrate=this.getRequest().getParameter("rate");
		String pl=this.getRequest().getParameter("pl");
		Long applyId=(long) 0;
		int examines=0;
		int status=0;
		if(strExamines!=null && strExamines.trim().length()>0){
			examines=Integer.parseInt(strExamines);
		}
		if(strapplyId!=null && strapplyId.trim().length()>0){
			applyId=Long.parseLong(strapplyId);
		}
		if(strstatus!=null && strstatus.trim().length()>0){
			status=Integer.parseInt(strstatus);
		}
		int laststatus=notesService.getlastNote(applyId);
		if(laststatus==status){
			pd="2";
		}else{
			try {
				Procedure proc=new Procedure(userId, applyId, examines, 201, 203,pl, 3, 201);
				procedureService.processOa(proc);
				int pds=0;
				//得到
				ApplyInfo applys=applyInfoService.load(strapplyId);
				if(stramount!=null && !stramount.equals("")){
					BigDecimal amount=new BigDecimal(stramount);
					applys.setAmount(amount);
					applys.setBigAmount(strbigAmount);
					pds=1;
				}
				if(strloanTime!=null && !strloanTime.equals("")){
					applys.setLoanTime(Integer.parseInt(strloanTime));
					pds=1;
				}
				if(strrate!=null && !strrate.equals("")){
					BigDecimal rate=new BigDecimal(strrate);
					applys.setRate(rate);
					pds=1;
				}
				if(pds==1){                                                  //修改
					applyInfoService.updateApplyInfo(applys);
				}
				pd="1";
			} catch (Exception e) {
				// TODO: handle exception
				LOG.debug(e.getMessage());
			}
		}
		this.writeResult(true, pd, this.getResponse());
		return null;
	}
}







