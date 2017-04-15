package com.hl.loan.dao;

import com.hl.loan.pojo.FileNames;
import com.hl.loan.util.PageModel;

import java.util.Date;
import java.util.List;

public  interface FileNamesDao{
  public abstract FileNames addFilesName(FileNames paramFileNames);

  public abstract PageModel<FileNames> showFiles(PageModel<FileNames> paramPageModel, FileNames paramFileNames, String paramString);

  public abstract int updateFileByID(String paramString, FileNames paramFileNames);

  public abstract FileNames getFileNamesByID(Long paramLong);

  public abstract int updateFile(Long paramLong, int paramInt, Date paramDate,int fmo);

  public abstract void updateByFiles(FileNames paramFileNames);

  public abstract void updateAll(FileNames paramFileNames);

  public abstract List<FileNames> getAllFileNames();

  public abstract List<FileNames> insertExcelFiles(FileNames paramFileNames);
  public Long getIdByName(String dpName);
  public void updateAllExam(FileNames file);
  public List<FileNames> getByName(String compnyName);
}