# Travel Repo

## Write a program to automate following scenario :

	-Launch https://www.ixigo.com/
	-Validate the page
	-Enter From – Pune , To – Hyderabad , Departure – 17 Sep 2020 , Return – 24 Oct 2020 , Travelers - 2
	-Click on Search, Validate the result page
	-Validate filter option for Stops, departure and Airlines – Select Non-Stop in Stops filter option
	-Print the list of airlines details (Only Airline Number, Departure Time and Fare) having fare < 5000
	-Note – Create a Maven project using POM design pattern and Use TestNG as a framework
 
## Output:

	[RemoteTestNG] detected TestNG version 6.11.0
	[TestNGContentHandler] [WARN] It is strongly recommended to add "<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >" at the top of your file, otherwise TestNG may fail or not work as expected.
	Starting ChromeDriver 2.40.565498 (ea082db3280dd6843ebfb08a625e3eb905c4f5ab) on port 34815
	Only local connections are allowed.
	Aug 21, 2020 11:44:28 AM org.openqa.selenium.remote.ProtocolHandshake createSession
	INFO: Detected dialect: OSS
	Landing Page Title is: ixigo - Flights, Train Reservation, Hotels, Air Tickets, Bus Booking
	Selected Destination From is: Pune
	Selected Destination To is: Hyderabad
	Journey Start Date is: 17 Sep 2020
	Journey Return Date is: 24 Oct 2020
	Number Of Passengers Selected: 2
	Clicked on Search Button. 
	Airline Filter Page Title is: Pune - Hyderabad, Economy Flights, roundtrip, 17 Sep - 24 Oct
	Actual Destination:'PNQ - Pune' & Expected Destination:'Pune' are matching.
	Actual Destination:'HYD - Hyderabad' & Expected Destination:'Hyderabad' are matching.
	Actual Destination:'17 Sep' & Expected Destination:'17 Sep 2020' are matching.
	Actual Destination:'24 Oct' & Expected Destination:'24 Oct 2020' are matching.
	Actual Destination:'2 Passengers' & Expected Destination:'2' are matching.
	Filter Name: 'Stops' available.
	Filter Name: 'Departure from PNQ' available.
	Filter Name: 'Airlines' available.
	Non-Stop checkbox has been selected under Stops filter.
	---------------------------
	1.
	Flight Number: IndiGo  6E122
	Departure Time: 00:10
	Flight Fare: 3160
	---------------------------
	---------------------------
	2.
	Flight Number: IndiGo  6E242
	Departure Time: 04:20
	Flight Fare: 3160
	---------------------------
	---------------------------
	3.
	Flight Number: IndiGo  6E587
	Departure Time: 16:15
	Flight Fare: 3160
	---------------------------
	---------------------------
	4.
	Flight Number: Air India  AI9888
	Departure Time: 20:00
	Flight Fare: 3973
	---------------------------
	---------------------------
	5.
	Flight Number: SpiceJet  SG2760
	Departure Time: 22:35
	Flight Fare: 3772
	---------------------------
	---------------------------
	6.
	Flight Number: IndiGo  6E241
	Departure Time: 02:30
	Flight Fare: 3774
	---------------------------
	---------------------------
	7.
	Flight Number: IndiGo  6E118
	Departure Time: 22:15
	Flight Fare: 3774
	---------------------------
	PASSED: verifyLandingPageTitleTest
	PASSED: validateIxigoLogo
	PASSED: searchWithProperJounryDetails
	PASSED: validateResultPage
	PASSED: validateDifferentFillterOptions
	PASSED: listOfAirlineDetailsWithFareLessThen5000
	
	===============================================
	    Default test
	    Tests run: 6, Failures: 0, Skips: 0
	===============================================
	
	
	===============================================
	Default suite
	Total tests run: 6, Failures: 0, Skips: 0
	===============================================
	
		

