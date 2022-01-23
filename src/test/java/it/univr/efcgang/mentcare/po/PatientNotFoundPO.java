package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientNotFoundPO extends PageObject{
    @FindBy(css = "#page-patient-error-title")
    WebElement title;
    public PatientNotFoundPO(WebDriver driver) {
        super(driver);

    }
    public String getTitle(){
        return title.getText();
    }
}
