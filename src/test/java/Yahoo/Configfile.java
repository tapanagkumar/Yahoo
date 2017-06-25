package Yahoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Configfile extends Driverclass{

	public static Properties Param;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFSheet ws1;
	public static FileInputStream fin;
	public static FileOutputStream fout;
	
	public void launchWebsite() throws Exception {
		
		driver.manage().window().maximize();
		driver.get(Configfile.Param.getProperty("URL"));
	}
	
	public void objrepo() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\Gowri\\workspace\\Yahoo\\Yahoo\\src\\test\\java\\Object_Repo.properties");
		// Create Properties class object to read properties file
		Param = new Properties();
		// Load file so we can use into our script
		Param.load(fis);
		System.out.println("Property class loaded");
		// Select workbook in the file
	}
	//Read from Excel
	public void ReadFromExcel() throws Exception
	{
		// Read the login details from excel sheet stored in resources folder

				// file for reading the user name and password
				 fin = new FileInputStream(
						"C:\\Users\\Gowri\\workspace\\Yahoo\\Yahoo\\src\\test\\resources\\data.xlsx");
				 wb = new XSSFWorkbook(fin);
				 ws = wb.getSheet("LoginDetails");
				 ws1=wb.getSheet("Registration");

				
		
	}
	//Write to Excel
	public void WritetoExcel() throws Exception
	{
		fout = new FileOutputStream(
				"C:\\Users\\Gowri\\workspace\\Yahoo\\Yahoo\\src\\test\\resources\\data.xlsx");
		Configfile.wb.write(fout);
	}
	}

