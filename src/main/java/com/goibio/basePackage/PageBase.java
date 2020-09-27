package com.goibio.basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		//String script="return document.getElementById(\"gosuggest_inputSrc\").value;";

		String text=(String)js.executeScript(script);
		int i=0;
		while(!text.contains(srcValue))
		{
			i++;
			element.sendKeys(Keys.DOWN);
			text= (String) js.executeScript(script);
			if(i>8)
			{
				break;
			}
		}
		if(i>8)
		{
			System.out.println("Eelement not Found");
		}
		else
		{
			element.sendKeys(Keys.ENTER);			
		}

	}
	}

