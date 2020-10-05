package com.goibio.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@class='button fr fltbook fb widthF105 quicks fb']")
	WebElement bookBtn;
	
	@FindBy(id="PRICE")
	List<WebElement> SortingPrice;
	
	@FindBy(xpath="//div[@class='fltHpyRWrap dF justifyBetween']/div[1]//span[@class='custRad']")
	WebElement selecdepflight;
	
	@FindBy(xpath="//div[@class='fltHpyRWrap dF justifyBetween']/div[2]//span[@class='custRad']")
	WebElement selecreturnflight;
	
	
	public SearchResultPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnBookBtn() throws InterruptedException {
		try {
			WebDriverWait w=new WebDriverWait(driver,30);
			SortingPrice.get(0).click();
			SortingPrice.get(1).click();

			selecdepflight.click();
			selecreturnflight.click();
			//w.until(ExpectedConditions.elementToBeClickable(bookBtn));
			bookBtn.click();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
}
