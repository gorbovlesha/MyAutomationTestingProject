package sauceDemo.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

public class MainPage extends BasePage{
    private By title = By.xpath("//span[@class=\"title\"]");
    private By productList = By.xpath("//div[@class=\"inventory_item\"]//button");
    private By cartLink = By.xpath("//div[contains(@id, 'cart')]//a");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMainPageOpened() {
        try {
            return waitVisibility(title).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isFirstElementInCart() {
        try {
            return waitVisibility(productList).getAttribute("id").contains("remove");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public MainPage selectFirstItemToCart() {
        driver.findElement(productList).click();
        return this;
    }

    public CartPage goToCartPage() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }


}
