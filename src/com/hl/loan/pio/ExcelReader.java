package com.hl.loan.pio;

import com.hl.loan.pojo.FileNames;
import com.hl.loan.pojo.FileNamesLog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader{
  private static final Logger log = Logger.getLogger(ExcelReader.class);
  private POIFSFileSystem fs;
  private HSSFWorkbook wb;
  private HSSFSheet sheet;
  private HSSFRow row;
  private XSSFWorkbook xwb;
  private XSSFSheet xsheet;
  private XSSFRow xrow;

  public String[] readExcelTitle(InputStream is)
  {
    try
    {
      this.fs = new POIFSFileSystem(is);
      this.wb = new HSSFWorkbook(this.fs);
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.sheet = this.wb.getSheetAt(0);
    this.row = this.sheet.getRow(0);

    int colNum = this.row.getPhysicalNumberOfCells();
    System.out.println("colNum:" + colNum);
    String[] title = new String[colNum];
    for (int i = 0; i < colNum; i++)
    {
      title[i] = getCellFormatValue(this.row.getCell((short)i));
    }
    return title;
  }

  public Map<Integer, String> readExcelContent(InputStream is)
  {
    Map content = new HashMap();
    String str = "";
    try
    {
      this.wb = new HSSFWorkbook(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.sheet = this.wb.getSheetAt(0);

    int rowNum = this.sheet.getLastRowNum();
    this.row = this.sheet.getRow(0);
    int colNum = this.row.getPhysicalNumberOfCells();

    for (int i = 1; i <= rowNum; i++) {
      this.row = this.sheet.getRow(i);
      int j = 0;
      while (j < colNum)
      {
        str = str + getCellFormatValue(this.row.getCell((short)j)).trim() + "    ";
        j++;
      }
      content.put(Integer.valueOf(i), str);
      str = "";
    }
    return content;
  }
  public Map<Integer, FileNames> redsXlsx(InputStream is) throws ParseException {
    Map content = new HashMap();
    try
    {
      this.xwb = new XSSFWorkbook(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.xsheet = this.xwb.getSheetAt(0);

    int rowNum = this.xsheet.getLastRowNum();
    this.xrow = this.xsheet.getRow(0);
    int colNum = this.xrow.getPhysicalNumberOfCells();

    for (int i = 1; i <= rowNum; i++) {
      log.info("==============================第" + i + "行");
      FileNames fileNames = new FileNames();
      this.xrow = this.xsheet.getRow(i);
      int j = 0;
      while (j < colNum)
      {
        if (j == 0)
          fileNames.setZipCode(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 1)
          fileNames.setAddress(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 2)
          fileNames.setCompnyName(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 3)
          fileNames.setDepartment(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 4)
          fileNames.setLinkmn(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 5)
          fileNames.setSex(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 6)
          fileNames.setPost(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 7)
          fileNames.setOfficePhone(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 8)
          fileNames.setPhone(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 9)
          fileNames.setQq(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 10)
          fileNames.setEmail(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 11)
          fileNames.setFimallyPhone(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 12)
          fileNames.setBirthday(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 13)
          fileNames.setRemark(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        else if (j == 14) {
          fileNames.setUrl(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
        }
        else if (j == 15) {
            fileNames.setDpName(getXCellFormatValue(this.xrow.getCell((short)j)).trim());
          }
        else if (j == 16) {
        	fileNames.setIsdelete(getXCellFormatValue(this.xrow.getCell((short)j)).trim()!=null ? getCellFormatValue(this.row.getCell((short)j)).trim():"n");
          }
        j++;
      }
      Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date time = null;
		try {
			time = sdf.parse(sdf.format(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fileNames.setAddTime(time);
		fileNames.setChangeTime(time);
		fileNames.setFmonily(Integer.valueOf(1));
		fileNames.setFstate(Integer.valueOf(2));
      content.put(Integer.valueOf(i), fileNames);
    }
    return content;
  }

  public Map<Integer, FileNames> redsXls(InputStream is) throws ParseException {
    Map content = new HashMap();
    String str = "";
    try {
      this.fs = new POIFSFileSystem(is);
      this.wb = new HSSFWorkbook(this.fs);
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.sheet = this.wb.getSheetAt(0);

    int rowNum = this.sheet.getLastRowNum();
    this.row = this.sheet.getRow(0);
    int colNum = this.row.getPhysicalNumberOfCells();

    for (int i = 1; i <= rowNum; i++) {
      log.info("==============================第" + i + "行");
      FileNames fileNames = new FileNames();
      FileNamesLog fileNamesLog = new FileNamesLog();
      this.row = this.sheet.getRow(i);
      int j = 0;
      while (j < colNum)
      {
        if (j == 0)
          fileNames.setZipCode(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 1)
          fileNames.setAddress(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 2)
          fileNames.setCompnyName(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 3)
          fileNames.setDepartment(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 4)
          fileNames.setLinkmn(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 5)
          fileNames.setSex(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 6)
          fileNames.setPost(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 7)
          fileNames.setOfficePhone(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 8)
          fileNames.setPhone(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 9)
          fileNames.setQq(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 10)
          fileNames.setEmail(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 11)
          fileNames.setFimallyPhone(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 12)
          fileNames.setBirthday(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 13)
          fileNames.setRemark(getCellFormatValue(this.row.getCell((short)j)).trim());
        else if (j == 14) {
          fileNames.setUrl(getCellFormatValue(this.row.getCell((short)j)).trim());
        }
        else if (j == 15) {
            fileNames.setDpName(getCellFormatValue(this.row.getCell((short)j)).trim());
          }
        else if (j == 16) {
            fileNames.setIsdelete(getCellFormatValue(this.row.getCell((short)j)).trim()!="" ? getCellFormatValue(this.row.getCell((short)j)).trim():"n");
          }
        j++;
      }
      Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date time = null;
		try {
			time = sdf.parse(sdf.format(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fileNames.setAddTime(time);
		fileNames.setChangeTime(time);
		fileNames.setFmonily(Integer.valueOf(1));
		fileNames.setFstate(Integer.valueOf(2));
      content.put(Integer.valueOf(i), fileNames);
    }
    return content;
  }

  public Map<Integer, FileNames> readExcelContentToCell(InputStream is, String fileName) throws ParseException {
    Map content = new HashMap();
    ExcelReader exr = new ExcelReader();
    int index = fileName.lastIndexOf(".");
    String str = fileName.substring(index + 1);
    if (str.equals("xls"))
      content = exr.redsXls(is);
    else if (str.equals("xlsx")) {
      content = exr.redsXlsx(is);
    }
    return content;
  }

  private String getStringCellValue(HSSFCell cell)
  {
    String strCell = "";
    switch (cell.getCellType()) {
    case 1:
      strCell = cell.getStringCellValue();
      break;
    case 0:
      strCell = String.valueOf(cell.getNumericCellValue());
      break;
    case 4:
      strCell = String.valueOf(cell.getBooleanCellValue());
      break;
    case 3:
      strCell = "";
      break;
    case 2:
    default:
      strCell = "";
    }

    if ((strCell.equals("")) || (strCell == null)) {
      return "";
    }
    if (cell == null) {
      return "";
    }
    return strCell;
  }

  private String getDateCellValue(HSSFCell cell)
  {
    String result = "";
    try {
      int cellType = cell.getCellType();
      if (cellType == 0) {
        Date date = cell.getDateCellValue();
        result = date.getYear() + 1900 + "-" + (date.getMonth() + 1) + 
          "-" + date.getDate();
      } else if (cellType == 1) {
        String date = getStringCellValue(cell);
        result = date.replaceAll("[年月]", "-").replace("日", "").trim();
      } else if (cellType == 3) {
        result = "";
      }
    } catch (Exception e) {
      System.out.println("日期格式不正确!");
      e.printStackTrace();
    }
    return result;
  }

  private String getCellFormatValue(HSSFCell cell)
  {
    String cellvalue = "";
    if (cell != null)
    {
      switch (cell.getCellType())
      {
      case 0:
        DecimalFormat df = new DecimalFormat("0");
        cellvalue = String.valueOf(df.format(cell.getNumericCellValue()));
        break;
      case 2:
        if (HSSFDateUtil.isCellDateFormatted(cell))
        {
          Date date = cell.getDateCellValue();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          cellvalue = sdf.format(date);
        }
        else
        {
          cellvalue = String.valueOf(cell.getNumericCellValue());
        }
        break;
      case 1:
        cellvalue = cell.getRichStringCellValue().getString();
        break;
      default:
        cellvalue = " ";

        break; } 
    } else cellvalue = "";

    return cellvalue;
  }

  private String getXCellFormatValue(XSSFCell xcell)
  {
    String cellvalue = "";
    if (xcell != null)
    {
      switch (xcell.getCellType())
      {
      case 0:
        DecimalFormat df = new DecimalFormat("0");
        cellvalue = String.valueOf(df.format(xcell.getNumericCellValue()));
        break;
      case 2:
        Date date = xcell.getDateCellValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cellvalue = sdf.format(date);
        break;
      case 1:
        cellvalue = xcell.getRichStringCellValue().getString();
        break;
      default:
        cellvalue = " ";

        break; } 
    } else cellvalue = "";

    return cellvalue;
  }

  public static void main(String[] args)
  {
    try {
      ExcelReader excelReader = new ExcelReader();

      InputStream is2s = new FileInputStream("d:\\ww.xls");
      Map maps = excelReader.readExcelContentToCell(is2s, "ww.xls");
      for (int i = 1; i <= maps.size(); i++)
        System.out.println(((FileNames)maps.get(Integer.valueOf(i))).getAddress() + "=========" + ((FileNames)maps.get(Integer.valueOf(i))).getCompnyName());
    }
    catch (Exception e)
    {
      System.out.println("未找到指定路径的文件!");
      e.printStackTrace();
    }
  }
}