package ramblerTests.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BaseLoggedInPage  {
    private By inbox = By.xpath("//a[contains(@href,\"INBOX\")]");


    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public InboxMailPage openInbox() {
        waitAndClick(inbox);
        switchToAnotherTab();

        return new InboxMailPage(driver);
    }
}
