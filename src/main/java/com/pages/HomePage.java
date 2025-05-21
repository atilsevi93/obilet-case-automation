package com.pages;

import com.obilet.base.BaseMethods;
import com.obilet.base.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseMethods {
    WebDriver driver;
    BaseMethods lib;

    public HomePage() {
        driver = Browser.getChromeDriver();
        PageFactory.initElements(driver, this);
        lib = new BaseMethods();
    }

    @FindBy(css = "a.login")
    private List<WebElement> btnLogin;
    @FindBy(css = "button.login-to-register")
    private WebElement btnLoginToRegister;
    @FindBy(css = "input[name='email']")
    private WebElement txtEmail;
    @FindBy(css = "input[name='password']")
    private WebElement txtPassword;
    @FindBy(css = "button.register-button")
    private WebElement signUpButton;
    @FindBy(xpath = "//*[@id='login-form']")
    private List<WebElement> popUpLogin;
    @FindBy(css = "a.user-name")
    private WebElement userName;
    @FindBy(css = "a.user-name")
    private List<WebElement> userSignUpHeader;
    @FindBy(css = "form[id='search']")
    private List<WebElement> formSearch;
    @FindBy(css = "*[id='flight-search-features']")
    private List<WebElement> txtFlightFeatures;
    @FindBy(css = "#can-use-contract-information")
    private WebElement contractInformation;
    @FindBy(css = "a[data-event-action='Flight']")
    private WebElement flightTab;
    @FindBy(xpath = "//*[@id='origin-input']")
    private WebElement flightOrigin;
    @FindBy(css = "#origin > div.results")
    private WebElement flightOriginList;
    @FindBy(xpath = "//li[contains(@class, 'item') and normalize-space()='İstanbul Tümü']")
    private WebElement flightOriginAllAirport;
    @FindBy(css = "input#destination-input")
    private WebElement flightDestination;
    @FindBy(css = "*[id='two-ways']")
    private WebElement btnRoundTrip;
    @FindBy(css = "#destination > div.results")
    private WebElement flightDestinationList;
    @FindBy(xpath = "//li[contains(@class, 'item') and normalize-space()='Antalya Tümü']")
    private WebElement flightDestinationAllAirport;
    @FindBy(css = "div.departure div.input-group")
    private WebElement btnDepartureDate;
    @FindBy(css = "div.return div.input-group")
    private WebElement btnReturnDate;
    @FindBy(css = "div.double-picker")
    private WebElement datePicker;
    @FindBy(css = "[id='search-button']")
    private WebElement btnSearchFlight;
    @FindBy(css = "[id='direct']")
    private WebElement btnDirect;


    public void navigateToHomePage(String homeUrl) {
        lib.getUrl(homeUrl);
        lib.Control(lib.isElementExist(formSearch), "Anasayfa açıldı", "Hata! Anasayfa açılamadı!");
    }

    public void checkHomePageTitle(String homePageTitle) {
        String homePageTitleText = lib.getTitle();
        lib.Control(homePageTitleText.equals(homePageTitle), "Anasayfa açıldı", "Hata! Anasayfa açılamadı!");
        lib.Wait(500);
    }

    public void clickHomePageLoginButton() {
        lib.Control(lib.isElementExist(btnLogin), "Giriş butonu mevcut", "Hata! Giriş butonu bulunamadı!");
        lib.jsClick(btnLogin.get(0));
        lib.Wait(500);
    }

    public void checkRegistrationPopupDisplayed() {
        lib.Control(lib.isElementExist(popUpLogin), "Kullanıcı kayıt pop-up'ı başarıyla açıldı", "Hata! Kullanıcı kayıt pop-up'ı açılamadı!");
    }

    public void clickLoginToRegisterButton() {
        lib.waitElementToBeClicked(popUpLogin.get(0));
        lib.jsClick(btnLoginToRegister);
    }

    public void fillTheUserCredentials(String mail, String password) {
        lib.sendKeyCharacters(txtEmail, mail);
        lib.Wait(500);
        lib.sendKeyCharacters(txtPassword, password);
        lib.jsClick(signUpButton);
    }

    public void checkNewUserSuccessfullyCreated() {
        lib.Control(lib.isElementExist(userSignUpHeader), "Kullanıcı başarıyla oluşturuldu", "Hata! Kullanıcı oluşturulamadı!");
    }

    public void checkFlightSearchPageOpened() {
        lib.Control(lib.isElementExist(txtFlightFeatures), "Ucak bileti sayfası açıldı", "Hata! Ucak bileti sayfası açılamadı!");
    }

    public void clickFlightTab() {
        lib.jsClick(flightTab);
        Logger.info("Ucak bileti butonuna tiklandi");
    }

    public void selectDepartureCity(String origin) {

        lib.jsClick(flightOrigin);
        lib.sendKeyCharacters(flightOrigin, origin);
        lib.Wait(1000);
        flightOrigin.sendKeys(Keys.ARROW_DOWN);
        lib.Wait(1000);
        flightOrigin.sendKeys(Keys.ENTER);
    }

    public void selectDestinationCity(String destination) {

        lib.click(flightDestination);
        lib.sendKeyCharacters(flightDestination, destination);
        lib.Wait(1000);
        flightDestination.sendKeys(Keys.ARROW_DOWN);
        lib.Wait(1000);
        flightDestination.sendKeys(Keys.ENTER);
    }

    public void selectDate(String selectAfterDay) {

        int afterDay = Integer.parseInt(selectAfterDay);

        List<WebElement> days = lib.driver.findElements(By.xpath("//*[@data-date and not(@disabled)]"));
        WebElement firstDay = days.get(afterDay);
        lib.click(firstDay);
        lib.Wait(500);
    }

    public void selectRoundTripDate(String departureDay, String returnDay) {

        lib.click(btnDepartureDate);
        selectDate(departureDay);
        lib.click(btnReturnDate);
        selectDate(returnDay);
    }

    public void clickSearchButton() {
        lib.click(btnDirect);
        lib.click(btnSearchFlight);
        lib.Wait(500);
    }
}
