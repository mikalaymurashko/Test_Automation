import Stage2.webdrivertask.hardcore.CloudGoogleHomepage;
import Stage2.webdrivertask.hardcore.CloudPricingCalculatorPage;
import Stage2.webdrivertask.hardcore.EmailGenerationPage;
import Stage2.webdrivertask.hardcore.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.String.format;

public class HardcoreTests {
    private WebDriver driver;
    private CloudPricingCalculatorPage cloudPricingCalculatorPage;
    private EmailGenerationPage emailPage;

    private final String SEARCH_QUERY = "google cloud platform pricing calculator";
    private final String NUMBER_OF_INSTANCES_VALUE = "4";
    private final String OS_VALUE = "Free: Debian, CentOS";
    private final String PROVISIONAL_VALUE = "regular";
    private final String SERIES_VALUE = "N1";
    private final String MACHINE_TYPE_VALUE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private final String GPU_VALUE = "NVIDIA Tesla P100";
    private final String NUMBER_OF_GPUS_VALUE = "1";
    private final String SSD_VALUE = "2x375 GB";
    private final String DATACENTER_LOCATION = "Frankfurt (europe-west3)";
    private final String COMMITTED_USAGE_TERM = "1 Year";
    private String costFromGoogleCloudPricingPage;
    private String costFromEmail;

    @BeforeClass(alwaysRun = true)
    public void browserSetup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        CloudGoogleHomepage cloudGoogleHomepage = new CloudGoogleHomepage(driver);
        SearchResultPage searchResultPage = cloudGoogleHomepage.openPage()
                .searchElement(SEARCH_QUERY);
        cloudPricingCalculatorPage = searchResultPage.proceedToCalculatorPage()
                .switchToComputerEngine()
                .inputNumberOfInstancesValue(NUMBER_OF_INSTANCES_VALUE)
                .selectOSValue(OS_VALUE)
                .selectProvisioningValue(PROVISIONAL_VALUE)
                .selectSeriesValue(SERIES_VALUE)
                .selectMachineTypeValue(MACHINE_TYPE_VALUE)
                .addGPUs(GPU_VALUE, NUMBER_OF_GPUS_VALUE)
                .selectSSDValue(SSD_VALUE)
                .selectDatacenterLocation(DATACENTER_LOCATION)
                .selectCommittedUsage(COMMITTED_USAGE_TERM)
                .pressAddToEstimateButton();
        costFromGoogleCloudPricingPage = cloudPricingCalculatorPage.getCostFromCloudPricingPage();
        cloudPricingCalculatorPage.pressEmailEstimateButton();
        cloudPricingCalculatorPage.openEmailPage();
        emailPage = new EmailGenerationPage(driver)
                .openEmailGenerationPage()
                .pressGenerateRandomEmailButton();
        String email = emailPage.copyEmail();
        emailPage.switchToCalculatorPage();
        cloudPricingCalculatorPage
                .pasteEmail(email)
                .sendEmail()
                .switchToEmailPage();
        Thread.sleep(3000);
        emailPage.openEmail()
                .refreshEmailBox();
        costFromEmail = emailPage.getEstimatedCostFromEmail();
    }

    @Test(description = "Price test")
    public void priceOnCloudGooglePageEqualEmailedPrice() {
        Assert.assertEquals(costFromGoogleCloudPricingPage,costFromEmail,
                format("Wrong cost from email value: [%s], " + "expected value is: [%s]",
                        costFromGoogleCloudPricingPage, costFromEmail));
    }

    @AfterClass(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
