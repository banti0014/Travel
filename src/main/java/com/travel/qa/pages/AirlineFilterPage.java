package com.travel.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.travel.qa.base.TestBase;

public class AirlineFilterPage extends TestBase {
	/***
	 * Locators
	 */

	@FindBy(xpath = "(//input[@placeholder='Enter city or airport'])[1]")
	WebElement value_fromDestination;
	@FindBy(xpath = "(//input[@placeholder='Enter city or airport'])[2]")
	WebElement value_toDestination;
	@FindBy(xpath = "//input[@placeholder='Depart']")
	WebElement value_datepicker_journeyStartDate;
	@FindBy(xpath = "//input[@placeholder='Return']")
	WebElement value_atepicker_returnDate;
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[5]")
	WebElement value_numberOfTravellers;
	@FindBy(xpath = "(//span[contains(@class,'ixi-icon-tick check-icon')])[1]")
	WebElement checkbox_NonStop;
	@FindBys({ @FindBy(xpath = "//div[@class='airline-text']/div") })
	List<WebElement> listOf_AirlineNumbers;
	@FindBys({ @FindBy(xpath = "//div[@class='time'][1]") })
	List<WebElement> listOf_DepartureTime;
	@FindBys({ @FindBy(xpath = "//div[@class='price-group']//div/span[2]") })
	List<WebElement> listOf_Fare;
	@FindBys({ @FindBy(xpath = "//div[@class='fltr-hdr']") })
	List<WebElement> listofFilters;
	@FindBy(xpath = "//div[@class='more-fltrs u-link']")
	WebElement button_moreFilters;

	// Initializing the Page Objects:
	public AirlineFilterPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyAirlineFilterPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Airline Filter Page Title is: " + driver.getTitle());
		return driver.getTitle();
	}

	public boolean verifyFromDestination() {
		boolean flag = false;
		String destination = value_fromDestination.getAttribute("value");
		if (destination.contains(prop.getProperty("fromDestination"))) {
			flag = true;
			System.out.println("Actual Destination:'" + destination + "' & Expected Destination:'"
					+ prop.getProperty("fromDestination") + "' are matching.");
		} else {
			flag = false;
			System.out.println("Actual Destination:'" + destination + "' & Expected Destination:'"
					+ prop.getProperty("fromDestination") + "' are not matching.");

		}
		return flag;

	}

	public boolean verifyToDestination() {
		boolean flag = false;
		String destination = value_toDestination.getAttribute("value");
		if (destination.contains(prop.getProperty("toDestination"))) {
			flag = true;
			System.out.println("Actual Destination:'" + destination + "' & Expected Destination:'"
					+ prop.getProperty("toDestination") + "' are matching.");
		} else {
			flag = false;
			System.out.println("Actual Destination:'" + destination + "' & Expected Destination:'"
					+ prop.getProperty("toDestination") + "' are not matching.");

		}
		return flag;

	}

	public boolean verifyDepartureDate() {
		boolean flag = false;
		String[] destination = value_datepicker_journeyStartDate.getAttribute("value").split(",");
		if ((prop.getProperty("departure")).contains(destination[0])) {
			flag = true;
			System.out.println("Actual Destination:'" + destination[0] + "' & Expected Destination:'"
					+ prop.getProperty("departure") + "' are matching.");
		} else {
			flag = false;
			System.out.println("Actual Destination:'" + destination[0] + "' & Expected Destination:'"
					+ prop.getProperty("departure") + "' are not matching.");

		}
		return flag;

	}

	public boolean verifyReturnDate() {
		boolean flag = false;
		String[] destination = value_atepicker_returnDate.getAttribute("value").split(",");
		if ((prop.getProperty("return")).contains(destination[0])) {
			flag = true;
			System.out.println("Actual Destination:'" + destination[0] + "' & Expected Destination:'"
					+ prop.getProperty("return") + "' are matching.");
		} else {
			flag = false;
			System.out.println("Actual Destination:'" + destination[0] + "' & Expected Destination:'"
					+ prop.getProperty("return") + "' are not matching.");

		}
		return flag;

	}

	public boolean verifyTravellerNumbers() {
		boolean flag = false;
		String[] destination = value_numberOfTravellers.getAttribute("value").split(",");
		if (destination[0].contains(prop.getProperty("travelers"))) {
			flag = true;
			System.out.println("Actual Destination:'" + destination[0] + "' & Expected Destination:'"
					+ prop.getProperty("travelers") + "' are matching.");
		} else {
			flag = false;
			System.out.println("Actual Destination:'" + destination[0] + "' & Expected Destination:'"
					+ prop.getProperty("travelers") + "' are not matching.");
		}
		return flag;

	}

	public boolean availableFilters(String filterName) throws InterruptedException {
		boolean flag = false;
		Thread.sleep(2000);
		for (WebElement e : listofFilters) {
			if (e.getAttribute("textContent").contains(filterName)) {
				flag = true;
				System.out.println("Filter Name: '" + e.getAttribute("textContent") + "' available.");
				break;
			}

		}
		return flag;
	}

	public boolean checkNonStopOption() throws InterruptedException {
		boolean flag = false;
		if (checkbox_NonStop.isDisplayed() && !checkbox_NonStop.isSelected()) {
			checkbox_NonStop.click();
			Thread.sleep(2000);

			flag = true;
			System.out.println("Non-Stop checkbox has been selected under Stops filter.");
		} else {
			flag = false;
			System.out.println("Non-Stop checkbox has NOT been selected under Stops filter.");
		}

		return flag;
	}

	public void printFlightDetailsUnderCertainAmount(String maxAmount) throws InterruptedException {

		for (int i = 0; i < listOf_Fare.size(); i++) {
			String fare = listOf_Fare.get(i).getAttribute("textContent");
			if ((Integer.parseInt(maxAmount) > 0) && (Integer.parseInt(fare) > 0)
					&& (Integer.parseInt(maxAmount) > Integer.parseInt(fare))) {
				System.out.println("---------------------------");
				System.out.println((i + 1) + ".");
				System.out.println("Flight Number: " + listOf_AirlineNumbers.get(i).getAttribute("textContent"));
				System.out.println("Departure Time: " + listOf_DepartureTime.get(i).getAttribute("textContent"));
				System.out.println("Flight Fare: " + listOf_Fare.get(i).getAttribute("textContent"));
				System.out.println("---------------------------");
			}
		}

	}
}
