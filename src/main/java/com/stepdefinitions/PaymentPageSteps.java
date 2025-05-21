package com.stepdefinitions;

import com.pages.PaymentPage;
import io.cucumber.java.en.And;

public class PaymentPageSteps {

    PaymentPage paymentPage = new PaymentPage();
    @And("check the payment page is opened")
    public void checkFlightList() {
        paymentPage.checkPaymentPageOpened();
    }

    @And("check departure and destination flights on the payment page")
    public void checkFlightsPaymentPage() {
        paymentPage.checkDepartureFlight();
        paymentPage.checkReturnFlight();
    }

}
