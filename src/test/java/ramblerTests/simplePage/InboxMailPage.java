package ramblerTests.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class InboxMailPage extends BaseLoggedInPage{

    private By inbox = By.xpath("//a[contains(@title, \"Входящие\")]");

    public InboxMailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isInboxMailPageOpened() {
        try {
            return waitVisibility(inbox).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
}
