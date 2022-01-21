package scripts;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.unitedAirlinesAppPage.UnitedAirlinesHomePage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    Faker faker;
    UnitedAirlinesHomePage unitedAirlinesHomePage;


    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        faker = new Faker();
        unitedAirlinesHomePage = new UnitedAirlinesHomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
