package com.assignment.testcase;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import com.assignment.base.*;
import com.assignment.pages.AmazonTestPage;


public class AmazonTestCase extends TestBase{
	
	
	AmazonTestPage amazon_page;
	
	//Constructor loads config file (in constructor of TestBase class) by using super method
	public AmazonTestCase()
	{
		super();
	}
	
	//initializes the driver by calling init method of TestBase
	@BeforeMethod
	public void setup()
	{
		initialization();
		driver.get(prop.getProperty("URL1"));
		amazon_page =new AmazonTestPage();
	}


	//Test to retrieve all product img href with advertisements
	@Test
	public void getAllImgHrefWithAd() 
	{
		
		List<WebElement> names=amazon_page.getAllImgHREFWithAd();
		int i=0;
		
		for(WebElement e : names)
		{
			i++;
			System.out.println("HREF "+i+": "+e.getAttribute("src"));
		}
	}
	
	//Test to retrieve all product img href without advertisements
	@Test
	public void getAllImgHref() 
	{
		
		List<WebElement> names=amazon_page.getImgHREF();
				
		int i=0;
		
		for(WebElement e : names)
		{
			i++;
			System.out.println("HREF "+i+": "+e.getAttribute("src"));
		}
	}
	
	
	
	//To quit browser after each test
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
