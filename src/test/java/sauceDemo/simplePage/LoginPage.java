package sauceDemo.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    private By loginBox = By.xpath("//input[@placeholder=\"Username\"]");
    private By passwordBox = By.xpath("//input[@placeholder=\"Password\"]");
    private By loginButton = By.xpath("//input[@id=\"login-button\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    public LoginPage typeLogin(String login) {
        driver.findElement(loginBox).sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
        return this;
    }

    public MainPage submitLogin() {
        waitAndClick(loginButton);
        return new MainPage(driver);
    }

    public MainPage login(String login, String password) {
        typeLogin(login);
        typePassword(password);
        return submitLogin();
    }
}
