package com.assignment.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.assignment.base.TestBase;

public class SwiftCodePage extends TestBase{
	
	
	//Returns info of Malayasian banks
	public List<List<String>> getAllInfo()
	{
		List<List<String>> info=new ArrayList<List<String>>();
		List<WebElement> all_rows=driver.findElements(By.xpath("//table[@class='swift']//tr"));
		//int i=0;
		
		for(WebElement e:all_rows)
		{
			List<String> temp=new ArrayList<String>();
			List<WebElement> all_td =e.findElements(By.xpath("td"));
			//This will select only the rows with more than 1 <td> so as to avoid the <td> with advertisement
			if(all_td.size()>1)
			{
				//System.out.println("inside loop and proper rows: "+i+"   "+all_td.get(1).getText()+"      "+
				//		all_td.get(4).getText());
				
				temp.add(all_td.get(1).getText());
				temp.add(all_td.get(4).getText());
				info.add(temp);
				//i++;
			}
				
		}	
		return info;		
	}

}
