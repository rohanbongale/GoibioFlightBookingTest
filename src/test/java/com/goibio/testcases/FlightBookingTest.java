package com.goibio.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goibio.base.BaseClass;
import com.goibio.pageobjects.FlightPaymentPage;
import com.goibio.pageobjects.FlightReviewPage;
import com.goibio.pageobjects.IndexPage;
import com.goibio.pageobjects.SearchResultPage;

public class FlightBookingTest extends BaseClass {

	
	@BeforeMethod()
	public void setup() throws IOException {
		driver=initializeDriver();
	}
	
	@Test()
	public void flightbooking() throws InterruptedException {
		//driver.findElement(By.xpath("//li[@class='active']/a")).click();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		Thread.sleep(1000l);
//		WebDriverWait d=new WebDriverWait(driver,20);
//		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='roundTrip']")));
//		
//		driver.findElement(By.xpath("//span[@id='roundTrip']")).click();
//		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("del");
//		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.ARROW_DOWN);
//		driver.findElement(By.id("gosuggest_inputSrc")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000l);
//		driver.findElement(By.id("gosuggest_inputDest")).sendKeys("bom");
//		driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.ARROW_DOWN);
//		driver.findElement(By.id("gosuggest_inputDest")).sendKeys(Keys.ENTER);
		 IndexPage index=new IndexPage(driver);
		 index.clickOnRoundTrip();	
		 index.Enteringsource();
		 index.EnteringDestination();
		 index.Selectdepaturedate();
		 index.Selectreturndate();
//		 index.ClickonSearchButton();
//
//		 SearchResultPage searchresultpage=new SearchResultPage(driver);
//		 searchresultpage.clickOnBookBtn();
// 		 
//		 FlightReviewPage flightreviewpage=new FlightReviewPage(driver);
//		 flightreviewpage.SelectSecureTravelProection();
//		 flightreviewpage.EnteringTravellDetails();
//		 //Thread.sleep(30000l);
//		 flightreviewpage.clickOnProceedBtn();
//		 FlightPaymentPage flightpaymentpage=new FlightPaymentPage(driver); 
//		 flightpaymentpage.ClickOnCovid19pop();
//		 flightreviewpage.clickOnProceedToPaymentBtn();
//		 //Thread.sleep(10000l);
//		 flightpaymentpage.clickOnWallets();
//		// Thread.sleep(5000l);
//		 flightpaymentpage.clickOnPayNow();	 
	}
	     
	
//		@AfterMethod()
//		public void teardown() {
//			driver.quit();
//		}
	}
	

