package com.pages;

import com.obilet.base.BaseMethods;
import com.obilet.base.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends BaseMethods {

    WebDriver driver;
    BaseMethods lib;

    public PaymentPage() {
        driver = Browser.getChromeDriver();
        PageFactory.initElements(driver, this);
        lib = new BaseMethods();
    }

    @FindBy(xpath = "(//*[@class='origin'])[1]")
    private List<WebElement> flightInfoOrigin;
    @FindBy(xpath = "(//*[@class='destination'])[1]")
    private List<WebElement> flightInfoDestination;
    @FindBy(css = "[id=payment]")
    private List<WebElement> formPayment;

    public void checkPaymentPageOpened() {
        lib.waitUntilElementsVisible(formPayment);
        lib.Control(lib.isElementExist(formPayment), "Odeme sayfasi acildi", "Hata! Odeme sayfasi acilamadi!");
    }

    public void checkDepartureFlight(){
        lib.Wait(1000);
        lib.Control(lib.isElementExist(flightInfoOrigin), "Gidis ucusu bulundu", "Hata! Gidis ucusu bulunamadi!");
        Logger.info(" Gidis ucusu: " + flightInfoOrigin.get(0).getText());
    }

    public void checkReturnFlight(){
        lib.Wait(1000);
        lib.Control(lib.isElementExist(flightInfoDestination), "Donus ucusu bulundu", "Hata! Donus ucusu bulunamadi!");
        Logger.info(" Donus ucusu: " + flightInfoDestination.get(0).getText());
    }


}
