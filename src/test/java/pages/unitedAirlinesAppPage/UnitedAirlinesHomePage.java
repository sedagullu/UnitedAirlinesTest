package pages.unitedAirlinesAppPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitedAirlinesHomePage {

    public UnitedAirlinesHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='tablist']/a")
    public WebElement mainMenu;

    @FindBy(xpath = "//div[@class='app-components-BookTravel-bookTravel__bookTravel--1akdl']//li")
    public WebElement bookTravelMenu;

    @FindBy(xpath = "(//fieldset[@name='flightType']//span)[2]")
    public WebElement roundTripButton;

    @FindBy(xpath = "(//fieldset[@name='flightType']//span)[4]")
    public WebElement oneWayButton;

    @FindBy(css = "#award")
    public WebElement bookWithMilesCheckBox;

    @FindBy(css = "label[for='award']")
    public WebElement bookWithMileslLabel;

    @FindBy(css = "#flexDatesLabel")
    public WebElement flexibleDatesCheckBox;

    @FindBy(css = "label[for='flexibleDates']")
    public WebElement flexibleDatesLabel;

    @FindBy(xpath = "//input[@type='text'][1]")
    public WebElement fromWhereInput;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toWhereInput;

    @FindBy(id = "DepartDate")
    public WebElement dateInput;

    @FindBy(xpath = "//button[@aria-label='Move backward to switch to the previous month.']")
    public WebElement previousArrowIcon;

    @FindBy(xpath = "//*[@aria-label='Sunday, January 30, 2022']")
    public WebElement Jan30th;

    @FindBy(xpath = "//button[@aria-haspopup='dialog']")
    public WebElement travelSelector;

    @FindBy(xpath = "//button[text()='+']")
    public WebElement travelerPlusButton;

    @FindBy(id = "cabinType")
    public WebElement cabinType;
//
    @FindBy(xpath = "//li[@id='cabinType_item-2']")
    public WebElement businessOrFirst;

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement findFlightsButton;

    @FindBy(xpath = "//h2/div")
    public WebElement departureheading;
}
