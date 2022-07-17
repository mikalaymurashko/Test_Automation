package Stage2.webdrivertask.bringItOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPastePage extends AbstractPage {

    private static final By PASTE_TITLE_VALUE = By.xpath("//div[@class='info-top']//h1");
    private static final By PASTE_CODE_VALUE = By.xpath("//textarea[@class='textarea -raw js-paste-raw']");
    private static final By SYNTAX_HIGHLIGHTING_VALUE = By.xpath("//a[@class='btn -small h_800']");

    public PastebinPastePage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromSyntaxHighlightingButton() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(SYNTAX_HIGHLIGHTING_VALUE)).getText();
    }
    public String getPasteTitleValue() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(PASTE_TITLE_VALUE)).getText();
    }
    public String getPasteCodeValue() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(PASTE_CODE_VALUE)).getText();
    }
}
