package it.univr.efcgang.mentcare.ui;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.po.MainPO;
import it.univr.efcgang.mentcare.BrowserDriver;
import it.univr.efcgang.mentcare.BrowserDriver.BrowserKind;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BrowserTest extends BaseTest {

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
    @AfterEach
    public void logout(){
        driver.get(url("/logout"));
        //return true;
    }



}

