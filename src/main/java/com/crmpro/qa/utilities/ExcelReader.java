package com.crmpro.qa.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.crmpro.qa.Base.TestBase;

public class ExcelReader extends TestBase {

	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;

	public String getData(String sheet) throws Exception {

		file = new File(
				"C:\\Users\\Admin\\workspace\\CRMProTest\\src\\main\\java\\com\\crmpro\\qa\\testdata\\NewTestData.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(sheet);

		int rowCount = sh.getLastRowNum();
		int colCount = sh.getRow(0).getLastCellNum();
		String data = null;

		for (int i = 0; i <= rowCount; i++) {
			for (int j = 0; j <= colCount; j++) {
				data = sh.getRow(i).getCell(j).toString();
			}
		}
		return data;

	}

}
