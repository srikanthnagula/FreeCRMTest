package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties Prop;
	public TestBase()  {
			try {
			Prop =new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\sri\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			Prop.load(ip);
			} catch (FileNotFoundException e){
				e.printStackTrace();				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	public static void initialization() {
		String browserName = Prop.getProperty("browser");
				if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sri\\Desktop\\Automation\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\sri\\Desktop\\Automation\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
		
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(Prop.getProperty("url"));
			
	}
}
