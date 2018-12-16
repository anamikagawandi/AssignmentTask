package com.assignment.testcase;


import java.util.Iterator;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.assignment.base.TestBase;
import com.assignment.pages.SwiftCodePage;

public class SwiftCodePageTest extends TestBase {
	
	SwiftCodePage swiftcode_page;
	
	//Constructor loads config file (in constructor of TestBase class) by using super method
	public SwiftCodePageTest()
	{
		super();
	}
	
	//initializes the driver by calling init method of TestBase
	@BeforeMethod
	public void setup()
	{
		initialization();
		driver.get(prop.getProperty("URL2"));
		swiftcode_page =new SwiftCodePage();
	}


	//Test to retrieve all info of Malayasian banks and their swiftcodes
	@Test
	public void getBankSwiftCodeInfo() 
	{
		int i=1;
		List<List<String>> info=swiftcode_page.getAllInfo();
		//System.out.println(info);
		
		Iterator<List<String>> it=info.iterator();
		
		while(it.hasNext())
		{
			List <String> temp=it.next();
			System.out.println(i+".Bank : "+temp.get(0)+"\t\tCode : "+temp.get(1));
			i++;			
		}
		
	}
	
	
	
	//To quit browser after each test
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}



}
