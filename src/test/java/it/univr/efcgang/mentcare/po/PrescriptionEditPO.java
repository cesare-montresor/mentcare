package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    public PrescriptionListPO confirmEdit(){
        submitButton.click();
        return new PrescriptionListPO(driver);
    }


}
