package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DBStatPO extends PageObject{

    @FindBy(tagName = "h1")
    WebElement title;

    @FindBy(id = "stat-drug")
    WebElement statDrug;

    @FindBy(id = "stat-prescription")
    WebElement statPrescription;

    @FindBy(id = "stat-user")
    WebElement statUser;

    @FindBy(id = "stat-patient")
    WebElement statPatient;

    public DBStatPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return title.getText();
    }

    public String getStatDrug(){return statDrug.getText();}

    public String getStatUser(){return statUser.getText();}

    public String getStatPrescription(){return statPrescription.getText();}

    public String getStatPatient(){return statPatient.getText();}

}
