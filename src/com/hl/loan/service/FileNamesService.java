package com.hl.loan.service;

import com.hl.loan.pojo.Excel;
import com.hl.loan.pojo.FileNames;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.util.PageModel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface FileNamesService{
  public abstract FileNames addFilesName(FileNames paramFileNames);

  public abstract PageModel<FileNames> showFiles(PageModel<FileNames> paramPageModel, FileNames paramFileNames, String paramString);

  public abstract int updateFileByID(String paramString, FileNames paramFileNames);
  public void updateExcel(Long id);
  public abstract FileNames getFileNamesByID(Long paramLong);

  public int updateFile(Long id, int fstate, Date time,int fmo);

  public abstract void updateByFiles(FileNames paramFileNames);

  public abstract void updateAll(FileNames paramFileNames);

  public abstract List<FileNames> getAllFileNames();

  public abstract void insertExcelFiles(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse, FileNames paramFileNames);

  public abstract List<Excel> getExcel(Long paramLong,int status);

  public abstract void insertExcel(Map<Integer, FileNames> paramMap, SysUser paramSysUser,String compClass);

  public void updateAllExam(FileNames file);
  public void insertExcel(Excel excel);

  public void updateState(Long id, int status);
  public List<FileNames> getByName(String compnyName);
}