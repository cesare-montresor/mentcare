package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitDatabasePO extends PageObject{

    @FindBy(tagName = "h1")
    WebElement title;

    public InitDatabasePO(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }
}
