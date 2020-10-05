package com.goibio.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.goibio.basePackage.PageBase;

public class IndexPage {

	public WebDriver driver;
	PageBase pagebase;
	
	
	String Scriptvaluescr="return document.getElementById(\"gosuggest_inputSrc\").value;";
	String Scriptvaluedes="return document.getElementById(\"gosuggest_inputDest\").value;";
	String DepartureDate="9 November 2020";
	String ReturnDate="11 November 2020";
	
	@FindBy(xpath="//li[@class='active']/a")
	WebElement filghts;
	
	@FindBy(css="[class='DayPicker-Caption']")
	WebElement months;
	
	@FindBy(css="[class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement nextbtns;
	
	@FindBy(css="[class='calDate']")
	List<WebElement> date;
	
	
	@FindBy(xpath="//span[@id='roundTrip']")
	WebElement roundTrip;
	
	@FindBy(id="gosuggest_inputSrc")
	WebElement source;
	
	@FindBy(id="gosuggest_inputDest")
	WebElement dest;
	
	@FindBy(id="departureCalendar")
	WebElement depcalender;
		
	@FindBy(id="returnCalendar")
	WebElement returncal;
	
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
		pagebase=new PageBase(driver);
		pagebase.DatePicker(months,nextbtns,date,DepartureDate);
	}
	
	public void Selectreturndate() throws InterruptedException {
		returncal.click();
		pagebase=new PageBase(driver);
		pagebase.DatePicker(months,nextbtns,date,ReturnDate);
	}
	
	public void ClickonSearchButton() throws InterruptedException {
		searchbtn.click();
	/*	try {
			String alertmsg = driver.findElement(By.xpath("//span[@class='status_cont red ico13']")).getText();
			if (alertmsg.contains("Please enter a valid Source")) {
			    System.out.println("Enter Valid Source");
			}
			else if (alertmsg.contains("Please enter a valid Destination")) {
			    System.out.println("Enter Valid Destination");
			}
			else if (alertmsg.contains("Please enter a valid departure date")) {
			    System.out.println("Enter Valid departure date");
			}				         
		}
		catch (Exception e) {
			System.out.println(e);			
	      }
		
	}*/
	
}
}