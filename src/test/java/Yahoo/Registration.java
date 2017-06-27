package Yahoo;
//Yahoo Site Registration Page
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;

public class Registration extends Driverclass {
	Configfile conff = new Configfile();
	Row row;
	
	
	public void openAccount() throws Exception {
		
		// for all the rows in work sheet
		for (int r = 0; r <= Configfile.ws1.getLastRowNum(); r++) {
			// Read Each row
			row = Configfile.ws1.getRow(r); 
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			conff.launchWebsite();
			driver.findElement(By.id(Configfile.Param.getProperty("CreateAccount"))).click();
			driver.findElement(By.xpath(Configfile.Param.getProperty("SignUpText"))).isDisplayed();
			driver.findElement(By.id(Configfile.Param.getProperty("FirstName"))).sendKeys(row.getCell(0).getStringCellValue());
			driver.findElement(By.id(Configfile.Param.getProperty("LastName"))).sendKeys(row.getCell(1).getStringCellValue());
			driver.findElement(By.id(Configfile.Param.getProperty("UserName"))).sendKeys(row.getCell(2).getStringCellValue());
			driver.findElement(By.id(Configfile.Param.getProperty("Password"))).sendKeys(row.getCell(3).getStringCellValue());
			Configfile.DropDownSelection(".//*[@id='regform']/div[3]/div[2]/div/select");
			Configfile.mySelect.selectByIndex(95);
		}
		
	}

}