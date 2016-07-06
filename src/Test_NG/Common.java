package Test_NG;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

/**
 * Common functions
 * 
 * 
 * @author BichVT
 * 
 */

public class Common {
	public WebDriver driver;

	//init driver
	public Common(WebDriver dr){
		driver = dr;
	}

	//Open URL
	public void openUrl(String baseUrl) throws InterruptedException{
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	/**
	 * Get data from excel file to use for Login, Register account
	 * @author BichVT
	 * @date: create new 14-Jul-2016
	 * 
	 */
		public String getDataFromExcel(String excelFilePath, String sheetName, int rowNums, int colNums) throws IOException, InvalidFormatException {
			FileInputStream fis=new FileInputStream(excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);;
			Row row = sh.getRow(rowNums);
			Cell cell=row.getCell(colNums);
			String cellval = cell.getStringCellValue();
			//System.out.println(cellval);
			return(cellval);
		}

	//close URL
	public void closeUrl(){
		driver.close();
	}
}
