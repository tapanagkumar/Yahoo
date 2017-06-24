package Yahoo;

import Yahoo.login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sanity extends Driverclass {
	Configfile co = new Configfile();

	@BeforeTest
	public void beforeTest() throws Exception {
		co.objrepo();
		System.out.println("OJB REP LOADED");
		co.ReadFromExcel();
		System.out.println("EXCEL FILE LOADED");
		co.WritetoExcel();
	}

	@Test
	@Parameters({ "browser" })
	public void sanitytesting(String str) throws Exception {

		if (str.matches("firefox")) {
			driver = new FirefoxDriver();
		}
		if (str.matches("chrome")) {
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		// Testing the Login Screen
		// login l = new login();
		// l.LoginValidation();
		Registration Regi = new Registration();
		Regi.openAccount();

	}

}
