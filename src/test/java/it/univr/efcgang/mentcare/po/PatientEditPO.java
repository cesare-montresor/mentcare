package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    Select select;

    @FindBy(css="#page-patient-edit-submit")
    WebElement editSubmit;

    @FindBy(css="#error_msg")
    WebElement errorMsg;

    public PatientEditPO(WebDriver driver) {
        super(driver);
        select = new Select(editDoctor);
    }

    public void editPatient() {
        //change the doctor of the patient
        select.selectByVisibleText("luigi");
    }

    public String getTitle() {
        return editTitle.getText();
    }

    public PatientListPO updatePatient() {
        editSubmit.click();
        return new PatientListPO(driver);
    }

    public void editPatientWithWrongData() {
        editName.clear();
        editName.sendKeys("");
        select.selectByVisibleText("luigi");
        editSubmit.click();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }
}
