package Yahoo;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;

public class Registration extends Driverclass {
	Configfile conff = new Configfile();

	public void openAccount() throws Exception {

		Row row;

		// for all the rows in work sheet
		for (int r = 0; r <= Configfile.ws1.getLastRowNum(); r++) {
			row = Configfile.ws.getRow(r); // each row
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			conff.launchWebsite();
			driver.findElement(By.id(Configfile.Param.getProperty("CreateAccount"))).click();

		}
	}

}