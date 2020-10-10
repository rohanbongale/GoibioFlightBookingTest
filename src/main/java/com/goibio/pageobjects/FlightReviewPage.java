package com.goibio.pageobjects;

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
	private WebElement ProceedBtn;
	
	@FindBy(xpath="//span[@class='ico16 quicks f700']")
	private WebElement ProceedToPayment;
	
	@FindBy(xpath="//input[@id='risk-trip']")
	private WebElement RiskTrip;
	
	@FindBy(xpath="//select[@id='Adulttitle1']")
	private WebElement ChoosingTitle;
	
	@FindBy(id="AdultfirstName1")
	private WebElement Firstname;
	
	@FindBy(id="AdultmiddleName1")
	private WebElement Middlename;

	@FindBy(id="AdultlastName1")
	private WebElement Lastname;

	@FindBy(id="email")
	private WebElement CustomerEmail;

	@FindBy(id="mobile")
	private WebElement CustomerMnumber;
	
	@FindBy(xpath="//input[@id='secure-trip']")
	private WebElement SecureTrip;
			
	public FlightReviewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelectSecureTravelProection() throws InterruptedException {
		w=new WebDriverWait(driver,30);
		w.until(ExpectedConditions.elementToBeClickable(SecureTrip));
		SecureTrip.click();
		
	}
	
	public void SelectRiskTravelProection() {
		RiskTrip.click();
	}
		
	public void EnteringTravellDetails(String title,String Fname,String Mname,
			String Lname, String email,String MobNumber) 
	{
		Select s=new Select(ChoosingTitle);
		s.selectByVisibleText(title);
		Firstname.sendKeys(Fname);
		Middlename.sendKeys(Mname);
		Lastname.sendKeys(Lname);
		CustomerEmail.sendKeys(email);
		w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(CustomerMnumber));
		CustomerMnumber.sendKeys(MobNumber);				
	}
	
	public FlightPaymentPage clickOnProceedBtn() {
		ProceedBtn.click();
		return new FlightPaymentPage(driver);
	}
		
	public void clickOnProceedToPaymentBtn() {
		w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(ProceedToPayment));
		ProceedToPayment.click();
	}
	
}
