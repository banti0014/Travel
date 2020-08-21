package com.travel.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.travel.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/travel" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/src/main/resources/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	public static String getProperty(String propertyName) {
		String propertyvalue = null;
		try {
			propertyvalue = prop.getProperty(propertyName);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return propertyvalue;

	}

	public static String convertingDate(String dateneedstoconvert) {
		String myFormat = "ddMMyyyy";
		String finalString = "";
		try {
			DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
			Date date = (Date) formatter.parse(dateneedstoconvert);
			SimpleDateFormat newFormat = new SimpleDateFormat(myFormat);
			finalString = newFormat.format(date);
			return finalString;
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Not able to convert the date. " + "Please provide date as 'dd MMM yyyy' format. ");
			return null;
		}
	}

}
