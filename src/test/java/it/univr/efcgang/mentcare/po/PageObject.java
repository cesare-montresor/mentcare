package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;
    //protected WebElement message;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   /*
    public String getMessage(){
        return message.getText();
    }
    */
}
