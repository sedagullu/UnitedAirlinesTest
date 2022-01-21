package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.unitedAirlinesAppPage.UnitedAirlinesHomePage;
import texts.ExpectedTextsForUnitedAirlinesApp;
import utilities.ConfigReader;
import utilities.Waiter;

public class UnitedAirlinesTest extends Base {

    /*
Test Case 1: Validate "Main menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see “Main menu” navigation items
|BOOK                              |
|MY TRIPS                          |
|TRAVEL INFO            |
|MILEAGEPLUS® PROGRAM|
|DEALS                             |
|HELP                              |
     */
    @Test(testName = "Validate Main menu", priority = 1)
    public void ValidateMainMenu() {
        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));
        Assert.assertTrue(unitedAirlinesHomePage.mainMenu.isDisplayed());
    }

    /*
Test Case 2: Validate "Book travel menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see "Book travel menu" navigation items
|Book             |
|Flight Status|
|Check-in       |
|My trips        |
     */
    @Test(testName = "Validate Book travel menu", priority = 2)
    public void ValidateBookTravelMenu() {
        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        Assert.assertTrue(unitedAirlinesHomePage.bookTravelMenu.isDisplayed());
    }

    /*
Test Case 3: Validate "Round-trip" and "One-way" radio buttons
Given user is on "https://www.united.com/en/us"
Then validate "Roundtrip" radio button is displayed, is enabled and is selected
And validate "One-way" radio button is displayed, is enabled but is not selected
When user clicks on "One-way" radio button
Then validate "One-way" radio button is selected while "Roundtrip" radio button is
deselected
     */
    @Test(testName = "Validate Round-trip and One-way radio buttons", priority = 3)
    public void ValidateRoundTripAndOneWayButtons() {
        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        Assert.assertTrue(unitedAirlinesHomePage.roundTripButton.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.roundTripButton.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.roundTripButton.isSelected());

        Assert.assertTrue(unitedAirlinesHomePage.oneWayButton.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.oneWayButton.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.oneWayButton.isSelected());

        unitedAirlinesHomePage.oneWayButton.click();
        Waiter.pause(4);
        Assert.assertFalse(unitedAirlinesHomePage.roundTripButton.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.oneWayButton.isSelected());
    }

    /*
Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
Given user is on "https://www.united.com/en/us"
Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
When user clicks both checkboxes
Then validate both checkboxes are selected
When user clicks on both selected checkboxes again
Then validate both checkboxes are deselected
     */
    @Test(testName = "Validate Book with miles and Flexible dates checkboxes", priority = 4)
    public void ValidateBookWithMilesAndFlexibleDatesCheckBoxes() {
        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));

        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());

        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isDisplayed());
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());

        unitedAirlinesHomePage.bookWithMilesCheckBox.click();
        unitedAirlinesHomePage.flexibleDatesCheckBox.click();
        Waiter.pause(4);
        Assert.assertTrue(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());
        Assert.assertTrue(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());

        unitedAirlinesHomePage.bookWithMilesCheckBox.click();
        unitedAirlinesHomePage.flexibleDatesCheckBox.click();
        Waiter.pause(4);
        Assert.assertFalse(unitedAirlinesHomePage.bookWithMilesCheckBox.isSelected());
        Assert.assertFalse(unitedAirlinesHomePage.flexibleDatesCheckBox.isSelected());
    }

    /*
    Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to
    Miami, FL, US (MIA)”
    Given user is on "https://www.united.com/en/us"
    When user selects "One-way" ticket radio button
    And user enters "Chicago, IL, US (ORD)" to from input box
    And user enters "" to to input box
    And user selects "Jan 30" to the dates input box
    And user selects "2 Adults" from travelers selector
    And user selects "Business or First" from cabin dropdown
    And user clicks on "Find Flights" button
    Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
     */
    @Test(testName = "Validate One-way ticket search results", priority = 5)
    public void ValidateOneWayTicketResult() {
        driver.get(ConfigReader.getProperty("unitedAirlinesURL"));
        unitedAirlinesHomePage.oneWayButton.click();
        unitedAirlinesHomePage.fromWhereInput.sendKeys(ExpectedTextsForUnitedAirlinesApp.fromWhere);
        unitedAirlinesHomePage.toWhereInput.sendKeys(ExpectedTextsForUnitedAirlinesApp.toWhere);
        Waiter.pause(4);
        unitedAirlinesHomePage.dateInput.clear();

        unitedAirlinesHomePage.travelSelector.click();
        unitedAirlinesHomePage.travelerPlusButton.click();
        unitedAirlinesHomePage.businessOrFirst.click();
        Waiter.pause(4);
        unitedAirlinesHomePage.findFlightsButton.click();

        String mainWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) driver.switchTo().window(windowHandle);
        }
        String mainWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(mainWindowHandle);
        Assert.assertEquals(unitedAirlinesHomePage.departureheading.getText(), ExpectedTextsForUnitedAirlinesApp.departureMessage);

    }
}
