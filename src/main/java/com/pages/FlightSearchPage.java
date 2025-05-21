package com.pages;

import com.obilet.base.BaseMethods;
import com.obilet.base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class FlightSearchPage extends BaseMethods {

    WebDriver driver;
    BaseMethods lib;

    public final Random random = new Random();

    public FlightSearchPage() {
        driver = Browser.getChromeDriver();
        PageFactory.initElements(driver, this);
        lib = new BaseMethods();
    }

    @FindBy(xpath = "//*[@id='outbound-journeys']//li//li")
    private List<WebElement> listDepartureFlightResults;
    @FindBy(xpath = "//*[@id='return-journeys']//li//li")
    private List<WebElement> listReturnFlightResults;
    @FindBy(xpath = "//*[@id='outbound-journeys']//li//li//ul//li")
    private List<WebElement> listDepartureFlightClass;
    @FindBy(xpath = "//*[@class='flys']//li[1]")
    private WebElement btnEcoFlightDeparture;
    @FindBy(xpath = "//*[@id='return-journeys']//li//li//ul//li[1]")
    private WebElement btnEcoFlightReturn;
    @FindBy(xpath = "//*[@id='return-journeys']//li//li//ul//li")
    private List<WebElement> listReturnFlightClass;

    public void checkFlightResults() {
        lib.Wait(500);
        lib.Control(lib.isElementExist(listDepartureFlightResults), "Ucuslar listelendi", "Hata! Ucuslar listelenirken hata olustu");
    }

    public void selectDepartureFlight() {
        int randomDepartureFlights = random.nextInt(listDepartureFlightResults.size());
        lib.click(listDepartureFlightResults.get(randomDepartureFlights));
    }

    public void checkDepartureFlightClass() {
        lib.waitUntilElementsVisible(listDepartureFlightClass);
        lib.Control(lib.isElementExist(listDepartureFlightClass), "Ucuslarda " + listDepartureFlightClass.size() + " adet gidis ucus sinifi listelendi", "Hata! Siniflar listelenirken hata olustu");
        lib.click(btnEcoFlightDeparture);
    }

    public void selectReturnFlight() {
        int randomReturnFlights = random.nextInt(listReturnFlightResults.size());
        lib.click(listReturnFlightResults.get(randomReturnFlights));
    }

    public void checkReturnFlightClass() {
        lib.waitUntilElementsVisible(listReturnFlightClass);
        lib.Control(lib.isElementExist(listReturnFlightClass), "Ucuslarda " + listReturnFlightClass.size() + " adet donus ucus sinifi listelendi", "Hata! Siniflar listelenirken hata olustu");
        lib.click(btnEcoFlightReturn);
        lib.Wait(500);
    }

}
