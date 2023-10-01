package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//FileInputStream fis=new FileInputStream("C://Users//CSCSPV1156//Desktop//Advance_Selenium.xlsx");
FileInputStream fis=new FileInputStream("./src/test/resources/Advance_Selenium.xlsx");
Workbook book=WorkbookFactory.create(fis);
Sheet sheet=book.getSheet("Sheet1");
int rows=sheet.getLastRowNum();
System.out.println(rows);
LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
for (int i = 0; i <= rows; i++) {
	String key = sheet.getRow(i).getCell(0).toString();
	String value = sheet.getRow(i).getCell(1).toString();
	map.put(key, value);
}
  for (Entry<String, String>m:map.entrySet()) {
	  System.out.println(m.getKey()+" "+m.getValue());
	
}
	}

}
