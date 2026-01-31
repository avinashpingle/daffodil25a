package com.skillio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ExcelUtil {

	/**
	 * Read the contents of an Excel sheet (.xlsx) and return it as a two-dimensional
	 * Object array.
	 *
	 * <p>Contract:
	 * - Input: a path to an existing .xlsx file and a zero-based sheet index.
	 * - Output: a non-null (when successful) Object[][] where the first dimension
	 *   indexes rows and the second dimension indexes cells within a row.
	 * - Supported cell types returned:
	 *   - STRING -> java.lang.String
	 *   - NUMERIC -> java.lang.Double
	 *   - other cell types -> null (currently ignored)
	 *
	 * <p>Notes / behavior details:
	 * - The method uses Apache POI (XSSFWorkbook) to open the workbook.
	 * - The number of rows and columns are determined using
	 *   Sheet#getLastRowNum() and Row#getLastCellNum() respectively. Empty cells
	 *   may yield null entries in the returned array.
	 * - The method handles FileNotFoundException and IOException internally by
	 *   printing the stack trace and returning null (or a partially filled array)
	 *   in error situations.
	 * - Resources (FileInputStream and Workbook) are opened but not explicitly
	 *   closed by this method. This can lead to resource leaks; callers should
	 *   prefer a revised implementation that closes these resources or update
	 *   this utility to use try-with-resources.
	 * - Indexing is zero-based for both rows and columns.
	 * - This method is not synchronized; call from multiple threads may need
	 *   external synchronization.
	 *
	 * <p>Example:
	 * Object[][] data = ExcelUtil.getData("/path/to/file.xlsx", 0);
	 * if (data != null) {
	 *     Object firstCell = data[0][0]; // value of first row, first cell
	 * }
	 *
	 * @param filePath absolute or relative path to the .xlsx file
	 * @param sheetIndex zero-based index of sheet to read
	 * @return a 2D Object array containing cell values (String or Double), or
	 *         null if an I/O error occurred while reading the file
	 */
	public static Object[][] getData(String filePath, int sheetIndex) {
		FileInputStream fis = null;
		Object[][] data = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Workbook book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheetAt(sheetIndex);
			int rows = sheet.getLastRowNum();
			data = new Object[rows][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i <=rows; i++) {
				Row row = sheet.getRow(i);
 				int cells = row.getLastCellNum();
 				for (int j = 0; j <=cells; j++) {
					Cell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case STRING: 
						data[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j] = cell.getNumericCellValue();
						break;
					default:
						break;
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * Read the contents of an Excel sheet (.xlsx) by name and return it as a
	 * two-dimensional Object array.
	 *
	 * <p>Contract:
	 * - Input: a path to an existing .xlsx file and a sheet name.
	 * - Output: a non-null (when successful) Object[][] where the first dimension
	 *   indexes rows and the second dimension indexes cells within a row.
	 * - Supported cell types returned:
	 *   - STRING -> java.lang.String
	 *   - NUMERIC -> java.lang.Double
	 *   - other cell types -> null (currently ignored)
	 *
	 * <p>Notes / behavior details:
	 * - The method uses Apache POI (XSSFWorkbook) to open the workbook.
	 * - The number of rows and columns are determined using
	 *   Sheet#getLastRowNum() and Row#getLastCellNum() respectively. Empty cells
	 *   may yield null entries in the returned array.
	 * - The method handles FileNotFoundException and IOException internally by
	 *   printing the stack trace and returning null (or a partially filled array)
	 *   in error situations.
	 * - Resources (FileInputStream and Workbook) are opened but not explicitly
	 *   closed by this method. This can lead to resource leaks; callers should
	 *   prefer a revised implementation that closes these resources or update
	 *   this utility to use try-with-resources.
	 * - Indexing is zero-based for both rows and columns.
	 * - This method is not synchronized; call from multiple threads may need
	 *   external synchronization.
	 *
	 * <p>Example:
	 * Object[][] data = ExcelUtil.getData("/path/to/file.xlsx", "Sheet1");
	 * if (data != null) {
	 *     Object firstCell = data[0][0]; // value of first row, first cell
	 * }
	 *
	 * @param filePath absolute or relative path to the .xlsx file
	 * @param sheetName the name of the sheet to read
	 * @return a 2D Object array containing cell values (String or Double), or
	 *         null if an I/O error occurred while reading the file
	 */
	public static Object[][] getData(String filePath, String sheetName) {
		FileInputStream fis = null;
		Object[][] data = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Workbook book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			data = new Object[rows][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i <=rows; i++) {
				Row row = sheet.getRow(i);
 				int cells = row.getLastCellNum();
 				for (int j = 0; j <=cells; j++) {
					Cell cell = row.getCell(j);
					switch (cell.getCellType()) {
					case STRING: 
						data[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j] = cell.getNumericCellValue();
						break;
					default:
						break;
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public static Object[][] getDataStartingFromRow(String filePath, String sheetName, int startRow) {
		FileInputStream fis = null;
		Object[][] data = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Workbook book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			System.out.println("Total rows: "+rows);
			int cells = sheet.getRow(0).getLastCellNum();
			data = new Object[rows][cells];

			for (int i = startRow; i <rows; i++) {
				Row row = sheet.getRow(i);
 				
 				System.out.println("Total cells in row "+i+": "+cells);
 				for (int j = 0; j < cells; j++) {
				
 					Cell cell = row.getCell(j);
					
 					switch (cell.getCellType()) {
					case STRING: 
						data[i-startRow][j] = cell.getStringCellValue();
						System.out.println("data["+ (i-startRow) +"]["+ j +"] = "+data[i-startRow][j]);
						break;
					case NUMERIC:
						data[i-startRow][j] = cell.getNumericCellValue();
						System.out.println("data["+ (i-startRow) +"]["+ j +"] = "+data[i-startRow][j]);
						break;
					default:
						break;
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	public static List getRowData(String filePath, String sheetName, int rowNum) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook book = null;
		try {
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		List data = new ArrayList();
		for (int i = 0; i <row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);
			switch (cell.getCellType()) {
					case STRING:
						data.add(cell.getStringCellValue());
						break;
					case NUMERIC:
						data.add(cell.getNumericCellValue());
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + cell.getCellType());
			}
		}
		return data;
		
		
	}
}