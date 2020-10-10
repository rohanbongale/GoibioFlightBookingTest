package com.goibio.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	
	public WebDriver driver;
	WebDriverWait w;
	
	@FindBy(xpath="//input[@class='button fr fltbook fb widthF105 quicks fb']")
	private WebElement bookBtn;
	
	@FindBy(xpath="//div[@class='clr'][1]/div/div[1]/div[1]/div[2]/span/span/input[1]")
	private WebElement onewaybookBtn;
	
	@FindBy(id="PRICE")
	private List<WebElement> SortingPrice;
	
	@FindBy(xpath="//div[@class='fltHpyRWrap dF justifyBetween']/div[1]//span[@class='custRad']")
	private WebElement selecdepflight;
	
	@FindBy(xpath="//div[@class='fltHpyRWrap dF justifyBetween']/div[2]//span[@class='custRad']")
	private WebElement selecreturnflight;
	
	
	public SearchResultPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void SortingPrice() {
		w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.elementToBeClickable(bookBtn));
		SortingPrice.get(0).click();
		SortingPrice.get(1).click();
	}
	
	public void SelectingFlight() {
		selecdepflight.click();
		selecreturnflight.click();
	}
	
	public FlightReviewPage clickOnBookBtn() throws InterruptedException {
		try {
			bookBtn.click();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}			
		return new FlightReviewPage(driver);
	}
	
	public FlightReviewPage clickOnOnewayBookBtn() throws InterruptedException {
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			onewaybookBtn.click();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return new FlightReviewPage(driver);
	}
	
}
