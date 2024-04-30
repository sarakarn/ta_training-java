package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='YSM5S']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"i4\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div/div/div/div/div[3]/c-wiz/div[1]/div[1]/div/div[1]/a")
    private WebElement searchResultLink;

    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[1]/div/div/div/button/span[6]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id=\"yDmH0d\"]/div[4]/div[2]/div/div/div/div[2]/div/div/div[1]/div/div/div")
    private WebElement computeEngineButton;

    @FindBy(xpath = "//*[@id=\"c11\"]")
    private WebElement numberOfInstancesInput;


    public GoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnSearchButton(){
        searchField.click();
    }

    public void searchFor(String searchTerm) {
        searchInput.sendKeys(searchTerm);
        searchInput.submit();
    }

    public void clickOnPricingCalculatorLink() throws InterruptedException {
        Thread.sleep(2000);
        searchResultLink.click();
    }

    public void clickOnAddToEstimateButton() throws InterruptedException {
        Thread.sleep(2000);
        addToEstimateButton.click();
    }

    public void clickOnComputeEngine() throws InterruptedException {
        Thread.sleep(2000);
        computeEngineButton.click();
    }

    public void addNumberOfInstances(int numOfInstances) throws InterruptedException {
        Thread.sleep(2000);
       numberOfInstancesInput.sendKeys(Integer.toString(numOfInstances));
    }
}



