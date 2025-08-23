package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import pages.HarelPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HarelTest {
    private WebDriver driver;
    private HarelPage harelPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        harelPage = new HarelPage(driver);


    }

    @Test
    public void testHarelPage() throws InterruptedException {
        harelPage.open();
        harelPage.clickPurchaseButton();
        harelPage.chooseDestination();
        harelPage.clickNext();
        harelPage.chooseStartDate();
        harelPage.chooseEndDate();
        Assert.assertEquals(harelPage.getTotalDays(), "סה\"כ: 31 ימים");
        harelPage.choosePassengers();
        Assert.assertEquals(harelPage.getPassengersScreenTitle(), "נשמח להכיר את הנוסעים שנבטח הפעם");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

