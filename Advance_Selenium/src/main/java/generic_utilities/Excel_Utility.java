package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * This method is used to fetch data from ExcelSheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Rahul
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fes = new FileInputStream("./src/test/resources/Advance_Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fes);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String excelData = cell.getStringCellValue();
		return excelData ;

	}
	public String getExcelDataUsingDataFormatter(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fes = new FileInputStream("./src/test/resources/Advance_Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fes);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cell);
		return excelData;
	}
	public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, IOException{
		FileInputStream fes = new FileInputStream("./src/test/resources/Advance_Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fes);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj= new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow ; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
			
			
		}
		return obj;
	}

}
