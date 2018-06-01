package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		prop= new Properties();
		try {
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");		
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
	}
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\executables\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\executables\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true"); 
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null"); 		
			 driver = new FirefoxDriver();	
		}
		
		if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\executables\\MicrosoftWebDriver.exe");
			 driver=new EdgeDriver();
		}
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	

}
