package com.silicus.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriverConfig {

public static WebDriver driver = null;
	
	@Test
	@Parameters("BROWSER_CODE")
	public void config(String browserCode){
		
		switch (browserCode) {
		case "IE":{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\mtvaidya\\Documents\\Workspace\\Practice\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		}
		case "chrome" :{
			driver = new ChromeDriver();
			break;
		}
			
		default:{
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			break;
		}
		}
	}
	
	@Parameters("URL")
	public void uncheckHWAcceleration() throws Exception {
	   
	  }
	
	@AfterMethod
	@Parameters("URL")
	public void getURL(String URL){
		driver.get(URL + "about:preferences#advanced");
		driver.findElement(By.cssSelector("#category-advanced > label.category-name")).click();
		driver.findElement(By.id("allowHWAccel")).click();
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w");
		driver.get(URL);
		
	}
}
