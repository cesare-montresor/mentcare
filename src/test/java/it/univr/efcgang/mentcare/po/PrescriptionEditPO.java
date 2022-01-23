package it.univr.efcgang.mentcare.po;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.Date;

public class PrescriptionEditPO extends PageObject {

    @FindBy(css = "#patient_selector")
    WebElement patientSelectorWE;
    Select patientSelector = new Select(patientSelectorWE);

    @FindBy(css = "#drug_selector")
    WebElement drugSelectorWE;
    Select drugSelector = new Select(drugSelectorWE);

    @FindBy(css = "#dosage_selector")
    WebElement dosageSelector;

    @FindBy(css = "#datestart-selector")
    WebElement dateStartSelector;

    @FindBy(css = "#dateend-selector")
    WebElement dateEndSelector;

    @FindBy(id = "submit-button")
    WebElement submitButton;

    @FindBy(id = "error_msg")
    WebElement errorMessage;


    public PrescriptionEditPO(WebDriver driver) {
        super(driver);
    }

    public void editDosage(String dosage){
        dosageSelector.clear();
        dosageSelector.sendKeys(dosage);
    }

    public void editStartDate(String dateStart){
        dateStartSelector.sendKeys(dateStart);
    }
    public void editEndDate(String dateEnd){
        dateEndSelector.sendKeys(dateEnd);
    }

    public PageObject confirmEdit(boolean isValid){
        submitButton.click();

        if (isValid)
            return new PrescriptionListPO(driver);
        return new PrescriptionEditPO(driver);
    }

    public String getPatient(){
        return patientSelector.getFirstSelectedOption().getText();
    }

    public String getDrug(){
        return drugSelector.getFirstSelectedOption().getText();
    }

    public String getDosage(){
        return dosageSelector.getAttribute("value");
    }

    public String getDateStart(){
        return dateStartSelector.getAttribute("value");
    }

    public String getDateEnd(){
        return dateEndSelector.getAttribute("value");
    }

    public String getErrorMessage(){return errorMessage.getText();}
}
