package sauceDemo.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By cartTitle = By.xpath("//*[text()=\"Your Cart\"]");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageOpened() {
        try {
            return waitVisibility(cartTitle).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
}
