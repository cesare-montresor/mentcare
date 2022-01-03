package it.univr.efcgang.mentcare;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest: run spring boot before stating the tests
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

    public enum BrowserDriver {
        Chrome,
        Firefox
    }

    public String baseUrl = "http://localhost:8080/";
    public static BrowserDriver selectedBrowser = BrowserDriver.Chrome;
    public static Boolean headless = false;
    public static Boolean autoclose = false;

    protected static WebDriver driver;

    /*
    @Test
    public void SystemOnline() {
        driver.get(baseUrl);
    }
     */

    //@BeforeEach
    @BeforeAll
    public static void setUp() {
        if (driver != null) return;


        if (selectedBrowser == BrowserDriver.Chrome) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions chrome_options = new ChromeOptions();
            chrome_options.setHeadless(headless);
            driver = new ChromeDriver(chrome_options);
        }
        if (selectedBrowser == BrowserDriver.Firefox) {
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions firefox_options = new FirefoxOptions();
            firefox_options.setHeadless(headless);
            driver = new FirefoxDriver(firefox_options);
        }
    }
    //@BeforeEach
    @AfterAll
    public static void tearDown() {
        if (driver != null && ( autoclose || headless ) ) {
            driver.quit();
        }
    }

}

