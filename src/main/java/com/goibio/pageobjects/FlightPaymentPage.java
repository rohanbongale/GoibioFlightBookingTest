package com.goibio.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPaymentPage {
	
	public WebDriver driver;
	

	
	@FindBy(xpath="//div[@id='tab_wallet']")
	WebElement wallet;
	
	@FindBy(xpath="//div[@id='walletPayNow']//div[@class='col-md-8 col-sm-8 col-xs-8']")
	WebElement walletPayNow;
	
	
	@FindBy(xpath="//button[@class='button blue large fb padLR30']")
	WebElement OkBtn;
	
	public FlightPaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnWallets() {
		WebDriverWait w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.elementToBeClickable(wallet));
		wallet.click();
	}
	
	public void clickOnPayNow() {
		walletPayNow.click();
	}

	public void ClickOnCovid19pop() {
		OkBtn.click();
	}
	

}
