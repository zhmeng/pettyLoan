package com.hl.loan.service.impl;

import com.hl.loan.dao.ExcelDao;
import com.hl.loan.dao.FileNamesDao;
import com.hl.loan.dao.FileNamesLogDao;
import com.hl.loan.pio.ExcelOut;
import com.hl.loan.pojo.Excel;
import com.hl.loan.pojo.FileNames;
import com.hl.loan.pojo.FileNamesLog;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.FileNamesService;
import com.hl.loan.util.PageModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service("fileNamesService")
public class FileNamesServiceImpl implements FileNamesService {

	@Resource
	private FileNamesDao fileNamesDao;

	@Resource
	private FileNamesLogDao fileNamesLogDao;

	@Resource
	private ExcelDao excelDao;

	public FileNames addFilesName(FileNames fileNames) {
		return fileNamesDao.addFilesName(fileNames);
	}

	public PageModel<FileNames> showFiles(PageModel<FileNames> pm,
			FileNames file, String depId) {
		return fileNamesDao.showFiles(pm, file, depId);
	}

	public int updateFileByID(String id, FileNames file) {
		return fileNamesDao.updateFileByID(id, file);
	}

	public FileNames getFileNamesByID(Long id) {
		return fileNamesDao.getFileNamesByID(id);
	}

	public int updateFile(Long id, int fstate, Date time,int fmo) {
		return fileNamesDao.updateFile(id, fstate, time,fmo);
	}

	public void updateByFiles(FileNames fileNames) {
		fileNamesDao.updateByFiles(fileNames);
	}

	public void updateAll(FileNames fileNames) {
		fileNamesDao.updateAll(fileNames);
	}

	public List<FileNames> getAllFileNames() {
		return fileNamesDao.getAllFileNames();
	}
	public void insertExcel(Excel excel){
		
		excelDao.saveExcel(excel);
	}
	public void insertExcelFiles(HttpServletRequest request,
			HttpServletResponse response, FileNames file) {
		List<FileNames> list = fileNamesDao.insertExcelFiles(file);
		
		/*System.out.println("==============================得到需要导出大小"+list.size());*/
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String strDt = sdf.format(new Date());
		for (FileNames fileNames : list) {
			Excel excel = new Excel();
			excel.setFileId(fileNames.getId());
			excel.setDownTime(strDt);
			excelDao.saveExcel(excel);
		}*/
		try {
			if ((list != null) || (list.size() > 0)) {
				ExcelOut.excel2(list, response, "企业信息.xls");
			} else {
				ExcelOut.excel2(null, response, "企业信息.xls");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Excel> getExcel(Long fileId,int status) {
		return excelDao.getExcel(fileId,status);
	}

	public void insertExcel(Map<Integer, FileNames> map, SysUser user,String compClass) {
		for (int i = 1; i <= map.size(); i++) {
			FileNames infileNames = (FileNames) map.get(Integer.valueOf(i));
			if (infileNames.getCompnyName()!=null && infileNames.getCompnyName().length()>0) {
				Long pid = null;
				String dpName = infileNames.getDpName();
				if (dpName != null && !dpName.equals("")) {
					pid = fileNamesDao.getIdByName(dpName);
				}
				infileNames.setPid(pid);
				infileNames.setCompClass(compClass);
				FileNames fileNames = fileNamesDao.addFilesName(infileNames);
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
				fileNamesLog.setChangeTime(fileNames.getChangeTime());
				fileNamesLog.setFmonily(Integer.valueOf(1));
				fileNamesLog.setFstate(Integer.valueOf(2));
				fileNamesLog.setFileId(fileNames.getId());
				fileNamesLog.setUserId(user.getUserID());
				fileNamesLogDao.addFilesName(fileNamesLog);
			}

		}
	}
	 @Override
	  public void updateAllExam(FileNames file){
		 fileNamesDao.updateAllExam(file);
	 }
	 @Override
	 public void updateExcel(Long id){
		 excelDao.updateExcel(id);
	 }
	 @Override
	 public void updateState(Long id,int status){
		 excelDao.updateState(id, status);
	 }
	 @Override
	 public List<FileNames> getByName(String compnyName){
		 return fileNamesDao.getByName(compnyName);
	 }
}