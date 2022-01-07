package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientPO extends PageObject{
    /*INDEX*/
    @FindBy(css="page-patient-index-edit")
    WebElement indexEdit;
    @FindBy(css="page-patient-index-delete")
    WebElement indexDelete;
    @FindBy(css="page-patient-index-create")
    WebElement indexCreate;
    /*CREATE*/
    @FindBy(css="page-patient-create-name")
    WebElement createName;
    @FindBy(css="page-patient-create-doctor")
    WebElement createDoctor;
    @FindBy(css="page-patient-create-submit")
    WebElement createSubmit;
    /*EDIT*/
    @FindBy(css="page-patient-edit-name")
    WebElement editName;
    @FindBy(css="page-patient-edit-doctor")
    WebElement editDoctor;
    @FindBy(css="page-patient-edit-submit")
    WebElement editSubmit;

    public PatientPO(WebDriver driver) {
        super(driver);
    }

}
