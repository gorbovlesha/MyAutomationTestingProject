package ramblerTests.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static final String BASE_URL = "https://www.rambler.ru";
    protected static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage (WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS);
    }

    protected void waitAndClick(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    protected WebElement waitVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void switchToAnotherTab() {
        driver.close();
        driver.switchTo().window(driver.getWindowHandles().stream()
                .filter(w -> !w.equals(driver.getWindowHandle()))
                .findFirst().get());
    }

}
