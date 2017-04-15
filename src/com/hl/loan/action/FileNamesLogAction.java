package com.hl.loan.action;

import com.hl.loan.pojo.FileNames;
import com.hl.loan.pojo.FileNamesLog;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.DeptService;
import com.hl.loan.service.FileNamesLogService;
import com.hl.loan.service.FileNamesService;
import com.hl.loan.service.SysUserService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.TotalSum;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/action/fileNamesLog")
@ResultPath("/")
public class FileNamesLogAction extends BaseAction
{

  @Autowired
  private FileNamesLogService fileNamesLogService;

  @Autowired
  private DeptService deptService;

  @Autowired
  private FileNamesService fileNamesService;
  

  @Autowired
  private SysUserService sysUserService;
  private PageModel<FileNamesLog> pm;
  private FileNamesLog fileNamesLog;
  private Long id;
  private Integer zt;

  public Integer getZt()
  {
    return this.zt;
  }

  public void setZt(Integer zt) {
    this.zt = zt;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PageModel<FileNamesLog> getPm() {
    return this.pm;
  }

  public void setPm(PageModel<FileNamesLog> pm) {
    this.pm = pm;
  }

  public FileNamesLog getFileNamesLog() {
    return this.fileNamesLog;
  }

  public void setFileNamesLog(FileNamesLog fileNamesLog) {
    this.fileNamesLog = fileNamesLog;
  }

  @Action(value="showFileNamesLog", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/fileNameLog/fileNameLog_list.jsp")})
  public String showFileNamesLog()
    throws IOException
  {
	  FileNamesLog fileNamesLog = getFileNamesLog();
	  List userList = this.sysUserService.getAllUser();
	  PageModel pm = new PageModel();
	  if (getPm() != null) {
		  pm = getPm();
	  }
	  pm = this.fileNamesLogService.showFiles(pm, fileNamesLog);
	  getRequest().setAttribute("pm", pm);
	  getRequest().setAttribute("userList", userList);
	  getRequest().setAttribute("fileNamesLog", fileNamesLog);
	  return "success";
  }

  @Action(value="lookFilesLog", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/fileNameLog/fileNameLog_look.jsp")})
  public String lookFilesLog()
  {
    Long id = getId();
    List deptList = this.deptService.getAllDept();
    List userList = this.sysUserService.getAllUser();
    /*List listFile = this.fileNamesService.getAllFileNames();*/
    FileNamesLog fileNamesLog = this.fileNamesLogService.getFileNamesLogByID(id);
    String lastName="";
	if(id!=null){
		FileNames lastfileNames = fileNamesService.getFileNamesByID(id);
		if(lastfileNames!=null){
			lastName=lastfileNames.getCompnyName();
		}
	}
    getRequest().setAttribute("deptList", deptList);
    getRequest().setAttribute("userList", userList);
    /*getRequest().setAttribute("listFile", listFile);*/
    getRequest().setAttribute("fileNames", fileNamesLog);
    getRequest().setAttribute("lastName", lastName);
    return "success";
  }
  
  @Action(value="fileNameTatol", results={@org.apache.struts2.convention.annotation.Result(name="success", location="/fileNameLog/fileNameTatol_list.jsp")})
  public String fileNameTatol()
  {
	  PageModel pm = new PageModel();
	  if (getPm() != null) {
		  pm = getPm();
	  }
	  FileNamesLog fileNamesLog = getFileNamesLog();
	  Date dt=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
	  String strdt=sdf.format(dt);
	/*  if(fileNamesLog==null){
		  fileNamesl.setFbak1(sdf.format(dt));
	  }else{
		  if(fileNamesLog.getFbak1()==null){
			  fileNamesl.setFbak1(sdf.format(dt));
		  }else{
			  fileNamesl.setFbak1(fileNamesLog.getFbak1().trim());
		  }
		  if(fileNamesLog.getUserId()!=null){
			  fileNamesl.setUserId(fileNamesLog.getUserId());
		  }
	  }*/
	  //得到总数
	  pm =fileNamesLogService.sumFile(pm,fileNamesLog);
	  List<SysUser> userList=sysUserService.getAllUser();
	  getRequest().setAttribute("fileNamesLog", fileNamesLog);
	  getRequest().setAttribute("pm", pm);
	  getRequest().setAttribute("userList", userList);
	  return "success";
  }
  @Action("exam")
  public void exam()
    throws ParseException
  {
	try {
	SysUser user = (SysUser) getSession().getAttribute("user");
	if ((user == null) || !(user.getUserName().equals("admin"))) {
		 writeResult(true, "您没有审批权限！", getResponse());
	}else{
		Long id = getId();
		Integer zt = getZt();
		if (zt != null) {
        FileNamesLog fileNamesLog = new FileNamesLog();
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = sdf.parse(sdf.format(dt));
        if (zt.intValue() == 1) {
          fileNamesLog = this.fileNamesLogService.getFileNamesLogByID(id);
          this.fileNamesLogService.updateFileLogs(id, 2, time);

          this.fileNamesService.updateFile(fileNamesLog.getFileId(), 2, time,0);
        } else {
          FileNames fileNames = new FileNames();
          fileNamesLog = this.fileNamesLogService.getFileNamesLogByID(id);
          System.out.println("================="+fileNamesLog.getFileId());
          if (fileNamesLog.getFmonily().intValue() == 1) {
        	  fileNames.setId(fileNamesLog.getFileId());
              fileNames.setZipCode(fileNamesLog.getZipCode());
              fileNames.setAddress(fileNamesLog.getAddress());
              fileNames.setCompnyName(fileNamesLog.getCompnyName());
              fileNames.setDepartment(fileNamesLog.getDepartment());
              fileNames.setLinkmn(fileNamesLog.getLinkmn());
              fileNames.setSex(fileNamesLog.getSex());
              fileNames.setPost(fileNamesLog.getPost());
              fileNames.setOfficePhone(fileNamesLog.getOfficePhone());
              fileNames.setPhone(fileNamesLog.getPhone());
              fileNames.setQq(fileNamesLog.getQq());
              fileNames.setEmail(fileNamesLog.getEmail());
              fileNames.setFimallyPhone(fileNamesLog.getFimallyPhone());
              fileNames.setBirthday(fileNamesLog.getBirthday());
              fileNames.setRemark(fileNamesLog.getRemark());
              fileNames.setUrl(fileNamesLog.getUrl());
              fileNames.setFbak1(fileNamesLog.getFbak1());
              fileNames.setFbak2(fileNamesLog.getFbak2());
              fileNames.setPid(fileNamesLog.getPid());
              fileNames.setCompClass(fileNamesLog.getCompClass());
              fileNames.setAddTime(fileNamesLog.getAddTime());
              fileNames.setChangeTime(time);
              fileNames.setFmonily(Integer.valueOf(2));
              fileNames.setFstate(Integer.valueOf(2));
              this.fileNamesService.updateAll(fileNames);
          } else if (fileNamesLog.getFmonily().intValue() == 2) {
            this.fileNamesService.updateFile(fileNamesLog.getFileId(), 2, time,1);
          } else if (fileNamesLog.getFmonily().intValue() == 3) {
            List logList = this.fileNamesLogService.showByFileID(fileNamesLog.getFileId());
            if (logList != null) {
              if (logList.size() >= 2)
                fileNamesLog = (FileNamesLog)logList.get(1);
              else
                fileNamesLog = this.fileNamesLogService.getFileNamesLogByID(id);
            }
            else {
              fileNamesLog = this.fileNamesLogService.getFileNamesLogByID(id);
            }
            fileNames.setId(fileNamesLog.getFileId());
            fileNames.setZipCode(fileNamesLog.getZipCode());
            fileNames.setAddress(fileNamesLog.getAddress());
            fileNames.setCompnyName(fileNamesLog.getCompnyName());
            fileNames.setDepartment(fileNamesLog.getDepartment());
            fileNames.setLinkmn(fileNamesLog.getLinkmn());
            fileNames.setSex(fileNamesLog.getSex());
            fileNames.setPost(fileNamesLog.getPost());
            fileNames.setOfficePhone(fileNamesLog.getOfficePhone());
            fileNames.setPhone(fileNamesLog.getPhone());
            fileNames.setQq(fileNamesLog.getQq());
            fileNames.setEmail(fileNamesLog.getEmail());
            fileNames.setFimallyPhone(fileNamesLog.getFimallyPhone());
            fileNames.setBirthday(fileNamesLog.getBirthday());
            fileNames.setRemark(fileNamesLog.getRemark());
            fileNames.setUrl(fileNamesLog.getUrl());
            fileNames.setFbak1(fileNamesLog.getFbak1());
            fileNames.setFbak2(fileNamesLog.getFbak2());
            fileNames.setPid(fileNamesLog.getPid());
            fileNames.setCompClass(fileNamesLog.getCompClass());
            fileNames.setAddTime(fileNamesLog.getAddTime());
            fileNames.setChangeTime(time);
            fileNames.setFstate(fileNamesLog.getFstate());
            fileNames.setFmonily(fileNamesLog.getFmonily());
            fileNamesLog.setChangeTime(time);
            this.fileNamesService.updateAll(fileNames);
          }
          this.fileNamesLogService.updateFileLogs(id, 3, time);
        }
        writeResult(true, "审核成功！", getResponse());
      }
	}
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  @Action("examall")
  public void examall() throws ParseException
  {
	  try {
		  SysUser user = (SysUser) getSession().getAttribute("user");
		  if ((user == null) || !(user.getUserName().equals("admin"))) {
				 writeResult(true, "您没有审批权限！", getResponse());
		  }else{
		  FileNames fileNames=new FileNames();
		  FileNamesLog fileNamesLog=new FileNamesLog();
		  String compnyName=this.getRequest().getParameter("compnyName");
		  fileNames.setCompnyName(compnyName);
		  fileNamesLog.setCompnyName(compnyName);
		  String department=this.getRequest().getParameter("department");
		  fileNames.setDepartment(department);
		  fileNamesLog.setDepartment(department);
		  String linkmn=this.getRequest().getParameter("linkmn");
		  fileNames.setLinkmn(linkmn);
		  fileNamesLog.setLinkmn(linkmn);
		  String address=this.getRequest().getParameter("address");
		  fileNames.setAddress(address);
		  fileNamesLog.setAddress(address);
		  String fmonily=this.getRequest().getParameter("fmonily");
		  if(fmonily!=null && fmonily.length()>0){
			  fileNames.setFmonily(Integer.parseInt(fmonily));
			  fileNamesLog.setFmonily(Integer.parseInt(fmonily));
		  }
		  String fstate=this.getRequest().getParameter("fstate");
		  if(fstate!=null && fstate.length()>0){
			  fileNames.setFstate(Integer.parseInt(fstate));
			  fileNamesLog.setFstate(Integer.parseInt(fstate));
		  }
		  String fbak1=this.getRequest().getParameter("fbak1");
		  fileNames.setFbak1(fbak1);
		  fileNamesLog.setFbak1(fbak1);
		  Date dt = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      String strtime = sdf.format(dt);
	      /*fileNames.setChangeTime(time);
	      fileNamesLog.setChangeTime(time);*/
	      fileNames.setFbak2(strtime);
	      fileNamesLog.setFbak2(strtime);
	      fileNamesLogService.updateAllExamLog(fileNamesLog);
	      fileNamesService.updateAllExam(fileNames);
	      
	      writeResult(true, "批量审核成功！", getResponse());
		  }
	  } catch (Exception e) {
		// TODO: handle exception
	  }
  }
}
  
  














  
  
