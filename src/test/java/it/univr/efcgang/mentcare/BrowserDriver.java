package it.univr.efcgang.mentcare;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserDriver {

    public enum BrowserKind {
        Firefox,
        Chrome
    }

    public BrowserDriver(){};

    public static BrowserDriver sharedInstance = new BrowserDriver();

    public BrowserKind kind = BrowserKind.Firefox;
    public boolean headless = false;

    public WebDriver driver;

    public BrowserDriver(BrowserKind kind, Boolean headless ){
        this.kind = kind;
        this.headless = headless;
    }

    public void open() {
        if (driver != null) return;

        if (kind == BrowserKind.Chrome) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions chrome_options = new ChromeOptions();
            chrome_options.setHeadless(headless);
            driver = new ChromeDriver(chrome_options);
        }
        if (kind == BrowserKind.Firefox) {
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions firefox_options = new FirefoxOptions();
            firefox_options.setHeadless(headless);
            driver = new FirefoxDriver(firefox_options);
        }

    }

    public void close() {
        if (driver != null ) {
            driver.quit();
            driver = null;
        }
    }

    public void clear() {
        driver.get("about:blank");
        driver.manage().deleteAllCookies();
    }
}

