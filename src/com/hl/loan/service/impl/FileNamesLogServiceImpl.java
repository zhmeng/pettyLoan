package com.hl.loan.service.impl;

import com.hl.loan.dao.FileNamesLogDao;
import com.hl.loan.pojo.FileNamesLog;
import com.hl.loan.service.FileNamesLogService;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.TotalSum;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("fileNamesLogService")
public class FileNamesLogServiceImpl implements FileNamesLogService{

  @Resource
  private FileNamesLogDao fileNamesLogDao;

  public FileNamesLog addFilesName(FileNamesLog fileNames)
  {
    return this.fileNamesLogDao.addFilesName(fileNames);
  }

  public PageModel<FileNamesLog> showFiles(PageModel<FileNamesLog> pm, FileNamesLog fileLog)
  {
    return this.fileNamesLogDao.showFiles(pm, fileLog);
  }

  public int updateFileByID(String id, FileNamesLog fileLog) {
    return this.fileNamesLogDao.updateFileByID(id, fileLog);
  }

  public FileNamesLog getFileNamesLogByID(Long id) {
    return this.fileNamesLogDao.getFileNamesLogByID(id);
  }

  public int updateFileLogs(Long id, int fstate, Date time) {
    return this.fileNamesLogDao.updateFileLogs(id, fstate, time);
  }

  public void updateByFiles(FileNamesLog fileNamesLog) {
    this.fileNamesLogDao.updateByFiles(fileNamesLog);
  }

  public void updateAllLog(FileNamesLog fileNamesLog) {
    this.fileNamesLogDao.updateAllLog(fileNamesLog);
  }

  public List<FileNamesLog> showByFileID(Long fileId) {
    return this.fileNamesLogDao.showByFileID(fileId);
  }
  public void updateAllExamLog(FileNamesLog file){
	  fileNamesLogDao.updateAllExamLog(file);
  }
  public List<FileNamesLog> lookLog(FileNamesLog file){
	  return fileNamesLogDao.lookLog(file);
  }
  @Override
  public PageModel<FileNamesLog> sumFile(PageModel<FileNamesLog> pm,FileNamesLog file){
	  return fileNamesLogDao.sumFile(pm,file);
  }
}