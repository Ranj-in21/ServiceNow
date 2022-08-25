package serviceNowTestNG;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SnExcelReadData {
	
	
	public static String[][] readData(String fileName) throws IOException {
		
		XSSFWorkbook wBook = new XSSFWorkbook("./ServiceNowData/"+fileName+".xlsx");
		
		XSSFSheet wSheet = wBook.getSheet("Sheet1");
		
		int rowCount = wSheet.getLastRowNum();
		System.out.println("Row Count: " +rowCount);
		
		short columnCount = wSheet.getRow(0).getLastCellNum();
		System.out.println("Column Count: " +columnCount);
		
		String[][] data = new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			
			for (int j = 0; j < columnCount; j++) {
				
				String stringCellValue = wSheet.getRow(i).getCell(j).getStringCellValue();
				
				data[i-1][j] = stringCellValue;
				
			}
			
		}
		
		wBook.close();
		return data;
		
	}
	
	
	

}
