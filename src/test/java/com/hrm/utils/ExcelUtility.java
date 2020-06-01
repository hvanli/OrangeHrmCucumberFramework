package com.hrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook wBook;
	private static Sheet sheet;
	
	public static void openExcel(String filePath, String sheetName) {
		try {
			FileInputStream fis=new FileInputStream(filePath);
			wBook=new XSSFWorkbook(fis);
			sheet=wBook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int colCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public static String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	
	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName){
		openExcel(filePath, sheetName);
		
		List<Map<String, String>> data=new ArrayList<Map<String, String>>();
		
		for(int i=1; i<rowCount(); i++) {
			Map<String, String> map=new HashMap<>();
			for(int j=0; j<colCount(); j++) {
				map.put(getCellData(0, j), getCellData(i, j));
			}
			data.add(map);
		}
		return data;
	}
	
	
	public static List<ArrayList<String>> excelIntoListOfList(String filePath, String sheetName){
		openExcel(filePath, sheetName);
		List<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
		
		for(int i=1; i<rowCount(); i++) {
			ArrayList<String> list=new ArrayList<String>();
			for(int j=0; j<colCount(); j++) {
				list.add(getCellData(i, j));
			}
			data.add(list);
		}
		
		return data;		
	}
}
