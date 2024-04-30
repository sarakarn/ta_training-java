package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingCalculatorPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"c11\"]")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[1]")
    private WebElement expirationFormMachineType;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[21]/div/div/div[1]/div/div/span/div/button")
    private WebElement addGPUsButton;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div")
    private WebElement gpuModel;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div")
    private WebElement localSSD;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[29]/div/div[1]/div/div/div")
    private WebElement expirationFormLocation;

    @FindBy(xpath = "//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[31]/div/div/div[2]/div/div/div[2]")
    private WebElement commitedUsageButton;

    @FindBy(className = "AeBiU-LgbsSe AeBiU-LgbsSe-OWXEXe-Bz112c-M1Soyc AeBiU-LgbsSe-OWXEXe-dgl2Hf VVEJ3d")
    private WebElement addToEstimateButton;

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNumberOfInstances(int numOfInstances) throws InterruptedException {
        Thread.sleep(1000);
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(Integer.toString(numOfInstances));
    }

    public void chooseMachineType() throws InterruptedException {
        Thread.sleep(1000);
        expirationFormMachineType.click();
        String durationPath = String.format("//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[2]/ul/li[7]",
                "n1-standard-8 (vCPUs: 8, RAM: 30 GB)");
        driver.findElement(By.xpath(durationPath)).click();
    }

    public void addGPUsTypeAndNumber() throws InterruptedException {
        Thread.sleep(1000);

        addGPUsButton.click();

        Thread.sleep(1000);
        gpuModel.click();

        String durationPath1 = String.format("//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[23]/div/div[1]/div/div/div/div[2]/ul/li[3]",
                "NVIDIA Tesla V100");
        driver.findElement(By.xpath(durationPath1)).click();

        localSSD.click();
        String durationPath2 = String.format("//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]/ul/li[3]","2x375 Gb");
        driver.findElement(By.xpath(durationPath2)).click();
    }

    public void chooseDatacenterLocation(){
        expirationFormLocation.click();

        //There is impossible to choose Frankfurt(europe-west3), because after choosing GPU type: "NVIDIA Tesla V100", there is no such option available.
        //Therefore, I chose "Netherlands(europe-west4)", as an example
        String durationPath = String.format("//*[@id=\"ow4\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[29]/div/div[1]/div/div/div/div[2]/ul/li[13]",
                "Netherlands (europe-west4)");
        driver.findElement(By.xpath(durationPath)).click();
    }

    public void chooseCommitedUsageYear(){
        commitedUsageButton.click();
    }

    public void addtoEstimate(){
        addToEstimateButton.click();
    }
}