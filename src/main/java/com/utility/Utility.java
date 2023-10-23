package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	
	public Object[][] getAllExcelData(Sheet sh) {
		int rowCount = sh.getLastRowNum();
		HashMap<String, String> hm = new HashMap<>();
		Object[][] dataprovider =  new Object[rowCount][2];
		
		for(int i=1; i<=sh.getLastRowNum(); i++) {
			int cellNum = sh.getRow(i).getLastCellNum();
			for(int j=0; j<cellNum; j++) {
				
				hm.put(sh.getRow(i).getCell(j).getStringCellValue(), sh.getRow(i).getCell(++j).getStringCellValue());
				
			}
			
			
		}
		int i = 0;
		for(Map.Entry<String, String> map : hm.entrySet() ) {
			while(rowCount>0) {
				dataprovider[i][0] = map.getKey();
				dataprovider[i][1] = map.getValue();
			}
		}
		
		return dataprovider;
	}

}
