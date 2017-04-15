package com.hl.loan.action;

import com.hl.loan.pio.ExcelReader;
import com.hl.loan.pojo.Excel;
import com.hl.loan.pojo.FileNames;
import com.hl.loan.pojo.FileNamesLog;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.DeptService;
import com.hl.loan.service.FileNamesLogService;
import com.hl.loan.service.FileNamesService;
import com.hl.loan.service.SysUserService;
import com.hl.loan.util.PageModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

@Namespace("/action/fileNames")
@ResultPath("/")
public class FileNamesAction extends BaseAction {

	@Autowired
	private FileNamesService fileNamesService;

	@Autowired
	private FileNamesLogService fileNamesLogService;

	@Autowired
	private DeptService deptService;
	
	@Autowired
	private SysUserService sysUserService;
	private InputStream excelFile;
	private File uploadFile;
	private FileNames fileNames;
	private PageModel<FileNames> pm;
	private FileNamesLog fileNamesLog;
	private File files;
	private String fileName;
	private String uploadFileFileName;
	private Long id;
	private String compClasses;
	
	public String getCompClasses() {
		return compClasses;
	}

	public void setCompClasses(String compClasses) {
		this.compClasses = compClasses;
	}

	public String getUploadFileFileName() {
		return this.uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public File getUploadFile() {
		return this.uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public File getFiles() {
		return this.files;
	}

	public void setFile(File files) {
		this.files = files;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FileNames getFileNames() {
		return this.fileNames;
	}

	public void setFileNames(FileNames fileNames) {
		this.fileNames = fileNames;
	}

	public PageModel<FileNames> getPm() {
		return this.pm;
	}

	public void setPm(PageModel<FileNames> pm) {
		this.pm = pm;
	}

	public FileNamesLog getFileNamesLog() {
		return this.fileNamesLog;
	}

	public void setFileNamesLog(FileNamesLog fileNamesLog) {
		this.fileNamesLog = fileNamesLog;
	}

	@Action(value = "showFileNames", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/fileName_list.jsp") })
	public String showFileNames() throws IOException {
		HttpServletRequest request = getRequest();
		HttpSession session = request.getSession();

		List<SysUser> userList = sysUserService.getAllUser();
		FileNames fileNames = getFileNames();
		PageModel<FileNames> pm = new PageModel<FileNames>();
		SysUser user = (SysUser) session.getAttribute("user");
		String userName = user.getUserName();
		List deptList = this.deptService.getAllDept();
		String depId = "";

		if (getPm() != null) {
			pm = getPm();
		}
		pm = this.fileNamesService.showFiles(pm, fileNames, depId);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("deptList", deptList);
		this.getRequest().setAttribute("fileNames", fileNames);

		this.getRequest().setAttribute("userList", userList);
		return "success";
	}

	@Action(value = "toAddfileName", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/fileName_add.jsp") })
	public String toAddfileName() {
		HttpSession session = getSession();
		SysUser user = (SysUser) session.getAttribute("user");

		List<SysDept> sysDepList = deptService.getAllDept();
		/*List<FileNames> listFile = fileNamesService.getAllFileNames();*/
		getRequest().setAttribute("sysDepList", sysDepList);
		/*getRequest().setAttribute("listFile", listFile);*/
		return "success";
	}

	@Action("addfileName")
	public void addfileName() throws ParseException {
		SysUser sysUsers = (SysUser) getRequest().getSession().getAttribute(
				"user");
		String zipCode = getRequest().getParameter("zipCode");
		String address = getRequest().getParameter("address");
		String compnyName = getRequest().getParameter("compnyName");
		String department = getRequest().getParameter("department");
		String linkmn = getRequest().getParameter("linkmn");
		String sex = getRequest().getParameter("sex");
		String post = getRequest().getParameter("post");
		String officePhone = getRequest().getParameter("officePhone");
		String phone = getRequest().getParameter("phone");
		String qq = getRequest().getParameter("qq");
		String email = getRequest().getParameter("email");
		String url = getRequest().getParameter("url");
		String remark = getRequest().getParameter("remark");
		String fimallyPhone = getRequest().getParameter("fimallyPhone");
		String birthday = getRequest().getParameter("birthday");
		String pid = getRequest().getParameter("pid");
		Long pids = null;
		if ((pid != null) && (pid.length() > 0)) {
			pids = Long.valueOf(Long.parseLong(pid));
		}
		String compClass = getRequest().getParameter("compClass");
		try {
			FileNames fileNames = new FileNames();
			FileNamesLog fileNamesLog = new FileNamesLog();
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = sdf.parse(sdf.format(dt));
			fileNames.setZipCode(zipCode);
			fileNames.setAddress(address);
			fileNames.setCompnyName(compnyName);
			fileNames.setDepartment(department);
			fileNames.setLinkmn(linkmn);
			fileNames.setSex(sex);
			fileNames.setPost(post);
			fileNames.setOfficePhone(officePhone);
			fileNames.setPhone(phone);
			fileNames.setQq(qq);
			fileNames.setEmail(email);
			fileNames.setFimallyPhone(fimallyPhone);
			fileNames.setBirthday(birthday);
			fileNames.setPid(pids);
			fileNames.setCompClass(compClass);
			fileNames.setAddTime(time);
			fileNames.setChangeTime(time);
			fileNames.setRemark(remark);
			fileNames.setUrl(url);
			fileNames.setUserId(sysUsers.getUserID());
			fileNames.setFmonily(Integer.valueOf(1));
			fileNames.setFstate(Integer.valueOf(1));
			fileNames = this.fileNamesService.addFilesName(fileNames);

			fileNamesLog.setZipCode(zipCode);
			fileNamesLog.setAddress(address);
			fileNamesLog.setCompnyName(compnyName);
			fileNamesLog.setDepartment(department);
			fileNamesLog.setLinkmn(linkmn);
			fileNamesLog.setSex(sex);
			fileNamesLog.setPost(post);
			fileNamesLog.setOfficePhone(officePhone);
			fileNamesLog.setPhone(phone);
			fileNamesLog.setQq(qq);
			fileNamesLog.setEmail(email);
			fileNamesLog.setFimallyPhone(fimallyPhone);
			fileNamesLog.setBirthday(birthday);
			fileNamesLog.setPid(pids);
			fileNamesLog.setCompClass(compClass);
			fileNamesLog.setAddTime(time);
			fileNamesLog.setChangeTime(time);
			fileNamesLog.setRemark(remark);
			fileNamesLog.setUrl(url);
			fileNamesLog.setFmonily(Integer.valueOf(1));
			fileNamesLog.setFstate(Integer.valueOf(1));
			fileNamesLog.setFileId(fileNames.getId());
			fileNamesLog.setUserId(sysUsers.getUserID());
			fileNamesLogService.addFilesName(fileNamesLog);
			writeResult(true, "保存成功！", getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Action(value = "lookFiles", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/fileName_look.jsp") })
	public String lookFiles() {
		Long id = getId();
		List<SysDept> deptList = deptService.getAllDept();
		FileNames fileNames = fileNamesService.getFileNamesByID(id);
		Long pid=fileNames.getPid();
		String lastName="";
		if(pid!=null){
			FileNames lastfileNames = fileNamesService.getFileNamesByID(pid);
			if(lastfileNames!=null){
				lastName=lastfileNames.getCompnyName();
			}
		}
		List<SysUser> userList = sysUserService.getAllUser();
		/*List<FileNames> listFile = fileNamesService.getAllFileNames();*/
		List<Excel> excelList = fileNamesService.getExcel(id,1);
		this.getRequest().setAttribute("deptList", deptList);
		this.getRequest().setAttribute("userList", userList);
		this.getRequest().setAttribute("fileNames", fileNames);
		this.getRequest().setAttribute("lastName", lastName);
		this.getRequest().setAttribute("excelList", excelList);
		return "success";
	}

	@Action(value = "toUpdate", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/fileName_update.jsp") })
	public String toUpdate() {
		Long id = getId();
		FileNames fileNames = this.fileNamesService.getFileNamesByID(id);
		Long pid=fileNames.getPid();
		String lastName="";
		if(pid!=null){
			FileNames lastfileNames = fileNamesService.getFileNamesByID(pid);
			lastName=lastfileNames.getCompnyName();
		}
		List<SysDept> deptList = deptService.getAllDept();
		/*List<FileNames> listFile = this.fileNamesService.getAllFileNames();*/
		this.getRequest().setAttribute("deptList", deptList);
		this.getRequest().setAttribute("lastName", lastName);
		this.getRequest().setAttribute("fileNames", fileNames);
		return "success";
	}
	
	@Action(value = "toUpdate2", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/fileName_update2.jsp") })
	public String toUpdate2() {
		Long id = getId();
		FileNames fileNames = this.fileNamesService.getFileNamesByID(id);
		Long pid=fileNames.getPid();
		String lastName="";
		if(pid!=null){
			FileNames lastfileNames = fileNamesService.getFileNamesByID(pid);
			lastName=lastfileNames.getCompnyName();
		}
		List<SysDept> deptList = deptService.getAllDept();
		/*List<FileNames> listFile = this.fileNamesService.getAllFileNames();*/
		this.getRequest().setAttribute("deptList", deptList);
		this.getRequest().setAttribute("lastName", lastName);
		this.getRequest().setAttribute("fileNames", fileNames);
		return "success";
	}

	@Action("updateFiles")
	public void updateFiles() throws ParseException {
		SysUser sysUsers = (SysUser) getRequest().getSession().getAttribute(
				"user");
		String sid = getRequest().getParameter("id");
		Long id = Long.valueOf(0L);
		if ((sid != null) && (sid.length() > 0)) {
			id = Long.valueOf(Long.parseLong(sid));
		}
		String zipCode = getRequest().getParameter("zipCode");
		String address = getRequest().getParameter("address");
		String compnyName = getRequest().getParameter("compnyName");
		String department = getRequest().getParameter("department");
		String linkmn = getRequest().getParameter("linkmn");
		String sex = getRequest().getParameter("sex");
		String post = getRequest().getParameter("post");
		String officePhone = getRequest().getParameter("officePhone");
		String phone = getRequest().getParameter("phone");
		String qq = getRequest().getParameter("qq");
		String email = getRequest().getParameter("email");
		String url = getRequest().getParameter("url");
		String remark = getRequest().getParameter("remark");

		String fimallyPhone = getRequest().getParameter("fimallyPhone");
		String birthday = getRequest().getParameter("birthday");
		String pid = getRequest().getParameter("pid");
		Long pids = null;
		if ((pid != null) && (pid.length() > 0)) {
			pids = Long.valueOf(Long.parseLong(pid));
		}
		String compClass = getRequest().getParameter("compClass");
		try {
			FileNames fileNames = new FileNames();
			FileNamesLog fileNamesLog = new FileNamesLog();
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = sdf.parse(sdf.format(dt));
			fileNames.setId(id);
			fileNames.setZipCode(zipCode);
			fileNames.setAddress(address);
			fileNames.setCompnyName(compnyName);
			fileNames.setDepartment(department);
			fileNames.setLinkmn(linkmn);
			fileNames.setSex(sex);
			fileNames.setPost(post);
			fileNames.setOfficePhone(officePhone);
			fileNames.setPhone(phone);
			fileNames.setQq(qq);
			fileNames.setEmail(email);
			fileNames.setFimallyPhone(fimallyPhone);
			fileNames.setBirthday(birthday);
			fileNames.setPid(pids);
			fileNames.setCompClass(compClass);
			fileNames.setAddTime(time);
			fileNames.setChangeTime(time);
			fileNames.setRemark(remark);
			fileNames.setUrl(url);
			fileNames.setFmonily(Integer.valueOf(3));
			fileNames.setFstate(Integer.valueOf(1));
			fileNames.setUserId(sysUsers.getUserID());
			//fileNames.setIsdelete("y");
			fileNamesService.updateAll(fileNames);

			fileNamesLog.setZipCode(zipCode);
			fileNamesLog.setAddress(address);
			fileNamesLog.setCompnyName(compnyName);
			fileNamesLog.setDepartment(department);
			fileNamesLog.setLinkmn(linkmn);
			fileNamesLog.setSex(sex);
			fileNamesLog.setPost(post);
			fileNamesLog.setOfficePhone(officePhone);
			fileNamesLog.setPhone(phone);
			fileNamesLog.setQq(qq);
			fileNamesLog.setEmail(email);
			fileNamesLog.setFimallyPhone(fimallyPhone);
			fileNamesLog.setBirthday(birthday);
			fileNamesLog.setPid(pids);
			fileNamesLog.setCompClass(compClass);
			fileNamesLog.setAddTime(time);
			fileNamesLog.setChangeTime(time);
			fileNamesLog.setRemark(remark);
			fileNamesLog.setUrl(url);
			fileNamesLog.setFmonily(Integer.valueOf(3));
			fileNamesLog.setFstate(Integer.valueOf(1));
			fileNamesLog.setFileId(id);
			fileNamesLog.setUserId(sysUsers.getUserID());
			fileNamesLogService.addFilesName(fileNamesLog);
			writeResult(true, "修改成功！", getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Action("updateFiles2")
	public void updateFiles2() throws ParseException {
		SysUser sysUsers = (SysUser) getRequest().getSession().getAttribute("user");
		Integer userId=sysUsers.getUserID();
		String sid = getRequest().getParameter("id");
		Long id = Long.valueOf(0L);
		if ((sid != null) && (sid.length() > 0)) {
			id = Long.valueOf(Long.parseLong(sid));
		}
		String zipCode = getRequest().getParameter("zipCode");
		String address = getRequest().getParameter("address");
		String compnyName = getRequest().getParameter("compnyName");
		String department = getRequest().getParameter("department");
		String linkmn = getRequest().getParameter("linkmn");
		String sex = getRequest().getParameter("sex");
		String post = getRequest().getParameter("post");
		String officePhone = getRequest().getParameter("officePhone");
		String phone = getRequest().getParameter("phone");
		String qq = getRequest().getParameter("qq");
		String email = getRequest().getParameter("email");
		String url = getRequest().getParameter("url");
		String remark = getRequest().getParameter("remark");

		String fimallyPhone = getRequest().getParameter("fimallyPhone");
		String birthday = getRequest().getParameter("birthday");
		String pid = getRequest().getParameter("pid");
		Long pids = null;
		if ((pid != null) && (pid.length() > 0)) {
			pids = Long.valueOf(Long.parseLong(pid));
		}
		String compClass = getRequest().getParameter("compClass");
		try {
			FileNames fileNames = new FileNames();
			FileNamesLog fileNamesLogs = new FileNamesLog();
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = sdf.parse(sdf.format(dt));
			fileNames.setId(id);
			fileNames.setZipCode(zipCode);
			fileNames.setAddress(address);
			fileNames.setCompnyName(compnyName);
			fileNames.setDepartment(department);
			fileNames.setLinkmn(linkmn);
			fileNames.setSex(sex);
			fileNames.setPost(post);
			fileNames.setOfficePhone(officePhone);
			fileNames.setPhone(phone);
			fileNames.setQq(qq);
			fileNames.setEmail(email);
			fileNames.setFimallyPhone(fimallyPhone);
			fileNames.setBirthday(birthday);
			fileNames.setPid(pids);
			fileNames.setCompClass(compClass);
			fileNames.setAddTime(time);
			fileNames.setChangeTime(time);
			fileNames.setRemark(remark);
			fileNames.setUrl(url);
			fileNames.setFmonily(Integer.valueOf(3));
			fileNames.setFstate(Integer.valueOf(1));
			fileNames.setUserId(sysUsers.getUserID());
			//fileNames.setIsdelete("y");
			fileNamesLogs.setFileId(id);
			fileNamesLogs.setFstate(1);
			List<FileNamesLog> fileNamesLogList=fileNamesLogService.lookLog(fileNamesLogs);
			if(fileNamesLogList!=null && fileNamesLogList.size()>0){
				fileNamesService.updateAll(fileNames);
				FileNamesLog fileNamesLog=fileNamesLogList.get(0);
				Integer usid=fileNamesLog.getUserId();
				if(usid.equals(userId)){
					fileNamesLog.setZipCode(zipCode);
					fileNamesLog.setAddress(address);
					fileNamesLog.setCompnyName(compnyName);
					fileNamesLog.setDepartment(department);
					fileNamesLog.setLinkmn(linkmn);
					fileNamesLog.setSex(sex);
					fileNamesLog.setPost(post);
					fileNamesLog.setOfficePhone(officePhone);
					fileNamesLog.setPhone(phone);
					fileNamesLog.setQq(qq);
					fileNamesLog.setEmail(email);
					fileNamesLog.setFimallyPhone(fimallyPhone);
					fileNamesLog.setBirthday(birthday);
					fileNamesLog.setPid(pids);
					fileNamesLog.setCompClass(compClass);
					fileNamesLog.setAddTime(time);
					fileNamesLog.setChangeTime(time);
					fileNamesLog.setRemark(remark);
					fileNamesLog.setUrl(url);
					fileNamesLog.setFmonily(Integer.valueOf(3));
					fileNamesLog.setFstate(Integer.valueOf(1));
					fileNamesLog.setFileId(id);
					fileNamesLog.setUserId(sysUsers.getUserID());
					fileNamesLogService.updateAllLog(fileNamesLog);
					writeResult(true, "修改成功！", getResponse());
				}else{
					writeResult(true, "您没有修改权限！", getResponse());
				}
			}else{
				writeResult(true, "修改失败！", getResponse());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Action(value = "todel", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/fileName_delete.jsp")})
	public String todel() {
		try {
			String strid=this.getRequest().getParameter("id");
			//String compnyName=URLDecoder.decode(this.getRequest().getParameter("compnyName"),"utf-8");
			this.getRequest().setAttribute("id", strid);
			//this.getRequest().setAttribute("compnyName", compnyName);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Action("delFile")
	public void delFile() throws ParseException {
		try {
			SysUser sysUsers = (SysUser) getRequest().getSession()
					.getAttribute("user");
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String remark=this.getRequest().getParameter("remark");
			Date time = sdf.parse(sdf.format(dt));
			Long id = getId();
			FileNames fileNames = fileNamesService.getFileNamesByID(id);
			fileNames.setFmonily(Integer.valueOf(2));
			fileNames.setFstate(Integer.valueOf(1));
			fileNames.setRemark(remark);
			fileNamesService.updateAll(fileNames);

			FileNamesLog fileNamesLog = new FileNamesLog();
			fileNamesLog.setZipCode(fileNames.getZipCode());
			fileNamesLog.setAddress(fileNames.getAddress());
			fileNamesLog.setCompnyName(fileNames.getCompnyName());
			fileNamesLog.setDepartment(fileNames.getDepartment());
			fileNamesLog.setLinkmn(fileNames.getLinkmn());
			fileNamesLog.setSex(fileNames.getSex());
			fileNamesLog.setPost(fileNames.getPost());
			fileNamesLog.setOfficePhone(fileNames.getOfficePhone());
			fileNamesLog.setPhone(fileNames.getPhone());
			fileNamesLog.setQq(fileNames.getQq());
			fileNamesLog.setEmail(fileNames.getEmail());
			fileNamesLog.setFimallyPhone(fileNames.getFimallyPhone());
			fileNamesLog.setBirthday(fileNames.getBirthday());
			fileNamesLog.setPid(fileNames.getId());
			fileNamesLog.setCompClass(fileNames.getCompClass());
			fileNamesLog.setAddTime(fileNames.getAddTime());
			fileNamesLog.setChangeTime(time);
			fileNamesLog.setFmonily(Integer.valueOf(2));
			fileNamesLog.setFstate(Integer.valueOf(1));
			fileNamesLog.setFileId(id);
			fileNamesLog.setUserId(sysUsers.getUserID());
			fileNamesLog.setRemark(remark);
			fileNamesLogService.addFilesName(fileNamesLog);
			writeResult(true, "删除成功！", getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Action(value = "toUpExcel", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/upExcel.jsp") })
	public String toUpExcel() {
		List<SysDept> deptList = deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		return "success";
	}

	@Action(value = "upload", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/upExcel.jsp") })
	public String upload() {
		SysUser user = (SysUser) getSession().getAttribute("user");
		if (getUploadFile() == null) {
			getRequest().setAttribute("pd", Integer.valueOf(2));
			return "success";
		}
		try {
			String compClass=getCompClasses();
			excelFile = new FileInputStream(getUploadFile());
			ExcelReader excelReader = new ExcelReader();
			Map<Integer,FileNames> map = excelReader.readExcelContentToCell(excelFile,getUploadFileFileName());
			fileNamesService.insertExcel(map, user,compClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getRequest().setAttribute("pd", Integer.valueOf(1));
		return "success";
	}

	@Action("downExcel")
	public String downExcel() throws Exception {
		SysUser user = (SysUser) getSession().getAttribute("user");
		if ((user != null) && (user.getUserName().equals("admin"))) {
			FileNames file = new FileNames();
			/*String address = getRequest().getParameter("address");
			String compnyName = getRequest().getParameter("compnyName");
			String department = getRequest().getParameter("department");
			String linkmn = getRequest().getParameter("linkmn");
			String post = getRequest().getParameter("post");
			String compClass = getRequest().getParameter("compClass");
			String fbak2 = getRequest().getParameter("fbak2");
			String isdelete = getRequest().getParameter("isdelete");*/
			String compClass = getRequest().getParameter("compClass");
			String fbak1 = getRequest().getParameter("fbak1");
			String zipCode = getRequest().getParameter("zipCode");
			String isdelete=getRequest().getParameter("isdelete");
			/*file.setAddress(address);
			file.setCompnyName(compnyName);
			file.setDepartment(department);
			file.setLinkmn(linkmn);
			file.setPost(post);
			file.setCompClass(compClass);
			file.setFbak2(fbak2);
			file.setIsdelete(isdelete);*/
			file.setIsdelete(isdelete);
			file.setCompClass(compClass);
			file.setFbak1(fbak1);
			file.setZipCode(zipCode);
			fileNamesService.insertExcelFiles(this.getRequest(), this.getResponse(), file);
		}

		return null;
	}
	
	@Action("signFiles")
	public void signFiles()  {
		String strid=getRequest().getParameter("id");
		String times=getRequest().getParameter("times");
		Long fid=(long) 0;
		if(strid!=null && strid.length()>0){
			fid=Long.parseLong(strid);
		}
		try {
			SysUser user = (SysUser) getSession().getAttribute("user");
			if ((user != null) && (user.getUserName().equals("admin"))) {
				String strDt="";
				if(times!=null && times.length()>0){
					strDt=times;
				}else{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					strDt = sdf.format(new Date());
				}
				//根据id得到公司名称
				FileNames filename=fileNamesService.getFileNamesByID(fid);
				String comName="";
				if(filename!=null){
					comName=filename.getCompnyName();
				}
				
				Excel excel = new Excel();
				excel.setFileId(fid);
				excel.setDownTime(strDt);
				excel.setStatus(1);
				excel.setClss(1);
				fileNamesService.insertExcel(excel);
				if(comName!=""){
					List<FileNames> listFile=fileNamesService.getByName(comName);
					if(listFile!=null){
						for (FileNames fileNames : listFile) {
							if(!fileNames.getId().equals(fid)){
								Excel excels = new Excel();
								excels.setFileId(fileNames.getId());
								excels.setDownTime(strDt);
								excels.setStatus(8);        //跟进标记
								excels.setClss(1);
								fileNamesService.insertExcel(excels);
							}
						}
					}
				}
				writeResult(true, "标记成功！", getResponse());
			}else{
				writeResult(true, "没有权限！", getResponse());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Action(value = "rvsign", results = { @org.apache.struts2.convention.annotation.Result(name = "success", location = "/fileName/rvsign.jsp") })
	public String rvsign() throws Exception {
		String strid=this.getRequest().getParameter("id");
		Long fid=(long) 0;
		if(strid!=null && strid.length()>0){
			fid=Long.parseLong(strid);
		}
		List<Excel> excelList = fileNamesService.getExcel(fid,1);
		this.getRequest().setAttribute("excelList", excelList);
		this.getRequest().setAttribute("fid", fid);
		return "success";
	}
	@Action("rvsignFiles")
	public void rvsignFiles()  {
		String strid=getRequest().getParameter("id");
		String strstates=getRequest().getParameter("states");
		Long fid=(long) 0;
		Integer states=0;
		if(strid!=null && strid.length()>0){
			fid=Long.parseLong(strid);
		}
		if(strstates!=null && strstates.length()>0){
			states=Integer.parseInt(strstates);
		}
		try {
			fileNamesService.updateState(fid,states);
			String str="";
			if(states==0){
				str="信息错误！";
			}else if(states==1){
				str="标记成功！";
			}else if(states==2){
				str="信息正确！";
			}else if(states==3){
				str="画册退回！";
			}else if(states==4){
				str="查无此人！";
			}else if(states==5){
				str="画册转交！";
			}else if(states==6){
				str="此人退休！";
			}
			writeResult(true, str, getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}











