package com.goibio.pageobjects;

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
	
	public SearchResultPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnBookBtn() throws InterruptedException {
		WebDriverWait w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.elementToBeClickable(bookBtn));
		bookBtn.click();
	}
	
	
}
