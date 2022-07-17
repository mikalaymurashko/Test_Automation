package Stage2.webdrivertask.iCanWin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinPastePage extends AbstractPage {

    private By pasteTitleValue = By.className("info-top");
    private By pasteCodeValue = By.xpath("//textarea[@class='textarea -raw js-paste-raw']");

    public PastebinPastePage(WebDriver driver) {
        super(driver);
    }

    public String getPasteTitleValue() {
        WebElement element = driver.findElement(pasteTitleValue);
        return element.getText();
    }
    public String getPasteCodeValue() {
        WebElement element = driver.findElement(pasteCodeValue);
        return element.getText();
    }
}
