package ramblerTests.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BaseLoggedInPage extends BasePage {
    private By checkLogin = By.xpath("//span[text()='goaldmit@rambler.ru']");
    private By myProfile = By.xpath("//*[text()='Мой профиль']");


    public BaseLoggedInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isLoggedIn(String email) {
        try{

            return waitVisibility(checkLogin).getText().equals(email);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProfilePage openProfile() {
        waitAndClick(checkLogin);
        waitAndClick(myProfile);
        switchToAnotherTab();

        return new ProfilePage(driver);
    }
}
