import Stage2.webdrivertask.hurtMePlenty.CloudGoogleHomepage;
import Stage2.webdrivertask.hurtMePlenty.CloudPricingCalculatorPage;
import Stage2.webdrivertask.hurtMePlenty.SearchResultPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.String.format;

public class HurtMePlentyTests {
    private WebDriver driver;
    private CloudPricingCalculatorPage cloudPricingCalculatorPage;
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

    @BeforeClass(alwaysRun = true)
    public void browserSetup() {
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
    }

    @Test(description = "Provisioning model check")
    public void provisioningModelTest() {
        String expectedModel = "Provisioning model: Regular";
        Assert.assertEquals(cloudPricingCalculatorPage.getProvisioningModel(), expectedModel,
                format("Wrong provisioning model: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getProvisioningModel(), expectedModel));
    }

    @Test(description = "Instance type check")
    public void instanceTypeTest() {
        String expectedType = "Instance type: n1-standard-8";
        Assert.assertTrue(cloudPricingCalculatorPage.getInstanceType().contains(expectedType),
                format("Wrong instance type value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getInstanceType(), expectedType));
    }

    @Test(description = "Region check")
    public void regionTest() {
        String expectedRegion = "Region: Frankfurt";
        Assert.assertEquals(cloudPricingCalculatorPage.getRegion(), expectedRegion,
                format("Wrong region value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getRegion(), expectedRegion));
    }

    @Test(description = "Local SSD check")
    public void localSSDTest() {
        String expectedSSD = "Local SSD: 2x375 GiB";
        Assert.assertTrue(cloudPricingCalculatorPage.getLocalSSDValue().contains(expectedSSD),
                format("Wrong local SSD value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getLocalSSDValue(), expectedSSD));
    }

    @Test(description = "Commitment term check")
    public void commitmentTermTest() {
        String expectedCommitmentTerm = "Commitment term: 1 Year";
        Assert.assertEquals(cloudPricingCalculatorPage.getTermAreaValue(), expectedCommitmentTerm,
                format("Wrong commitment term value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getTermAreaValue(), expectedCommitmentTerm));
    }

    @Test(description = "Total cost check")
    public void totalCostTest() {
        String expectedTotalCost = "Total Estimated Cost: USD 4,024.56 per 1 month";
        Assert.assertEquals(cloudPricingCalculatorPage.getTotalCost(), expectedTotalCost,
                format("Wrong total cost value: [%s], " + "expected value is: [%s]",
                        cloudPricingCalculatorPage.getTotalCost(), expectedTotalCost));
    }

    @AfterClass(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }
}
