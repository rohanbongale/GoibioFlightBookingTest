package com.goibio.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		 IndexPage index=new IndexPage(driver);
		 index.clickOnRoundTrip();	
		 index.Enteringsource();
		 index.EnteringDestination();
		 index.Selectdepaturedate();
		 index.Selectreturndate();
		 index.ClickonSearchButton();
		 Thread.sleep(10000l);	
		 
		 SearchResultPage searchresultpage=new SearchResultPage(driver);
		 searchresultpage.clickOnBookBtn();
		 
		 FlightReviewPage flightreviewpage=new FlightReviewPage(driver);
		 flightreviewpage.SelectSecureTravelProection();
		 flightreviewpage.EnteringTravellDetails();
		 flightreviewpage.clickOnProceedBtn();
	
		 FlightPaymentPage flightpaymentpage=new FlightPaymentPage(driver); 
		 flightpaymentpage.ClickOnCovid19pop();
		 flightreviewpage.clickOnProceedToPaymentBtn();
		 flightpaymentpage.clickOnWallets();
	//	 flightpaymentpage.clickOnPayNow();	 
	}
	     	
//		@AfterMethod()
//		public void teardown() {
//			driver.quit();
//		}
	}
