package com.goibio.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightReviewPage {

	public WebDriver driver;
	WebDriverWait w;


	
	@FindBy(xpath="//button[@class='button orange col-md-3 fr large dF justifyCenter min37']")
	WebElement ProceedBtn;
	
	@FindBy(xpath="//span[@class='ico16 quicks f700']")
	WebElement ProceedToPayment;
	
	@FindBy(xpath="//input[@id='risk-trip']")
	WebElement RiskTrip;
	
	@FindBy(xpath="//select[@id='Adulttitle1']")
	WebElement ChoosingTitle;
	
	@FindBy(id="AdultfirstName1")
	WebElement Firstname;
	
	@FindBy(id="AdultmiddleName1")
	WebElement Middlename;

	@FindBy(id="AdultlastName1")
	WebElement Lastname;

	@FindBy(id="email")
	WebElement CustomerEmail;

	@FindBy(id="mobile")
	WebElement CustomerMnumber;

	
	@FindBy(xpath="//input[@id='secure-trip']")
	WebElement SecureTrip;
	
	
	
	public FlightReviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelectSecureTravelProection() throws InterruptedException {
		//Thread.sleep(30000l);
		w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.elementToBeClickable(SecureTrip));
		SecureTrip.click();
		
	}
	
	public void SelectRiskTravelProection() {
		RiskTrip.click();
	}
	
	
	public void EnteringTravellDetails() {
		Select s=new Select(ChoosingTitle);
		s.selectByVisibleText("Mr");
		//s.selectByValue("Mr");
		//s.selectByIndex(2);
		Firstname.sendKeys("Rohan");
		Middlename.sendKeys("S");
		Lastname.sendKeys("Bongale");
		CustomerEmail.sendKeys("rohan@gmail.com");
		w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(CustomerMnumber));
		CustomerMnumber.sendKeys("9945545567");				
	}
	
	public void clickOnProceedBtn() {
		ProceedBtn.click();
	}
	
	
	public void clickOnProceedToPaymentBtn() {
		w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(ProceedToPayment));
		ProceedToPayment.click();
	}
	
	
	
}
