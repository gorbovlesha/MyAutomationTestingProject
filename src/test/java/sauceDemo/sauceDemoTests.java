package sauceDemo;

import com.google.common.io.Resources;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sauceDemo.simplePage.CartPage;
import sauceDemo.simplePage.LoginPage;
import sauceDemo.simplePage.MainPage;

import java.time.Duration;
import java.util.ArrayList;

public class sauceDemoTests {
    private static final String login = "standard_user";
    private static String password = "secret_sauce";

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setupEnvironment() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver.exe").getPath());
    }

    @BeforeEach
    public void createDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .login(login, password)
                .isMainPageOpened()
        );
    }

    @Test
    public void addItemToCart() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .login(login, password)
                .selectFirstItemToCart()
                .isFirstElementInCart()
        );
    }

    @Test
    public void goToCart() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .login(login, password)
                .goToCartPage()
                .isCartPageOpened()
        );
    }

    @Test
    public void addElementToCart() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .login(login, password)
                .selectFirstItemToCart()
                .goToCartPage()
                .getElementsInCart()
                .isElementsEqual()
        );
        MainPage.setCartElements(new ArrayList<>());
        CartPage.setCartElements(new ArrayList<>());
    }

    @Test
    public void addAllElementsToCart() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .login(login, password)
                .selectAllItemsToCart()
                .goToCartPage()
                .getElementsInCart()
                .isElementsEqual()
        );
    }

}
