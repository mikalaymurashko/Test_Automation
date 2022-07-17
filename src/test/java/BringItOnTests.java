import Stage2.webdrivertask.bringItOn.PastebinHomepage;
import Stage2.webdrivertask.bringItOn.PastebinPastePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.String.format;

public class BringItOnTests {

    private WebDriver driver;
    private PastebinPastePage pastePage;
    private final String CODE = "git config --global user.name  \"New Sheriff in Town\"" + "\n" +
        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" + "\n" +
        "git push origin master --force";
    private final String TITLE = "how to gain dominance among developers";
    private final String PROVIDED_HIGHLIGHTING_VALUE = "Bash";


    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PastebinHomepage homepage = new PastebinHomepage(driver);
        pastePage=  homepage.openPage()
            .inputCode(CODE)
            .chooseSyntaxHighlightingValue()
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
    @Test(description = "Syntax highlighting check")
    public void syntaxHighLightingTest() {
        String actualHighlightingValue = pastePage.getTextFromSyntaxHighlightingButton();
        Assert.assertEquals(actualHighlightingValue
            , PROVIDED_HIGHLIGHTING_VALUE,format("Syntax does not equal with given value: expected syntax [%s]," +
                        " actual syntax [%s]", PROVIDED_HIGHLIGHTING_VALUE, actualHighlightingValue));
    }

    @AfterClass(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
