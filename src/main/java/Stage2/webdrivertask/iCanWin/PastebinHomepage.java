package Stage2.webdrivertask.iCanWin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomepage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private static final By CODE_FORM = By.xpath("//*[@id='postform-text']");
    private static final By SELECT_EXPIRATION_FORM = By.xpath("//*[@id='select2-postform-expiration-container']");
    private static final By SELECT_EXPIRATION_FORM_VALUE = By.xpath("//li[text()='10 Minutes']");
    private static final By TITLE_FORM = By.xpath("//*[@id='postform-name']");
    private static final By CREATE_PASTE_BUTTON = By.xpath("//*[text()='Create New Paste']");

    public PastebinHomepage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomepage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomepage inputCode(String codeString) {
        driver.findElement(CODE_FORM).sendKeys(codeString);
        return this;
    }

    public PastebinHomepage chooseExpirationValue() {
        WebElement selectForm = driver.findElement(SELECT_EXPIRATION_FORM);
        selectForm.click();
        WebElement selectFormValue = driver.findElement(SELECT_EXPIRATION_FORM_VALUE);
        selectFormValue.click();
        return this;
    }

    public PastebinHomepage inputTitle(String titleText) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(TITLE_FORM));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.sendKeys(titleText);
        return this;
    }

    public PastebinPastePage createPasteButtonClick() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(CREATE_PASTE_BUTTON));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return new PastebinPastePage(driver);
    }
}
