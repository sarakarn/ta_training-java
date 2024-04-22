package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        driver.get("https://pastebin.com/");

        WebElement searchInputPaste = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("postform-text")));
        searchInputPaste.sendKeys("Hello from WebDriver");

        WebElement expirationForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-postform-expiration-container")));
       expirationForm.click();
       String durationPath = String.format("//*[@id=\"select2-postform-expiration-results\"]/*[text()='%s']", "10 Minutes");
       driver.findElement(By.xpath(durationPath)).click();

        WebElement searchInputPasteName = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("postform-name")));
        searchInputPasteName.sendKeys("helloweb");

        WebElement searchButtonCreate = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[11]/button"));
        searchButtonCreate.click();

        Thread.sleep(2000);
        driver.quit();

    }
}
