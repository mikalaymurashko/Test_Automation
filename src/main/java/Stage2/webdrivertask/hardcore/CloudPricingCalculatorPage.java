package Stage2.webdrivertask.hardcore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.String.format;

public class CloudPricingCalculatorPage extends AbstractPage {

    private JavascriptExecutor executor = (JavascriptExecutor) driver;
    private static final By FRAME_LOCATOR = By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe");
    private static final By COMPUTER_ENGINE_BUTTON_LOCATOR = By.xpath("//md-tab-item/*[@title='Compute Engine']");
    private static final By NUMBER_OF_INSTANCE_INPUT_LOCATOR = By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']");
    private static final By SELECT_OS_LOCATOR = By.xpath("//*[@ng-model='listingCtrl.computeServer.os']/md-select-value");
    private static final String OS_VALUE_LOCATOR = "//div[contains(text(),'%s')]/parent::md-option";
    private static final By PROVISIONING_DROPDOWN_LOCATOR = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.class')]/md-select-value");
    private static final String PROVISIONING_VALUE = "//md-option[@value='%s']";
    private static final By SERIES_DROP_DOWN_LOCATOR = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.series')]/md-select-value");
    private static final String SERIES_VALUE_LOCATOR = "//div[contains(text(),'%s')]/parent::md-option";
    private static final By MACHINE_TYPE_DROPDOWN_LOCATOR = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.instance')]/md-select-value");
    private static final String MACHINE_TYPE_VALUE_LOCATOR = "//div[contains(text(),'%s')]/parent::md-option";
    private static final By ADD_GPUS_BUTTON = By.xpath("//md-input-container//md-checkbox[@aria-label='Add GPUs']");
    private static final By GPU_TYPE_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.gpuType')]/md-select-value");
    private static final String GPU_TYPE_VALUE = "//div[contains(text(),'%s')]/parent::md-option";
    private static final By NUMBER_OF_GPUS_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.gpuCount')]/md-select-value");
    private static final String NUMBER_OF_GPUS_VALUE = "//*[contains(@ng-repeat,'listingCtrl.computeServer.gpuType') and @value='%s']";
    private static final By LOCAL_SSD_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.ssd')]/md-select-value");
    private static final String LOCAL_SSD_VALUE = "//div[contains(text(),'%s')]/parent::md-option";
    private static final By DATACENTER_LOCATION_DROPDOWN = By.xpath("//*[@ng-model='listingCtrl.computeServer.location']//md-select-value");
    private static final String DATACENTER_LOCATION_VALUE = "//div[contains(text(),'%s')]/parent::md-option[@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']";
    private static final By COMMITTED_USAGE_DROPDOWN = By.xpath("//*[contains(@ng-model,'listingCtrl.computeServer.cud')]/md-select-value");
    private static final String COMMITTED_USAGE_VALUE = "//div[@class='md-select-menu-container md-active md-clickable']/descendant ::div[contains(text(),'%s')]/parent::md-option";
    private static final By ADD_TO_ESTIMATE_BUTTON = By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']");
    private static final By TOTAL_COST_AREA = By.xpath("//b[@class='ng-binding'][contains(text(),'Total Estimated Cost:')]");
    private static final By EMAIL_BUTTON = By.xpath("//button[@title='Email Estimate']");
    private static final By EMAIL_AREA = By.xpath("//input[@ng-model='emailQuote.user.email']");
    private static final By SEND_EMAIL_BUTTON = By.xpath("//button[@aria-label='Send Email']");

