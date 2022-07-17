package Stage2.webdrivertask.hardcore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class EmailGenerationPage extends AbstractPage {

    private JavascriptExecutor executor = (JavascriptExecutor) driver;
    private static final String HOMEPAGE_URL = "https://yopmail.com/";
    private static final By FRAME_LOCATOR = By.xpath("//iframe[@id='ifmail']");
    private static final By GENERATE_RANDOM_EMAIL_BUTTON = By.xpath("//a[@href='email-generator']//b");
    private static final By RANDOM_EMAIL = By.xpath("//div[@id='egen']");
    private static final By OPEN_EMAIL_GENERATED = By.xpath("//button[@onclick='egengo();']");
    private static final By REFRESH_EMAIL_BOX = By.xpath("//button[@id='refresh']");
    private static final By ESTIMATED_COST_FROM_EMAIL_ = By.xpath("//td//h3[contains (text(),'USD')]");

    public EmailGenerationPage openEmailGenerationPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public EmailGenerationPage pressGenerateRandomEmailButton() {
        WebElement generateRandomEmailButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(GENERATE_RANDOM_EMAIL_BUTTON));
        executor.executeScript("arguments[0].click()", generateRandomEmailButton);
        return this;
    }

    public String copyEmail() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(RANDOM_EMAIL)).getText();
    }

    public CloudPricingCalculatorPage switchToCalculatorPage(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return new CloudPricingCalculatorPage(driver);
    }

    public EmailGenerationPage openEmail() {
        WebElement openEmailButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(OPEN_EMAIL_GENERATED));
        executor.executeScript("arguments[0].click()", openEmailButton);
        return this;
    }

    public EmailGenerationPage refreshEmailBox() {
        WebElement refreshEmailButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(REFRESH_EMAIL_BOX));
        executor.executeScript("arguments[0].click()", refreshEmailButton);
        return this;
    }

    public String getEstimatedCostFromEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(FRAME_LOCATOR));
        driver.switchTo().frame("ifmail");
        WebElement estimatedCostFromEmail = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(ESTIMATED_COST_FROM_EMAIL_));
        return estimatedCostFromEmail.getText();
    }


    public EmailGenerationPage(WebDriver driver) {
        super(driver);
    }
}
