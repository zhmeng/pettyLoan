package com.hl.loan.dao;

import com.hl.loan.pojo.Excel;

import java.util.List;

public  interface ExcelDao{
  public abstract Excel saveExcel(Excel paramExcel);

  public abstract List<Excel> getExcel(Long paramLong,int states);
  public void updateExcel(Long id);
  public void updateState(Long id,int status);
}