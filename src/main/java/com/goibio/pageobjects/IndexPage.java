package com.goibio.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.goibio.basePackage.PageBase;

public class IndexPage {

	public WebDriver driver;
	PageBase pagebase;
	
	String DepatureDate="20200928";
	String ReturnDate="20200929";
	String Scriptvaluescr="return document.getElementById(\"gosuggest_inputSrc\").value;";
	String Scriptvaluedes="return document.getElementById(\"gosuggest_inputDest\").value;";


	@FindBy(xpath="//li[@class='active']/a")
	WebElement filghts;
	
	@FindBy(xpath="//span[@id='roundTrip']")
	WebElement roundTrip;
	
	@FindBy(id="gosuggest_inputSrc")
	WebElement source;
	
	@FindBy(id="gosuggest_inputDest")
	WebElement dest;
	
	@FindBy(id="departureCalendar")
	WebElement depcalender;

	By DepaDate=By.id("fare_"+DepatureDate);
		
	@FindBy(id="returnCalendar")
	WebElement returncal;

	By Returndate=By.id("fare_"+ReturnDate);
	
	@FindBy(id="gi_search_btn")
	WebElement searchbtn;
		
	public IndexPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFlights() throws InterruptedException
	{
		filghts.click();
		Thread.sleep(5000l);
	}
	
	public void clickOnRoundTrip()
	{
		roundTrip.click();
	}
	
	
	public void Enteringsource() throws InterruptedException {
		pagebase=new PageBase(driver);
		pagebase.AutosggestSource(source,"Delhi (DEL)",Scriptvaluescr);
	}
	
	
	public void EnteringDestination() throws InterruptedException {
		pagebase=new PageBase(driver);
		pagebase.AutosggestSource(dest,"Mumbai (BOM)",Scriptvaluedes);
	}
	
	public void Selectdepaturedate() throws InterruptedException {
		depcalender.click();
		driver.findElement(DepaDate).click();
		
	}
	
	public void Selectreturndate() {
		returncal.click();
		driver.findElement(Returndate).click();
	}
	
	public void ClickonSearchButton() throws InterruptedException {
		searchbtn.click();
	}
	
}
