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

    @FindBy(xpath = "//input[@type='checkbox'][1]")
    public WebElement bookWithMilesCheckBox;

    @FindBy(xpath = "//input[@type='checkbox'][2]")
    public WebElement flexibleDatesCheckBox;

    @FindBy(xpath = "//input[@type='text'][1]")
    public WebElement fromWhereInput;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement toWhereInput;

    @FindBy(id = "DepartDate")
    public WebElement dateInput;

    @FindBy(xpath = "//button[@aria-haspopup='dialog']")
    public WebElement travelSelector;

    @FindBy(xpath = "//button[text()='+']")
    public WebElement travelerPlusButton;

    @FindBy(id = "cabinType")
    public WebElement cabinType;

    @FindBy(xpath = "//li[@id='cabinType_item-2']")
    public WebElement businessOrFirst;

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement findFlightsButton;

    @FindBy(xpath = "//h2[1]")
    public WebElement departureheading;
}
