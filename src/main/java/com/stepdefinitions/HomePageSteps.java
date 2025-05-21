package com.stepdefinitions;

import com.obilet.base.BaseMethods;
import com.obilet.base.Browser;
import com.pages.FlightSearchPage;
import com.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePageSteps extends BaseMethods {
    HomePage homePage = new HomePage();

    private static final String DEPARTURE_DAY = "5";
    private static final String RETURN_DAY = "9";

    @Given("navigate to homepage")
    public void navigateToHomePage() {
        WebDriver driver = Browser.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        homePage.navigateToHomePage("https://www.obilet.com/");
    }

    @Then("control {string} home page title")
    public void checkHomePageTitle(String homePageTitle) {
        homePage.checkHomePageTitle(homePageTitle);
    }

    @When("click on the login button")
    public void clickLoginButton() {
        homePage.clickHomePageLoginButton();
    }

    @Then("verify registration pop-up is displayed")
    public void checkRegistrationPopupDisplayed() {
        homePage.checkRegistrationPopupDisplayed();
    }

    @And("click the sign-up button")
    public void clickRegisterButton() {
        homePage.clickLoginToRegisterButton();
    }

    @And("fill in random email and random password fields and click the sign-up button")
    public void fillRandomCredentialsAndSubmit() {
        String email = generateRandomEmail();
        String password = generateRandomPassword();

        System.out.println("Kullanılan email: " + email);
        System.out.println("Kullanılan şifre: " + password);

        homePage.fillTheUserCredentials(email, password);
    }

    @Then("verify new user successfully created")
    public void checkNewUserSuccessfullyCreated() {
        homePage.checkNewUserSuccessfullyCreated();
    }

    @After
    public void quitDriver() {
        Browser.quitDriver();
    }

    @When("click flight button")
    public void clickFlightTab() {
        homePage.clickFlightTab();
    }

    @And("select {string} departure and {string} destination")
    public void selectDepartureAndDestination(String departure, String destination) {
        homePage.selectDepartureCity(departure);
        homePage.selectDestinationCity(destination);
    }

    @And("select departure and return dates")
    public void selectRoundTripDate() {
        homePage.selectRoundTripDate(DEPARTURE_DAY, RETURN_DAY);
    }

    @And("click search button")
    public FlightSearchPage clickSearchButton() {
        homePage.clickSearchButton();
        return new FlightSearchPage();
    }

    @Then("verify the flight ticket search page is opened")
    public void checkFlightSearchPageOpened() {
        homePage.checkFlightSearchPageOpened();
    }
}

