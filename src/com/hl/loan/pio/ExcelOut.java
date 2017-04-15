package com.hl.loan.pio;

import com.hl.loan.pojo.FileNames;
import com.hl.loan.pojo.SysDept;
import com.hl.loan.service.DeptService;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelOut {

	public static HSSFWorkbook exportExcel(String sheetName, String[] titles,
			List<List<String>> values) {
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet(sheetName);

		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment((short) 2);
		style.setVerticalAlignment((short) 1);

		HSSFFont font = wb.createFont();
		font.setBoldweight((short) 700);
		font.setFontName("宋体");
		font.setFontHeight((short) 250);
		style.setFont(font);

		HSSFCell cell = null;
		Integer titleLength = Integer.valueOf(0);
		if ((titles != null) && (titles.length > 0)) {
			titleLength = Integer.valueOf(titles.length);
		}
		for (short i = 0; i < titleLength.intValue(); i = (short) (i + 1)) {
			cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(titles[i]));
			cell.setCellStyle(style);
		}

		Integer valueLength = Integer.valueOf(0);
		if ((values != null) && (values.size() > 0)) {
			valueLength = Integer.valueOf(values.size());
		}
		for (int j = 0; j < valueLength.intValue(); j++) {
			row = sheet.createRow(j + 1);
			List list = (List) values.get(j);
			for (short k = 0; k < titleLength.intValue(); k = (short) (k + 1)) {
				row.createCell(k).setCellValue((String) list.get(k));
			}
		}
		return wb;
	}

	public static HSSFWorkbook exportExcel2(String sheetName, String[] titles,
			List<FileNames> list) {
		HSSFWorkbook wb = new HSSFWorkbook();

		HSSFSheet sheet = wb.createSheet(sheetName);

		HSSFRow row = sheet.createRow(0);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment((short) 2);
		style.setVerticalAlignment((short) 1);

		HSSFFont font = wb.createFont();
		font.setBoldweight((short) 700);
		font.setFontName("宋体");
		font.setFontHeight((short) 250);
		style.setFont(font);

		HSSFCell cell = null;
		Integer titleLength = Integer.valueOf(0);
		if ((titles != null) && (titles.length > 0)) {
			titleLength = Integer.valueOf(titles.length);
		}
		for (short i = 0; i < titleLength.intValue(); i = (short) (i + 1)) {
			cell = row.createCell(i);
			cell.setCellValue(new HSSFRichTextString(titles[i]));
			cell.setCellStyle(style);
		}

		int j = 1;
		
		for (FileNames file : list) {
			row = sheet.createRow(j);
			for (short k = 0; k < titleLength.intValue(); k = (short) (k + 1)) {
				if (k == 0)
					row.createCell(k).setCellValue(file.getId() != null ? String.valueOf(file.getId()): "");
				else if (k == 1)
					row.createCell(k).setCellValue(file.getEmail() != null ? String.valueOf(file.getEmail()) : "");
				else if (k == 2)
					row.createCell(k).setCellValue(file.getAddress() != null ? String.valueOf(file.getAddress()) : "");
				else if (k == 3)
					row.createCell(k).setCellValue(file.getCompnyName() != null ? String.valueOf(file.getCompnyName()).toString() : "");
				else if (k == 4)
					row.createCell(k).setCellValue(file.getDepartment() != null ? String.valueOf(file.getDepartment()) : "");
				else if (k == 5)
					row.createCell(k).setCellValue(file.getLinkmn() != null ? String.valueOf(file.getLinkmn()) : "");
				else if (k == 6)
					row.createCell(k).setCellValue(file.getSex() != null ? String.valueOf(file.getSex()) : "");
				else if (k == 7)
					row.createCell(k).setCellValue(file.getPost() != null ? String.valueOf(file.getPost()) : "");
				else if (k == 8)
					row.createCell(k).setCellValue(file.getOfficePhone() != null ? String.valueOf(file.getOfficePhone()) : "");
				else if (k == 9)
					row.createCell(k).setCellValue(file.getPhone() != null ? String.valueOf(file.getPhone()) : "");
				else if (k == 10)
					row.createCell(k).setCellValue(file.getQq() != null ? String.valueOf(file.getQq()): "");
				else if (k == 11)
					row.createCell(k).setCellValue(file.getEmail() != null ? String.valueOf(file.getEmail()) : "");
				else if (k == 12)
					row.createCell(k).setCellValue(file.getFimallyPhone() != null ? String.valueOf(file.getFimallyPhone()) : "");
				else if (k == 13)
					row.createCell(k).setCellValue(file.getBirthday() != null ? String.valueOf(file.getBirthday()) : "");
				else if (k == 14)
					row.createCell(k).setCellValue(file.getRemark() != null ? String.valueOf(file.getRemark()) : "");
				else if (k == 15) {
					row.createCell(k).setCellValue(file.getUrl() != null ? String.valueOf(file.getUrl()) : "");
				}
				else if (k == 16) {
					row.createCell(k).setCellValue(file.getDeptNames() != null ? String.valueOf(file.getDeptNames()) : "");
				}
				else if (k == 17) {
					row.createCell(k).setCellValue(file.getIsdelete() != null ? String.valueOf(file.getIsdelete()) : "");
				}

			}

			j++;
		}
		return wb;
	}

	public static void excel(Map<Integer, FileNames> orderMaps,
			HttpServletResponse response, String fileName) throws IOException {
		String[] title = { "编号", "邮编", "单位名称", "部门", "联系人", "性别", "职务", "办公电话","手机", "QQ", "邮箱", "家庭电话", "生日", "备注", "网址","公司类型" ,"是否导入修改"};

		OutputStream output = response.getOutputStream();
		BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0L);
			bufferedOutPut.flush();
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bufferedOutPut.close();
			output.close();
		}
	}

	public static void excel2(List<FileNames> list,
			HttpServletResponse response, String fileName) throws IOException {
		String[] title = { "编号", "邮编", "地址", "单位名称", "部门", "联系人", "性别", "职务","办公电话", "手机", "QQ", "邮箱", "家庭电话", "生日", "备注", "网址" ,"公司类型","是否导入修改"};
		HSSFWorkbook wb = exportExcel2("order", title, list);
		OutputStream output = response.getOutputStream();
		BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="
					+ URLEncoder.encode(fileName, "UTF-8"));
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0L);
			bufferedOutPut.flush();
			response.flushBuffer();
			wb.write(bufferedOutPut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bufferedOutPut.close();
			output.close();
		}
	}
}