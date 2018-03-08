package com.iel.automation.utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iel.automation.constants.Constants;

/**
 * This class has logic to read data from excel sheet and store it in Collection
 * map
 * 
 * @author Suraiya.Mulani
 * @since 27 feb 2018
 *
 */
public class ExcelReader {

	Map<String, Map<String, String>> inputSheetData = new HashMap<>();
	FileInputStream fis = null;
	XSSFWorkbook workbook = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	public static final String ERROR_READEXCEL = "Error in reading excel  :";

	/**
	 * 
	 * @return Map containing test data excel files with Key as sheets and test
	 *         data as value in another map of attribute name and attribute
	 *         value
	 * @throws IelException
	 *             throws when unable to read test data
	 * 
	 */
	public Map<String, Map<String, String>> getInputSheetIntoMap() throws IelException {

		String sheetName;
		Map<String, String> testData;
		int totalRows;
		int k;
		String attributeName;
		String attributeValue;
		try {
			fis = new FileInputStream(Constants.TESTDATA_FILE_PATH);
			workbook = new XSSFWorkbook(fis);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				sheet = workbook.getSheetAt(i);
				sheetName = workbook.getSheetAt(i).getSheetName();
				testData = new HashMap<>();
				totalRows = sheet.getPhysicalNumberOfRows();
				for (int j = 1; j < totalRows; j++) {
					row = sheet.getRow(j);
					k = 0;
					while (k <= 0) {
						attributeName = row.getCell(k).getStringCellValue();
						attributeValue = row.getCell(k + 1).getStringCellValue();
						testData.put(attributeName, attributeValue);
						k++;
					}
				}
				inputSheetData.put(sheetName, testData);
			}
			return inputSheetData;
		} catch (Exception e) {
			throw new IelException(ERROR_READEXCEL + e.getMessage());
		}

	}
}
