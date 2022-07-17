package Stage2.webdrivertask.hurtMePlenty;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGoogleHomepage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//div[@class='devsite-searchbox']");
    private static final By SEARCH_FORM_LOCATOR = By.xpath("//input[@placeholder='Search']");

    public CloudGoogleHomepage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomepage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultPage searchElement(String searchQuery) {
      new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON_LOCATOR)).click();
        WebElement searchFrom = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfElementLocated(SEARCH_FORM_LOCATOR));
        searchFrom.sendKeys(searchQuery);
        searchFrom.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }
}
