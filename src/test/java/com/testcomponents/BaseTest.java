package com.testcomponents;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pageobjects.LandingPage;

public class BaseTest {

	public static WebDriver driver;

	public static void getInitilization() throws Exception {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\katak\\eclipse-workspace\\New2024Pro\\src\\test\\java\\com\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public static LandingPage getInitialize() throws Exception {

		getInitilization();
		LandingPage lp = new LandingPage(driver);

		lp.goTo();
		return lp;

	}

}
