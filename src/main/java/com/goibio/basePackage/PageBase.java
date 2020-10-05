package com.goibio.basePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	public WebDriver driver;

	public PageBase(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void AutosggestSource(WebElement element,String srcValue,String scriptValue) throws InterruptedException {
		element.sendKeys(srcValue);
		Thread.sleep(5000l);
		element.sendKeys(Keys.DOWN);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script=scriptValue;
		String text=(String)js.executeScript(script);
		while(!text.contains(srcValue))
		{
			element.sendKeys(Keys.DOWN);
			text= (String) js.executeScript(script);
		}
			element.sendKeys(Keys.ENTER);			
	}
	
	public void DatePicker(WebElement month,WebElement nextbtn,List<WebElement> dates,String Date) throws InterruptedException 
	{	
		String[] arrOfStr = Date.split(" ",2);
		while(!month.getText().contains(arrOfStr[1]))
		{
			nextbtn.click();
		}
		int count=dates.size();
		for(int i=0;i<count;i++)
		{
			String text=dates.get(i).getText();
			String datesplited[]=text.split("\n");

			if(datesplited[0].equals(arrOfStr[0]))
			{			
				dates.get(i).click();
				break;
			}
		}
	}	
	
}

