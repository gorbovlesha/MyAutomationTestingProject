package sauceDemo.simplePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private By cartTitle = By.xpath("//*[text()=\"Your Cart\"]");
    private By itemName = By.xpath("//div[@class=\"inventory_item_name\"]");
    private static List<String> cartElements = new ArrayList<>();

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

    public CartPage getElementsInCart() {
        driver.findElements(itemName).forEach(e -> cartElements.add(e.getText()));
        return this;
    }

    public boolean isElementsEqual() {
        return getCartElements().equals(MainPage.getCartElements());
    }

    public static List<String> getCartElements() {
        return cartElements;
    }

    public static void setCartElements(List<String> cartElements) {
        CartPage.cartElements = cartElements;
    }
}
