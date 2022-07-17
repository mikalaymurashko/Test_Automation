package Stage2.webdrivertask.hardcore;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage extends AbstractPage {

    private By calculatorLinkLocator = By.xpath("//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CloudPricingCalculatorPage proceedToCalculatorPage() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(calculatorLinkLocator)).click();
        } catch (NoSuchElementException | TimeoutException e) {
            driver.get("https://cloud.google.com/products/calculator");
        }
        return new CloudPricingCalculatorPage(driver);
    }
}