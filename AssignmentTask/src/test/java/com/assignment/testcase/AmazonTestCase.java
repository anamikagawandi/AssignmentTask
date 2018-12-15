package com.assignment.testcase;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AmazonTestCase {
	
	CurrentTaskPage homePage;
	LoginPage loginPage;
	File file;
	
	public LoginPageTest()
	{
		super();
		file = ReadPropertyFileUtil.getLoginFileName();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage =new LoginPage();
	}



	@Test(dataProvider="readLoginCreds" , priority=3)
	public void validateLoginPageTest(String username, String password) 
	{
		homePage=loginPage.goToCurrentTaskPage(username,password);
		Assert.assertEquals(homePage.validateCurrentTaskPage(),"Current Task");
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}


}
