package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UtilsPO extends PageObject{
    @FindBy(tagName = "h1")
    WebElement title;

    @FindBy(xpath = "/html/body/ul/li/a")
    WebElement initDatabaseLink;

    public UtilsPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }

    public InitDatabasePO initDatabase(){
        initDatabaseLink.click();
        return new InitDatabasePO(driver);
    }



}
