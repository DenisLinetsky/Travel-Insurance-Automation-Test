package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HarelPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By purchaseButton = By.xpath("//button[@data-hrl-bo='purchase-for-new-customer']");
    private By purchaseNextButton = By.xpath("//button[@data-hrl-bo='wizard-next-button']");
    private By destButton = By.id("destination-0");
    private By startDateInput = By.id("travel_start_date");
    private By pssgNextButton = By.id("nextButton");
    private By endDateInput = By.id("travel_end_date");
    private By totalDays = By.xpath("//span[@data-hrl-bo='total-days']");
    private By passengersScreenTitle = By.xpath("//h2[@data-hrl-bo='screen_title']");

    public HarelPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void open() {
        driver.get("https://digital.harel-group.co.il/travel-policy");
    }

    public void clickPurchaseButton() {
        clickButton(purchaseButton);
    }

    public void chooseDestination(){
        clickButton(destButton);
    }

    public void clickNext(){
        clickButton(purchaseNextButton);
    }

    public void choosePassengers(){
        clickButton(pssgNextButton);
    }

    public void chooseStartDate() {
        inputDate(7, startDateInput);
    }

    public void chooseEndDate() {
        inputDate(37, endDateInput);
    }

    public String getTotalDays() {
        WebElement totalDaysEl = wait.until(ExpectedConditions.elementToBeClickable(totalDays));
        return totalDaysEl.getText();
    }

    public String getPassengersScreenTitle() {
        WebElement passengersScreenTitleEl = wait.until(ExpectedConditions.elementToBeClickable(passengersScreenTitle));
        return passengersScreenTitleEl.getText();
    }

    private void inputDate(int deltaDays, By dateInput) {
        LocalDate datePlusSevenDays = LocalDate.now().plusDays(deltaDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = datePlusSevenDays.format(formatter);

        WebElement dateInputEl = wait.until(ExpectedConditions.visibilityOfElementLocated(dateInput));
        dateInputEl.clear();
        dateInputEl.sendKeys(formattedDate);
    }

    private void clickButton(By clickButton) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clickButton));
        button.click();
    }
}
