package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class is used for testing method testEditPatient of class PatientControllerTest
 */
public class PatientEditPO extends PageObject{
    @FindBy(css ="#page-patient-edit-title")
    WebElement editTitle;

    /*EDIT*/
    @FindBy(css="#page-patient-edit-name")
    WebElement editName;
    @FindBy(css="#page-patient-edit-doctor")
    WebElement editDoctor;
    @FindBy(css="#page-patient-edit-submit")
    WebElement editSubmit;

    public PatientEditPO(WebDriver driver) {
        super(driver);
    }
    // TODO:
    public void editPatient() {
    }

    public String getTitle() {
        return editTitle.getText();
    }
    //TODO:
    public PatientListPO updatePatient() {
        return null;
    }
}
