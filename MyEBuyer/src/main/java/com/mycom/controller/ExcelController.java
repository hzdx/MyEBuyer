package com.mycom.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.domain.User;

@Controller
public class ExcelController extends BaseController {

	@RequestMapping(value = "/testExcel")
	public void exportExcel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HSSFWorkbook wb = export(users);
		resp.setContentType("application/vnd.ms-excel");
		resp.setHeader("Content-disposition", "attachment;filename=users.xls");
		// attachment --- 作为附件下载
		OutputStream ouputStream = resp.getOutputStream();
		wb.write(ouputStream);
		ouputStream.flush();
		ouputStream.close();
	}

	static final String[] excelHeader = { "id", "name", "phone" };
	static final List<User> users;
	static {
		users = new ArrayList<>(5);
		users.add(new User(1, "小红", "13588888888"));
		users.add(new User(2, "张三", "13723456789"));
		users.add(new User(3, "李四", "13444444444"));
		users.add(new User(4, "王五", "13678987654"));
		users.add(new User(5, "赵六", "15865784321"));
	}

	public static HSSFWorkbook export(List<User> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("users");
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
		}

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			User user = list.get(i);
			row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getName());
			row.createCell(2).setCellValue(user.getPhone());
		}
		return wb;
	}

	public static void main(String[] args) throws IOException {
		HSSFWorkbook wb = export(users);
		String filePath = "d:/users1.xls";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		wb.write(bos);
		bos.flush();
		bos.close();
	}

//	String[] excelHeader = { "所属区域（地市）", "机房", "机架资源情况", "", "", "", "",  
//		    "", "端口资源情况", "", "", "", "", "", "机位资源情况", "", "", "设备资源情况",  
//		    "", "", "IP资源情况", "", "", "", "", "网络设备数" };  
//		String[] excelHeader1 = { "", "", "总量(个)", "空闲(个)", "预占(个)", "实占(个)",  
//		    "自用(个)", "其它(个)", "总量(个) ", "在用(个)", "空闲(个)", "总带宽(M)",  
//		    "在用带宽(M)", "空闲带宽(M)", "总量(个)", "在用(个)", "空闲(个)", "设备总量(个)",  
//		    "客户设备(个)", "电信设备(个)", "总量(个)", "空闲(个)", "预占用(个)", "实占用(个)",  
//		    "自用(个)", "" };  
//		// 单元格列宽  
//		int[] excelHeaderWidth = { 150, 120, 100, 100, 100, 100, 100, 100, 100,  
//		    100, 100, 120, 120, 120, 120, 120, 120, 150, 150, 150, 120,  
//		    120, 150, 150, 120, 150 };  
//		  
//		HSSFWorkbook wb = new HSSFWorkbook();  
//		HSSFSheet sheet = wb.createSheet("机房报表统计");  
//		HSSFRow row = sheet.createRow((int) 0);  
//		HSSFCellStyle style = wb.createCellStyle();  
//		// 设置居中样式  
//		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中  
//		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
//		  
//		// 设置合计样式  
//		HSSFCellStyle style1 = wb.createCellStyle();  
//		Font font = wb.createFont();  
//		font.setColor(HSSFColor.RED.index);  
//		font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体  
//		style1.setFont(font);  
//		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中  
//		style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中  
//		  
//		// 合并单元格  
//		// first row (0-based) last row (0-based) first column (0-based) last  
//		// column (0-based)  
//		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));  
//		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));  
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 7));  
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 13));  
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 14, 16));  
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 17, 19));  
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 20, 24));  
//		sheet.addMergedRegion(new CellRangeAddress(0, 1, 25, 25));  
//		// 设置列宽度（像素）  
//		for (int i = 0; i < excelHeaderWidth.length; i++) {  
//		    sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);  
//		}  
//		  
//		// 添加表格头  
//		for (int i = 0; i < excelHeader.length; i++) {  
//		    HSSFCell cell = row.createCell(i);  
//		    cell.setCellValue(excelHeader[i]);  
//		    cell.setCellStyle(style);  
//		}  
//		row = sheet.createRow((int) 1);  
//		for (int i = 0; i < excelHeader1.length; i++) {  
//		    HSSFCell cell = row.createCell(i);  
//		    cell.setCellValue(excelHeader1[i]);  
//		    cell.setCellStyle(style);  
//		}  

}
