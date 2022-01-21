package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is used for testing method testCreatePatient of class PatientControllerTest
 */
public class PatientCreatePO extends PageObject{
    /*CREATE*/
    @FindBy(css="page-patient-create-name")
    WebElement createName;
    @FindBy(css="page-patient-create-doctor")
    WebElement createDoctor;
    @FindBy(css="page-patient-create-submit")
    WebElement createSubmit;

    public PatientCreatePO(WebDriver driver) {
        super(driver);
    }
}
