import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewSheriff {
    public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    driver.get("https://pastebin.com/");

    WebElement searchInputPaste = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.id("postform-text")));
    searchInputPaste.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force\n");

    WebElement expirationForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-postform-format-container")));
    expirationForm.click();
    WebElement input = driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input"));
    input.sendKeys("Bash");

    WebElement expirationForm2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-postform-expiration-container")));
    expirationForm2.click();
    String durationPath = String.format("//*[@id=\"select2-postform-expiration-results\"]/*[text()='%s']", "10 Minutes");
    driver.findElement(By.xpath(durationPath)).click();

    WebElement searchInputPasteName = wait.until(ExpectedConditions.visibilityOfElementLocated
            (By.id("postform-name")));
    searchInputPasteName.sendKeys("how to gain dominance among developers");

    WebElement buttonCreateNewPaste = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[10]/button"));
    buttonCreateNewPaste.click();

    Thread.sleep(4000);
    driver.quit();
}
}
