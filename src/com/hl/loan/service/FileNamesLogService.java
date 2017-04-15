package com.hl.loan.service;

import com.hl.loan.pojo.FileNamesLog;
import com.hl.loan.util.PageModel;
import com.hl.loan.vi.TotalSum;

import java.util.Date;
import java.util.List;

public abstract interface FileNamesLogService
{
  public abstract FileNamesLog addFilesName(FileNamesLog paramFileNamesLog);

  public abstract PageModel<FileNamesLog> showFiles(PageModel<FileNamesLog> paramPageModel, FileNamesLog paramFileNamesLog);

  public abstract int updateFileByID(String paramString, FileNamesLog paramFileNamesLog);

  public abstract FileNamesLog getFileNamesLogByID(Long paramLong);

  public abstract int updateFileLogs(Long paramLong, int paramInt, Date paramDate);

  public abstract void updateByFiles(FileNamesLog paramFileNamesLog);

  public abstract void updateAllLog(FileNamesLog paramFileNamesLog);

  public abstract List<FileNamesLog> showByFileID(Long paramLong);
  public void updateAllExamLog(FileNamesLog file);
  public List<FileNamesLog> lookLog(FileNamesLog file);

  public PageModel<FileNamesLog> sumFile(PageModel<FileNamesLog> pm,FileNamesLog file);
}