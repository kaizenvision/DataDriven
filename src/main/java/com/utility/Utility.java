package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.BaseClass;

public class Utility extends BaseClass {
	
	public static void implictWeight() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public Sheet getSheet(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fileInputStream = new FileInputStream(projectPath+"\\src\\main\\resources\\data\\orangeHr.xlsx");
		
		Sheet sh = WorkbookFactory.create(fileInputStream).getSheet(sheetName);
		
		return sh;
	}
	
	public Object getSingleData(int rowNum , int cellNum, Sheet sh) {
		
		if(sh.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("string"))
			return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		else
			return sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
	
	public HashMap<String, String> getAllExcelData(Sheet sh) {
		int rowCount = sh.getLastRowNum();
		HashMap<String, String> hm = new HashMap<>();
		Object[][] dataprovider =  new Object[rowCount][2];
		
		for(int i=1; i<=sh.getLastRowNum(); i++) {
			int cellNum = sh.getRow(i).getLastCellNum();
			for(int j=0; j<cellNum; j++) {
				
				hm.put(sh.getRow(i).getCell(j).getStringCellValue(), sh.getRow(i).getCell(++j).getStringCellValue());
				
			}
			
			
		}
		return hm;
	}

	public Object[][] getData(Sheet sh) {

		int rowCount = sh.getLastRowNum();

		Map<String, Object> finalData = new HashMap<>();

		Object[][] excelData = new Object[rowCount][1];


		for(int i=0; i<rowCount; i++) {

			Map<String, Object> data = new HashMap<>();

			int colNum = sh.getRow(i).getLastCellNum();

			for(int j=0; j<colNum; j++) {

				if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("string")) {
					data.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getStringCellValue());
				}
				else if(sh.getRow(i).getCell(j).getCellType().toString().equalsIgnoreCase("numeric")){
					data.put(sh.getRow(0).getCell(j).getStringCellValue(),
							sh.getRow(i+1).getCell(j).getNumericCellValue());
				}
				else {
					System.out.println("cell type not match..");
				}

			}

			excelData[i][0] = data;



			data.forEach(finalData::put);


		}

		return excelData;
	}

}
