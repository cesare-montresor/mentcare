package it.univr.efcgang.mentcare;

import io.github.bonigarcia.wdm.WebDriverManager;
import it.univr.efcgang.mentcare.po.MainPO;
import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.utils.BrowserDriver;
import it.univr.efcgang.mentcare.utils.BrowserDriver.BrowserKind;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


//@SpringBootTest: run spring boot before stating the tests
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

    public String baseUrl = "http://localhost:8080";

    public static BrowserKind kind = BrowserKind.Firefox;
    public static boolean headless = false;
    public static boolean autoclose = false;

    protected static BrowserDriver browser;
    protected static WebDriver driver;

    MainPO mainPO = new MainPO(driver);

    @BeforeAll
    public static void open() {
        if (browser == null) {
            browser = new BrowserDriver(kind, headless);
        }
        browser.open();
        driver = browser.driver;
    }

    @AfterAll
    public static void close() {
        if ( headless || autoclose ) {
            browser.close();
        }
    }

    //@BeforeEach
    //@AfterEach
    public static void clear() {
        browser.clear();
    }


    public String url(String path){
        return baseUrl + path;
    }

    public boolean browserLogin(String  user, String pass){

        browser.open();
        driver = browser.driver;
        driver.get(url("/login"));

        mainPO.loginSetUsername(user);
        mainPO.loginSetPassword(pass);
        mainPO.loginPerform();

        return true;
    }

    public boolean logout(){
        driver.get(url("/logout"));
        return true;
    }



}

