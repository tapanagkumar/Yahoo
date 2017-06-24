package Yahoo;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;

public class login extends Driverclass {

	Configfile conff = new Configfile();

	@SuppressWarnings({ "static-access", "deprecation" })
	public void LoginValidation() throws Exception {

		/*
		 * // Read the login details from excel sheet stored in resources folder
		 * 
		 * // file for reading the user name and password FileInputStream fin =
		 * new FileInputStream(
		 * "C:\\Users\\Gowri\\workspace\\Yahoo\\src\\test\\resources\\data.xlsx"
		 * );
		 * 
		 * XSSFWorkbook wb = new XSSFWorkbook(fin);
		 */
		// Get sheet in workbook

		// XSSFSheet ws = wb.getSheet("Sheet2");
		Row row;
		Cell cell;
		// for all the rows in work sheet
		for (int r = 1; r <= Configfile.ws.getLastRowNum(); r++)

		{
			row = Configfile.ws.getRow(r); // each row
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			// Launch the website undertest
			conff.launchWebsite();
			// Read username from cell 0 and put in the username field
			Thread.sleep(3000);
			cell = row.getCell(0, row.RETURN_BLANK_AS_NULL);
			if (cell == null)
				driver.findElement(By.id(Configfile.Param.getProperty("login.username.id"))).sendKeys("");
			else

				driver.findElement(By.id(Configfile.Param.getProperty("login.username.id")))
						.sendKeys(row.getCell(0).getStringCellValue());

			driver.findElement(By.id(Configfile.Param.getProperty("login.username.signin"))).click();
			byte[] decodedBytes = Base64.decodeBase64(row.getCell(1).getStringCellValue());
			// Read username from cell 1 and put in the username field
			cell = row.getCell(1, row.RETURN_BLANK_AS_NULL);
			if (cell == null)
				driver.findElement(By.id(Configfile.Param.getProperty("login.username.password"))).sendKeys("");
			else
				driver.findElement(By.id(Configfile.Param.getProperty("login.username.password")))
						.sendKeys(new String(decodedBytes));

			driver.findElement(By.id(Configfile.Param.getProperty("login.username.signin"))).click();

			try {
				if (driver.findElement(By.linkText(Configfile.Param.getProperty("Signout"))).isDisplayed()) {
					row.createCell(2).setCellValue("login is success");
					// driver.findElement(By.linkText("Sign Out")).click();
				}
			} catch (Exception e) {
				String str = driver.findElement(By.xpath(Configfile.Param.getProperty("LoginErrorMessage"))).getText();
				row.createCell(2).setCellValue(str);
			}

			Configfile.fin.close();
			Configfile.fout.close();

		}
	}
}
