package sauceDemo.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{
    private By title = By.xpath("//span[@class=\"title\"]");
    private By productList = By.xpath("//div[@class=\"inventory_item\"]//button");
    private By cartLink = By.xpath("//div[contains(@id, 'cart')]//a");
    private By itemName = By.xpath("//div[@class=\"inventory_item_name\"]");
    private static List<String> cartElements = new ArrayList<>();


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
        cartElements.add(driver.findElement(itemName).getText());
        return this;
    }

    public MainPage selectAllItemsToCart() {
        driver.findElements(productList).forEach(WebElement::click);
        driver.findElements(itemName).forEach(e -> cartElements.add(e.getText()));
        return this;
    }

    public CartPage goToCartPage() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }

    public static List<String> getCartElements() {
        return cartElements;
    }

    public static void setCartElements(List<String> cartElements) {
        MainPage.cartElements = cartElements;
    }
}
