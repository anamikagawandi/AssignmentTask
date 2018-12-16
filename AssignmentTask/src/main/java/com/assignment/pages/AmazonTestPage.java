package com.assignment.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.assignment.base.TestBase;


//AmazonTestPage class contains methods to find list of elements
public class AmazonTestPage extends TestBase{
	
	
	//Returns list of product img WebElements including advertisements
	public  List<WebElement> getAllImgHREFWithAd()
	{
		//xpath will take img elements from div id=pageContent which contain .jpg
		List<WebElement> names = driver.findElements(By.xpath("//div[@id='pageContent']//img[(contains(@src,'.jpg'))]"));
		return names;		
		
	}
	
	//Returns list of product img WebElements excluding advertisements
	public List<WebElement> getImgHREF()
	{
		//css will take img elements for which class is product-image and src value ending with .jpg, ignoring any null values
		List<WebElement> names = driver.findElements(By.cssSelector(".product-image[src$=\".jpg\"]"));			
		return names;	
			
	}

}
