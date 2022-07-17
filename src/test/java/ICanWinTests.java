import Stage2.webdrivertask.iCanWin.PastebinHomepage;
import Stage2.webdrivertask.iCanWin.PastebinPastePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.String.format;

public class ICanWinTests {

    private PastebinPastePage pastePage;
    private final String CODE = "Hello from WebDriver";
    private final String TITLE = "helloweb";
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PastebinHomepage homepage = new PastebinHomepage(driver);
        pastePage = homepage.openPage()
                .inputCode(CODE)
                .chooseExpirationValue()
                .inputTitle(TITLE)
                .createPasteButtonClick();
    }

    @Test(description = "Title test")
    public void titleTest() {
        String actualTitle = pastePage.getPasteTitleValue();
        Assert.assertEquals(actualTitle, TITLE, format("Title is wrong: expected title [%s]," +
                " actual title [%s]", TITLE, actualTitle));
    }

    @Test(description = "Paste code test")
    public void pastedCodeTest() {
        String actualCode = pastePage.getPasteCodeValue();
        Assert.assertEquals(actualCode, CODE, format("Code is wrong: expected code [%s]," +
                " actual code [%s]", CODE, actualCode));
    }

    @AfterClass(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
