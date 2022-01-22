package it.univr.efcgang.mentcare.po;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.Date;

public class Prescription404PO extends PageObject {

    @FindBy(id = "error_msg")
    WebElement errorMessage;


    public Prescription404PO(WebDriver driver) {
        super(driver);
    }

    public String getErrorMessage(){return errorMessage.getText();}
}
