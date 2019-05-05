package com.model;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest 
{
	 public  WebDriver driver;
  
  @Test(priority=1)
  public void verifyoneway()
  {
	  WebElement oneway=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']"));
	  Assert.assertTrue(oneway.isSelected(), "oneway is selected");
	  System.out.println("oneway option is selected");
	  
  }
  @Test(priority=2)
  public void verifyroundtrip()
  {
	  WebElement roundtrip= driver.findElement((By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")));
	  Assert.assertFalse(roundtrip.isSelected(), "roundtrip is not selected");
	  System.out.println("roundtrip option is not selected");
  }
  @Test(priority=3)
  public void multicity()
  {
	  WebElement multicity=driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_2"));
	  Assert.assertTrue(multicity.isSelected(), "multicity is not selected");
	  System.out.println("multicity is not selected");
  }
  
  @BeforeMethod
  public void getallcookies() 
  {
	  
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
  }

  @AfterMethod
  public void capturescreenshot() throws IOException
  {
	  File src = (File)((TakesScreenshot)driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
	    
	  FileUtils.copyFileToDirectory(src, new File("C:\\Users\\dipak\\eclipse-workspace\\Testngassertions\\screenshot\\"));
	   
  }
  

  @BeforeClass
  public void maximizebrowser() 
  {
	  System.out.println("maximize browser");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void deleteallcookies() 
  {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void enterapplicationUrl()
  {
	  System.out.println("url is entered");
	  driver.get("https://www.spicejet.com/");
  }

  @AfterTest
  public void dbconnectionclose() 
  {
	  System.out.println("connection is established");
	  System.out.println("db connection is closed");
	  
  }

  @BeforeSuite
  public void Openbrowser()
  {
	  System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  System.out.println("chrome driver is openend successfully");
	  
  }

  @AfterSuite
  public void closebrowser() 
  {
	  driver.close();
	  
  }

}
