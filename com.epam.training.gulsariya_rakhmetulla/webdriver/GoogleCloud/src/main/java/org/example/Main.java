package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        GoogleCloudPage googleCloudPage = new GoogleCloudPage(driver);

        googleCloudPage.openHomePage("https://cloud.google.com/");

        googleCloudPage.clickOnSearchButton();

        googleCloudPage.searchFor("Google Cloud Platform Pricing Calculator");

        googleCloudPage.clickOnPricingCalculatorLink();

        googleCloudPage.clickOnAddToEstimateButton();

        googleCloudPage.clickOnComputeEngine();

        PricingCalculatorPage pricingCalculatorPage = new PricingCalculatorPage(driver);

        pricingCalculatorPage.addNumberOfInstances(4);

        pricingCalculatorPage.chooseMachineType();

        pricingCalculatorPage.addGPUsTypeAndNumber();

        pricingCalculatorPage.chooseDatacenterLocation();

        pricingCalculatorPage.chooseCommitedUsageYear();

        pricingCalculatorPage.addtoEstimate();


        driver.wait(4000);
        driver.quit();
    }
}