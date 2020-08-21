package com.travel.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.travel.qa.base.TestBase;

public class LandingPage extends TestBase {

	/***
	 * Locators
	 */
	@FindBy(id = "ixiLogoImg")
	WebElement ixigoLogo;
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[1]")
	WebElement txtbox_fromDestination;
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[2]")
	WebElement txtbox_toDestination;
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[3]")
	WebElement datepicker_journeyStartDate;
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[4]")
	WebElement datepicker_returnDate;
	@FindBy(xpath = "(//input[@class='c-input u-v-align-middle'])[5]")
	WebElement optionSelect_numberOfTravellers;
	@FindBy(xpath = "(//button[@class='c-btn u-link enabled'])[1]")
	WebElement button_Search;

	// Initializing the Page Objects:
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyLandingPageTitle() {
		System.out.println("Landing Page Title is: " + driver.getTitle());
		return driver.getTitle();
	}

	public boolean validateIXIGOImage() {
		return ixigoLogo.isDisplayed();
	}

	public void selectFromDestination(String destinationFrom) throws InterruptedException {
		txtbox_fromDestination.click();
		Thread.sleep(2000);
		txtbox_fromDestination.sendKeys(Keys.chord(Keys.CONTROL, "a"), destinationFrom);
		Thread.sleep(1000);
		txtbox_fromDestination.click();
		Thread.sleep(2000);
		txtbox_fromDestination.sendKeys(Keys.ENTER);
		System.out.println("Selected Destination From is: " + destinationFrom);

	}

	public void selectToDestination(String destinationTo) throws InterruptedException {
		txtbox_toDestination.click();
		Thread.sleep(2000);
		txtbox_toDestination.sendKeys(Keys.chord(Keys.CONTROL, "a"), destinationTo);
		Thread.sleep(1000);
		txtbox_toDestination.click();
		Thread.sleep(2000);
		txtbox_toDestination.sendKeys(Keys.ENTER);
		System.out.println("Selected Destination To is: " + destinationTo);
	}

	public void startofJouneyDate(String date) throws InterruptedException {

		datepicker_journeyStartDate.click();
		Thread.sleep(2000);
		// Converting of Date
		String dateConvert = convertingDate(date);
		Thread.sleep(2000);
		// Checking If the journey date is available in current month or need to go to
		// next month
		while (true) {
			List<WebElement> dateInDatePicker = driver
					.findElements(By.xpath("(//*[@data-date='" + dateConvert + "'])[1]"));
			if (dateInDatePicker.size() > 0) {
				dateInDatePicker.get(0).click();
				Thread.sleep(2000);
				break;
			} else {
				driver.findElement(By.xpath("//button[@class='ixi-icon-arrow rd-next']")).click();
			}
		}
		System.out.println("Journey Start Date is: " + date);
	}

	public void returnofJouneyDate(String date) throws InterruptedException {

		datepicker_returnDate.click();
		Thread.sleep(2000);
		// Converting of Date
		String dateConvert = convertingDate(date);
		Thread.sleep(2000);
		// Checking If the journey date is available in current month or need to go to
		// next month
		while (true) {
			List<WebElement> dateInDatePicker = driver
					.findElements(By.xpath("(//*[@data-date='" + dateConvert + "'])[2]"));
			if (dateInDatePicker.size() > 0) {
				dateInDatePicker.get(0).click();
				Thread.sleep(2000);
				break;
			} else {
				driver.findElement(By.xpath("//button[@class='ixi-icon-arrow rd-next']")).click();
			}
		}
		System.out.println("Journey Return Date is: " + date);
	}

	public AirlineFilterPage clickOnSearch() {
		button_Search.click();
		System.out.println("Clicked on Search Button. ");
		return new AirlineFilterPage();
	}

	public void selectPassenger(String number) throws InterruptedException {
		optionSelect_numberOfTravellers.click();
		Thread.sleep(2000);
		WebElement numberofPasserjars = driver.findElement(By.xpath("(//*[@data-val='" + number + "'])[1]"));
		if (numberofPasserjars.isDisplayed()) {
			numberofPasserjars.click();
			Thread.sleep(5000);
			System.out.println("Number Of Passengers Selected: " + number);
		} else {
			System.out.println("Please Select Valid Number Of Passengers.");
		}
	}

}
