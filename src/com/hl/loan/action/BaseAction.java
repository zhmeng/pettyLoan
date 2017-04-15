package com.hl.loan.action;

import javax.servlet.ServletOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.hl.loan.pojo.SysRights;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.ComBaseDataDaoService;
import com.hl.loan.service.SysRightsService;
import com.hl.loan.service.impl.ComBaseDataServiceImpl;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	@Autowired
	private SysRightsService sysRightsService;
	@Autowired 
	private ComBaseDataDaoService  comBaseDataDaoService;
	private static final Log LOG = LogFactory.getLog(BaseAction.class);

	public static final String SUCCESS = "success";

	public static final String SYSTEM_ERROR = "systemError";

	public static final String LIST = "list";

	protected static int defaultPageSize = 20;

	protected static String siteCode = "en";

	public static final String KEY_DEFAULT_PAGE_SIZE = "default-page-size";

	public static final String KEY_SITE_CODE = "site-code";
	
	public static final String FILE_PATH = "D:/files";

	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession(false);
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	
	protected void add2Request(String key, Object obj) {
		LOG.debug("Add an object [" + key
				+ "] to request's attribute, Object = {" + obj.toString() + "}");
		getRequest().setAttribute(key, obj);
	}

	protected void add2Session(String key, Object obj) {
		LOG.debug("Add an object [" + key
				+ "] to session's attribute, Object = { " + obj.toString()
				+ "}");
		getSession().setAttribute(key, obj);
	}

	protected void returnPopupMessage(String message) {
		try {
			getResponse().setContentType("text/html; charset=utf-8");
			getResponse().getWriter().write(message);
		} catch (Exception ex) {
			LOG.error(
					"Return popup message{" + message + "} to browser error:",
					ex);
		}
	}

	/**
	 * 
	 * 
	 * @param file
	 *            
	 * @param fileName
	 *           
	 */
	protected void downloadFile(File file, String fileName) {
		HttpServletResponse response = this.getResponse();
		response.setContentType("application/x-msdownload; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);
		response.addHeader("Content-Length",file.length()+"");
		InputStream input = null;
		OutputStream output = null;
		try {
			output = response.getOutputStream();
			input = new FileInputStream(file);
			byte[] temp = new byte[1024 * 10];
			while (input.read(temp) != -1) {
				output.write(temp);
			}
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @param file
	 * @param destPath
	 * @return 
	 * @throws IOException
	 */
	protected boolean saveFile(File srcFile, File destFile) throws IOException {
		boolean flag = false;
		if (srcFile != null && destFile != null) {
			InputStream input = new FileInputStream(srcFile);
			OutputStream output = new FileOutputStream(destFile);
			byte[] temp = new byte[1024 * 10];
			while (input.read(temp) != -1) {
				output.write(temp);
			}			
			output.close();
			input.close();
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 
	 * 
	 * @param filePath
	 * @return
	 */
	protected boolean deleteFile(String filePath) {
		boolean flag = false;
		File file = new File(filePath);
		if (file.exists()) {
			flag = file.delete();
		}
		return flag;
	}

	protected int getIntParam(String paramName) {
		String param = this.getRequest().getParameter(paramName);
		if (param != null && !"".equals(param)) {
			return Integer.valueOf(param);
		}
		return 0;
	}
	
	protected Long getLongParam(String paramName) {
		String param = this.getRequest().getParameter(paramName);
		if (param != null && !"".equals(param)) {
			return Long.parseLong(param);
		}
		return 0L;
	}

	protected String getStringParam(String paramName) {
		return this.getRequest().getParameter(paramName);
	}

	protected Object getSessionAttr(String key) {
		return this.getSession().getAttribute(key);
	}
	
	protected String textConvertToHtmlText(String text){   
		if(text != null){   //<br>
			String destStr = text;
			if(destStr.indexOf("\r\n") != -1){
				destStr = text.replaceAll("\r\n", "<br>");
			}
			if(destStr.indexOf("\n") != -1){
				destStr = text.replaceAll("\n", "<br>");
			}
			if(destStr.indexOf("\r") != -1){
				destStr = text.replaceAll("\r", "<br>");
			}
	        return destStr;   
	     }else{   
	        return null;   
	     }   
	  }   
	
	protected void export(HSSFWorkbook wb, String fileName) throws IOException {
		HttpServletResponse response = this.getResponse();
		response.setContentType("application/x-msdownload");

		OutputStream output = this.getResponse().getOutputStream();
		wb.write(output);

		output.flush();
		output.close();
	}

	public void writeResult(boolean success, String message,
			HttpServletResponse response) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		JSONObject json = new JSONObject();
		json.put("success", success);
		json.put("msg", message);
		response.getWriter().print(json.toString());
	}
	//传list
	public void writeResultList(String list,
			HttpServletResponse response) throws IOException {
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().print(JSON.toJSONString(list));
	}
	
	public static void download(HttpServletResponse response, String path) throws Exception {
		File file = new File(path);
	    String filename = file.getName();
	    InputStream fis = new BufferedInputStream(new FileInputStream(path));
	    byte[] buffer = new byte[fis.available()];
	    fis.read(buffer);
	    fis.close();
	    response.reset();
	    // 先去掉文件名称中的空格，然后转换编码格式为utf-8，保证不出现乱码，这个文件名称用于浏览器的下载框中自动显示的文件名
	    response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
	    response.addHeader("Content-Length", "" + file.length());
	    OutputStream os = new BufferedOutputStream(response.getOutputStream());
	    response.setContentType("application/octet-stream");
	    os.write(buffer);// 输出文件
	    os.flush();
	    os.close();
	}
	public List<Buttons> getUrlRight(int number) {
		SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);
		String mid=getRequest().getParameter("modId");
		//得到用iD与用户权限设置
		int userId=sysUser.getUserID();
		int userRight=sysUser.getUserRights();
		int roleId=sysUser.getUserisRole();
		int id=0;
		if(userRight==1){
			id=userId;
		}else if(userRight==2){
			id=roleId;
		}
		//得到权限
		int sum=comBaseDataDaoService.getBaseCount("QXKZ");
		List<Buttons> blist=new ArrayList<>();
		List<SysRights> list=sysRightsService.getSysRightByIds(userRight, id, mid);
		if(list!=null && list.size()>0){
			SysRights sysRight=list.get(0);
			int rightsModID=sysRight.getRightsModCtrl();
			if((rightsModID & number) !=number){
				try {
					getResponse().sendRedirect(getRequest().getContextPath()+"/login.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				for(int i=0;i<sum;i++){
					Buttons bt=new Buttons();
					int maths=(int) Math.pow(2,i);
					if((maths & rightsModID)==maths){
						bt.setCValue(maths);
						blist.add(bt);
					}
				}
			}
			this.getRequest().setAttribute("modId", mid);
		}else{
			blist=null;
			SysUser sysUsers=null;
			this.getRequest().getSession().setAttribute(SystemSettings.SESSION_USER,sysUsers);
			try {
				getResponse().sendRedirect(getRequest().getContextPath()+"/login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		//getRequest().setAttribute("modId", mid);
		return blist;
	}
}








