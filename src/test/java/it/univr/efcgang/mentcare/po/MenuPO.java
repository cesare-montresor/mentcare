package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPO extends PageObject{


    @FindBy(css = "#main-menu-home")
    WebElement home;

    @FindBy(css = "#main-menu-prescription")
    WebElement prescriptions;

    @FindBy(css = "#main-menu-patient")
    WebElement patients;

    @FindBy(css = "#main-menu-utils")
    WebElement utils;

    public MenuPO(WebDriver driver) {
        super(driver);
    }

    public PrescriptionListEmptyPO goToPrescriptionPageEmpty(){
        prescriptions.click();
        return new PrescriptionListEmptyPO(driver);
    }

    public PrescriptionListPO goToPrescriptionPage(){
        prescriptions.click();
        return new PrescriptionListPO(driver);
    }
    public PatientPO goToPatientPageEmpty(){
        patients.click();
        return new PatientPO(driver);
    }
    public PatientPO goToPatientPage(){
        patients.click();
        return new PatientPO(driver);
    }

    public UtilsPO goToUtilsPage(){
        utils.click();
        return new UtilsPO(driver);
    }
    public void goToHome(){
        //TODO
    }


}
