package com.stepdefinitions;

import com.pages.FlightSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SearchPageSteps {

    FlightSearchPage flightSearchPageResultPage = new FlightSearchPage();

    @Then("check flight results are displayed")
    public void checkFlightList() {
        flightSearchPageResultPage.checkFlightResults();
    }

    @And("select random departure flight")
    public void selectDepartureFlight() {
        flightSearchPageResultPage.selectDepartureFlight();
    }

    @Then("check other classes for departure flight")
    public void checkDepartureFlightClasses() {
        flightSearchPageResultPage.checkDepartureFlightClass();
    }


    @And("select random return flight")
    public void selectReturnFlight() {
        flightSearchPageResultPage.selectReturnFlight();
    }

    @Then("check other classes for return flight")
    public void checkReturnFlightClasses() {
        flightSearchPageResultPage.checkReturnFlightClass();
    }
}
