package Stage2.webdrivertask.bringItOn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomepage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(xpath = "//*[@id='postform-text']")
    private WebElement codeForm;
    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingForm;
    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement selectSyntaxHighlightingValue;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement selectExpirationForm;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement selectExpirationFormValue;
    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement titleForm;
    private static final By CREATE_PASTE_BUTTON = By.xpath("//*[text()='Create New Paste']");

    public PastebinHomepage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomepage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomepage inputCode(String codeString) {
        codeForm.sendKeys(codeString);
        return this;
    }

    public PastebinHomepage chooseSyntaxHighlightingValue() {
        syntaxHighlightingForm.click();
        selectSyntaxHighlightingValue.click();
        return this;
    }

    public PastebinHomepage chooseExpirationValue() {
        selectExpirationForm.click();
        selectExpirationFormValue.click();
        return this;
    }

    public PastebinHomepage inputTitle(String titleText) {
        titleForm.sendKeys(titleText);
        return this;
    }

    public PastebinPastePage createPasteButtonClick() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(CREATE_PASTE_BUTTON));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        return new PastebinPastePage(driver);
    }
}
