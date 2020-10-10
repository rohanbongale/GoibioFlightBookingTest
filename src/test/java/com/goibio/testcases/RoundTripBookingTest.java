package com.goibio.testcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.goibio.base.BaseClass;
import com.goibio.pageobjects.FlightPaymentPage;
import com.goibio.pageobjects.FlightReviewPage;
import com.goibio.pageobjects.IndexPage;
import com.goibio.pageobjects.SearchResultPage;
import com.goibio.utility.Util;

import junit.framework.Assert;

public class RoundTripBookingTest extends BaseClass  {
	public static Logger log =LogManager.getLogger(RoundTripBookingTest.class.getName());
	IndexPage index;
	SearchResultPage searchresultpage;
	FlightReviewPage flightreviewpage;
	FlightPaymentPage flightpaymentpage;
	
	@BeforeTest()
	public void setup() throws IOException {
		driver=initializeDriver();
	}
	
	@DataProvider
	public Object[][] getFlightData() throws IOException{
		Object data[][]=Util.getdata("Test");
		return data;
	}
	
	@Test(priority=1)
	public void verifyingGoibioHomePageTitle() {
		index=new IndexPage(driver);
		String goibiotitle=index.getGoibioTitle();
		String actualtitle="Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off";
		Assert.assertEquals(actualtitle, goibiotitle);
		log.info("validating index PageTitle");
	}

	@Test(priority=2,dataProvider="getFlightData")
	public void roundTripFlightBookingTest(String svalue,String dvalue,String dDate,String rDate) throws InterruptedException {
		 index=new IndexPage(driver);
		 index.clickOnRoundTrip();
		 log.info("Successfully Clicked on RoundTrip Button");
		 index.Enteringsource(svalue);
		 log.info("Successfully Entered Source Value");
		 index.EnteringDestination(dvalue);
		 log.info("Successfully Entered Destination Value");
		 index.Selectdepaturedate(dDate);
		 log.info("Successfully Selected Depature Date");
		 index.Selectreturndate(rDate);
		 log.info("Successfully EnteredSource Value");
		 searchresultpage= index.ClickonSearchButton();
		 log.info("Clicked on Search Button");	 
		 searchresultpage.SortingPrice();
		 log.info("Sorted Price in Descending Order");
		 searchresultpage.SelectingFlight();
		 log.info("Selected Depature and Return Flights");
		 flightreviewpage=searchresultpage.clickOnBookBtn();
		 log.info("Clicked on Book Button"); 
		 flightreviewpage.SelectSecureTravelProection();
		 log.info("Selected Secureravell Protection");
		 flightreviewpage.EnteringTravellDetails("Mr","Rohan","S","Bongale","rohan@gmail.com","8899548941");
		 log.info("Entered Traveller Details");
		 flightpaymentpage=flightreviewpage.clickOnProceedBtn();
		 log.info("Clicked on Procced Buton"); 
		 flightpaymentpage.ClickOnCovid19pop();
		 log.info("Clicked OnCovid19pop Buton");		 
		 flightreviewpage.clickOnProceedToPaymentBtn();
		 log.info("Clicked Payment Buton");		  
		 flightpaymentpage.clickOnWallets();
		 log.info("Selected Amazon Pay Payment Method");
	}
	     	
		@AfterTest()
		public void teardown() {
			driver.quit();
			driver=null;
		}
	}
