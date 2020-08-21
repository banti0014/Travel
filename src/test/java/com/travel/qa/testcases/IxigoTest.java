package com.travel.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.travel.qa.base.TestBase;
import com.travel.qa.pages.AirlineFilterPage;
import com.travel.qa.pages.LandingPage;

public class IxigoTest extends TestBase {

	LandingPage landingpage;
	AirlineFilterPage airlinefilterpage;

	public IxigoTest() {
		super();
	}

	@BeforeSuite
	public void setUp() {
		initialization();
		landingpage = new LandingPage();
		airlinefilterpage = new AirlineFilterPage();
	}

	@Test(priority = 1)
	public void verifyLandingPageTitleTest() {
		String landingPageTitle = landingpage.verifyLandingPageTitle();
		Assert.assertEquals(landingPageTitle, prop.getProperty("landingPageTitle"), "Landing Page Title Has Matched.");
	}

	@Test(priority = 2)
	public void validateIxigoLogo() {
		boolean flag = landingpage.validateIXIGOImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void searchWithProperJounryDetails() throws InterruptedException {
		landingpage.selectFromDestination(prop.getProperty("fromDestination"));
		landingpage.selectToDestination(prop.getProperty("toDestination"));
		landingpage.startofJouneyDate(prop.getProperty("departure"));
		landingpage.returnofJouneyDate(prop.getProperty("return"));
		landingpage.selectPassenger(prop.getProperty("travelers"));
		airlinefilterpage = landingpage.clickOnSearch();
	}

	@Test(priority = 4)
	public void validateResultPage() throws InterruptedException {
		String airlinefilterPageTitle = airlinefilterpage.verifyAirlineFilterPageTitle();
		Assert.assertEquals(airlinefilterPageTitle, prop.getProperty("airlineFilterPageTitle"),
				"Airline Filter Page Title Has Matched.");
		boolean formFlag = airlinefilterpage.verifyFromDestination();
		Assert.assertEquals(formFlag, true, "Deperture From Has Matched.");
		boolean toFlag = airlinefilterpage.verifyToDestination();
		Assert.assertEquals(toFlag, true, "Deperture To Has Matched.");
		boolean depFlag = airlinefilterpage.verifyDepartureDate();
		Assert.assertEquals(depFlag, true, "Deperture Date Has Matched.");
		boolean returnFlag = airlinefilterpage.verifyReturnDate();
		Assert.assertEquals(returnFlag, true, "Return Date Has Matched.");
		boolean numbFlag = airlinefilterpage.verifyTravellerNumbers();
		Assert.assertEquals(numbFlag, true, "Number of Passenger(s) Has Matched.");

	}

	@Test(priority = 5)
	public void validateDifferentFillterOptions() throws InterruptedException {
		boolean filterStop = airlinefilterpage.availableFilters(prop.getProperty("filterStop"));
		Assert.assertEquals(filterStop, true, "Stop Filter is available.");
		boolean filterDeparture = airlinefilterpage.availableFilters(prop.getProperty("filterDeparture"));
		Assert.assertEquals(filterDeparture, true, "Deperture Filter is available.");
		boolean filterAirlines = airlinefilterpage.availableFilters(prop.getProperty("filterAirlines"));
		Assert.assertEquals(filterAirlines, true, "Airlines Filter is available.");
		boolean selectNonStop = airlinefilterpage.checkNonStopOption();
		Assert.assertEquals(selectNonStop, true, "Non-Stop option has been Selected.");

	}

	@Test(priority = 6)
	public void listOfAirlineDetailsWithFareLessThen5000() throws InterruptedException {
		airlinefilterpage.printFlightDetailsUnderCertainAmount(prop.getProperty("cellingFare"));
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
