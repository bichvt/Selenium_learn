package Maven_project;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.sun.media.sound.InvalidFormatException;

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
	 * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 * @date: create new 14-Jul-2016
	 * 
	 */
		public String getDataFromExcel(String excelFilePath, String sheetName, int rowNums, int colNums) throws IOException, InvalidFormatException, EncryptedDocumentException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
			FileInputStream fis=new FileInputStream(excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);;
			Row row = sh.getRow(rowNums);
			Cell cell=row.getCell(colNums);
			String cellval = cell.getStringCellValue();
			//System.out.println(cellval);
			return(cellval);
		}
		public static String dbUrl= "jdbc:mysql://127.0.0.1:3306/selenium_study";
		public static String userDB = "root";
		public static String passDB = "root12345";
		public static String convertString;
		/**
		 * Add function to get data from local host database
		 * @author BichVT
		 * @date: create new 02-Aug-2016
		 * 
		 */
		public String executeQuery(String query, int columnIndex) throws ClassNotFoundException, SQLException{
			//Load mysql jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			//Create connection to DB
			Connection con = DriverManager.getConnection(dbUrl,userDB,passDB);
			//Create Statement Object		
			Statement stmt = con.createStatement();	
			// Execute the SQL Query. Store results in ResultSet		
			ResultSet rs= stmt.executeQuery(query);	
			while(rs.next()){
			convertString = rs.getString(columnIndex);
			//System.out.println(convertString);
			}
			return convertString;
			// closing DB Connection		
			//con.close();	
		} 


	//close URL
	public void closeUrl(){
		driver.close();
	}
}
