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
	
	
	private String Scriptvaluescr="return document.getElementById(\"gosuggest_inputSrc\").value;";
	private String Scriptvaluedes="return document.getElementById(\"gosuggest_inputDest\").value;";
	
	
	@FindBy(xpath="//li[@class='active']/a")
	private WebElement filghts;
	
	@FindBy(css="[class='DayPicker-Caption']")
	private WebElement months;
	
	@FindBy(css="[class='DayPicker-NavButton DayPicker-NavButton--next']")
	private WebElement nextbtns;
	
	@FindBy(css="[class='calDate']")
	private List<WebElement> date;
	
	
	@FindBy(xpath="//span[@id='roundTrip']")
	private WebElement roundTrip;
	
	@FindBy(id="gosuggest_inputSrc")
	private WebElement source;
	
	@FindBy(id="gosuggest_inputDest")
	private WebElement dest;
	
	@FindBy(id="departureCalendar")
	private WebElement depcalender;
		
	@FindBy(id="returnCalendar")
	private WebElement returncal;
	
	@FindBy(id="gi_search_btn")
	private WebElement searchbtn;
		
	public IndexPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getGoibioTitle() {
		return driver.getTitle();
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
	
	
	public void Enteringsource(String srcvalue) throws InterruptedException {
		pagebase=new PageBase(driver);
		pagebase.AutosggestSource(source,srcvalue,Scriptvaluescr);
	}
	
	
	public void EnteringDestination(String desvalue) throws InterruptedException {
		pagebase=new PageBase(driver);
		pagebase.AutosggestSource(dest,desvalue,Scriptvaluedes);
	}
	
	public void Selectdepaturedate(String DepartureDate) throws InterruptedException {
		depcalender.click();
		pagebase=new PageBase(driver);
		pagebase.DatePicker(months,nextbtns,date,DepartureDate);
	}
	
	public void Selectreturndate(String ReturnDate) throws InterruptedException {
		returncal.click();
		pagebase=new PageBase(driver);
		pagebase.DatePicker(months,nextbtns,date,ReturnDate);
	}
	
	public SearchResultPage ClickonSearchButton() throws InterruptedException {
		searchbtn.click();
		try {
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
		 return new SearchResultPage(driver);
	}
	
}