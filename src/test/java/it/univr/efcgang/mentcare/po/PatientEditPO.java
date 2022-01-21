package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is used for testing method testEditPatient of class PatientControllerTest
 */
public class PatientEditPO extends PageObject{
    /*EDIT*/
    @FindBy(css="page-patient-edit-name")
    WebElement editName;
    @FindBy(css="page-patient-edit-doctor")
    WebElement editDoctor;
    @FindBy(css="page-patient-edit-submit")
    WebElement editSubmit;

    public PatientEditPO(WebDriver driver) {
        super(driver);
    }
}
