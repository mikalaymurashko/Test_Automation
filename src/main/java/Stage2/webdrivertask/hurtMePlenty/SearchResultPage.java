package Stage2.webdrivertask.hurtMePlenty;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage extends AbstractPage {

    private static final By CALCULATOR_LINK_LOCATOR = By.xpath("//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public CloudPricingCalculatorPage proceedToCalculatorPage() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(CALCULATOR_LINK_LOCATOR)).click();
        } catch (NoSuchElementException | TimeoutException e) {
            driver.get("https://cloud.google.com/products/calculator");
        }
        return new CloudPricingCalculatorPage(driver);
    }
}