    public CloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudPricingCalculatorPage switchToComputerEngine() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(FRAME_LOCATOR));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(COMPUTER_ENGINE_BUTTON_LOCATOR)).click();
        return this;
    }

    public CloudPricingCalculatorPage inputNumberOfInstancesValue(String value) {
        WebElement numberOfInstanceInput = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(NUMBER_OF_INSTANCE_INPUT_LOCATOR));
        numberOfInstanceInput.click();
        numberOfInstanceInput.sendKeys(value);
        return this;
    }

    public CloudPricingCalculatorPage selectOSValue(String value) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(SELECT_OS_LOCATOR)).click();
        By osValueLocator = By.xpath(format(OS_VALUE_LOCATOR, value));
        WebElement oSValue = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(osValueLocator));
        executor.executeScript("arguments[0].click()", oSValue);
        return this;
    }

    public CloudPricingCalculatorPage selectProvisioningValue(String value) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(PROVISIONING_DROPDOWN_LOCATOR)).click();
        By selectValue = By.xpath(format(PROVISIONING_VALUE, value));
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(selectValue)).click();
        return this;
    }

    public CloudPricingCalculatorPage selectSeriesValue(String value) {
        WebElement seriesDropDown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(SERIES_DROP_DOWN_LOCATOR));
        executor.executeScript("arguments[0].click()", seriesDropDown);
        By seriesValueLocator = By.xpath(format(SERIES_VALUE_LOCATOR, value));
        WebElement seriesValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(seriesValueLocator));
        executor.executeScript("arguments[0].click()", seriesValue);
        return this;
    }

    public CloudPricingCalculatorPage selectMachineTypeValue(String value) {
        WebElement machineTypeDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(MACHINE_TYPE_DROPDOWN_LOCATOR));
        executor.executeScript("arguments[0].click()", machineTypeDropdown);
        By machineTypeValueLocator = By.xpath(format(MACHINE_TYPE_VALUE_LOCATOR, value));
        WebElement machineTypeValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(machineTypeValueLocator));
        executor.executeScript("arguments[0].click()", machineTypeValue);
        return this;
    }

    public CloudPricingCalculatorPage addGPUs(String value, String number) {
        WebElement addGPUsButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(ADD_GPUS_BUTTON));
        executor.executeScript("arguments[0].click()", addGPUsButton);
        WebElement GPUTypeDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(GPU_TYPE_DROPDOWN));
        executor.executeScript("arguments[0].click()", GPUTypeDropdown);
        By GPUTypeValueLocator = By.xpath(format(GPU_TYPE_VALUE, value));
        WebElement GPUTypeValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(GPUTypeValueLocator));
        executor.executeScript("arguments[0].click()", GPUTypeValue);
        WebElement numberOfGPUsDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(NUMBER_OF_GPUS_DROPDOWN));
        executor.executeScript("arguments[0].click()", numberOfGPUsDropdown);
        By numberOfGPUValueLocator = By.xpath(format(NUMBER_OF_GPUS_VALUE, number));
        WebElement numberOfGPUValue = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(numberOfGPUValueLocator));
        executor.executeScript("arguments[0].click()", numberOfGPUValue);
        return this;
    }

    public CloudPricingCalculatorPage selectSSDValue(String value) {
        WebElement localSSDDropdown = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(LOCAL_SSD_DROPDOWN));
        executor.executeScript("arguments[0].click()", localSSDDropdown);
        By localSSDValueLocator = By.xpath(format(LOCAL_SSD_VALUE, value));
        WebElement localSSDValue = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(localSSDValueLocator));
        executor.executeScript("arguments[0].click()", localSSDValue);
        return this;
    }

    public CloudPricingCalculatorPage selectDatacenterLocation(String value) {
        WebElement datacenterDropDown = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(DATACENTER_LOCATION_DROPDOWN));
        executor.executeScript("arguments[0].click()", datacenterDropDown);
        By datacenterLocationValueLocator = By.xpath(format(DATACENTER_LOCATION_VALUE, value));
        WebElement datacenterLocationValue = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(datacenterLocationValueLocator));
        executor.executeScript("arguments[0].click()", datacenterLocationValue);
        return this;
    }

    public CloudPricingCalculatorPage selectCommittedUsage(String value) {
        WebElement committedUsageDropdown = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(COMMITTED_USAGE_DROPDOWN));
        executor.executeScript("arguments[0].click()", committedUsageDropdown);
        By committedUsageValueLocator = By.xpath(format(COMMITTED_USAGE_VALUE, value));
        WebElement committedUsageValue = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(committedUsageValueLocator));
        executor.executeScript("arguments[0].click()", committedUsageValue);
        return this;
    }

    public CloudPricingCalculatorPage pressAddToEstimateButton() {
        WebElement addToEstimateButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(ADD_TO_ESTIMATE_BUTTON));
        executor.executeScript("arguments[0].click()", addToEstimateButton);
        return this;
    }

    public String getCostFromCloudPricingPage() {
        String cost = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(TOTAL_COST_AREA)).getText();
        String format = cost.replace("Total Estimated Cost: ","");
        String formattedCost = format.replace(" per 1 month","");
        return formattedCost;
    }

    public CloudPricingCalculatorPage pressEmailEstimateButton() {
        WebElement pressEmailButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(EMAIL_BUTTON));
        executor.executeScript("arguments[0].click()", pressEmailButton);
        return this;
    }

    public CloudPricingCalculatorPage pasteEmail(String email) {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        WebElement enterEmail = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(EMAIL_AREA));
        executor.executeScript("arguments[0].click()", enterEmail);
        enterEmail.sendKeys(email);
        return this;
    }

    public CloudPricingCalculatorPage sendEmail() {
        WebElement pressSendEmailButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(SEND_EMAIL_BUTTON));
        executor.executeScript("arguments[0].click()", pressSendEmailButton);
        return this;
    }

    public EmailGenerationPage openEmailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new EmailGenerationPage(driver);
    }

    public EmailGenerationPage switchToEmailPage() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return new EmailGenerationPage(driver);
    }
}