package it.univr.efcgang.mentcare.config;

import it.univr.efcgang.mentcare.repository.UserRepository;
import it.univr.efcgang.mentcare.utils.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Component
public class EventHandler {

    @Autowired
    DemoData demoData;

    @EventListener(ApplicationReadyEvent.class)
    public void OnReady() throws IOException {
        System.out.println("System: OnReady");
        demoData.addDemoData();

        browserLogin("maria","maria");
    }

    public void browserLogin(String  user, String pass){
        BrowserDriver browser = BrowserDriver.sharedInstance;
        browser.open();
        browser.driver.get("http://localhost:8080/login");

        WebElement username = browser.driver.findElement(By.xpath( "//form//input[@name='username']" ));
        WebElement password = browser.driver.findElement(By.xpath( "//form//input[@name='password']" ));
        WebElement submit = browser.driver.findElement(By.xpath( "//form//input[@type='submit']" ));

        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        password.submit();
    }

}
