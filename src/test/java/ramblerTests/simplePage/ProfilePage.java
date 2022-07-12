package ramblerTests.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BaseLoggedInPage{
    private By myName = By.xpath("//*[text()='Алексей Горбов']");


    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isProfileOpened() {
        try {
            return waitVisibility(myName).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
}

