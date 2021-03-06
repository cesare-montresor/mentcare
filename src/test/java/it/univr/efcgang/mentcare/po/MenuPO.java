package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPO extends PageObject{


    @FindBy(css = "#main-menu-home")
    WebElement home;

    @FindBy(css = "#main-menu-prescription")
    WebElement prescriptions;

    @FindBy(css = "#main-menu-drug")
    WebElement drugs;

    @FindBy(css = "#main-menu-patient")
    WebElement patients;

    @FindBy(css = "#main-menu-user")
    WebElement user;

    @FindBy(css = "#main-menu-utils")
    WebElement utils;

    public MenuPO(WebDriver driver) {
        super(driver);
    }

    public PrescriptionListPO goToPrescriptionPage(){
        prescriptions.click();
        return new PrescriptionListPO(driver);
    }

    public PatientListPO goToPatientPage(){
        patients.click();
        return new PatientListPO(driver);
    }

    public DrugListPO goToDrugsPage(){
        drugs.click();
        return new DrugListPO(driver);
    }

    public UtilsPO goToUtilsPage(){
        utils.click();
        return new UtilsPO(driver);
    }

    public UserListPO goToUsersPage(){
        user.click();
        return new UserListPO(driver);
    }



}
