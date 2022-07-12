package ramblerTests;

import com.google.common.io.Resources;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ramblerTests.simplePage.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class RamblerTest {
    private static String login;
    private static String password;


    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setEnvironment() {
        System.setProperty("webdriver.chrome.driver", Resources.getResource("chromedriver.exe").getPath());

        Properties props = new Properties();
        try (InputStream input = new FileInputStream("src\\test\\resources\\config.properties")) {
            props.load(input);
            login = props.getProperty("login");
            password = props.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void createDriver() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void login() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .loginAs(login, password)
                .isLoggedIn(login)
        );
    }

    @Test
    public void openProfile() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .loginAs(login, password)
                .openProfile()
                .isProfileOpened()
        );
    }

    @Test
    public void openInbox() {
        Assertions.assertTrue(
                new LoginPage(driver)
                .loginAs(login, password)
                .openInbox()
                .isInboxMailPageOpened()
        );

    }
}
