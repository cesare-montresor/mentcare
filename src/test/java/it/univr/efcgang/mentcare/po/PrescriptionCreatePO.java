package it.univr.efcgang.mentcare.po;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class PrescriptionCreatePO extends PageObject {

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


    public PrescriptionCreatePO(WebDriver driver) {
        super(driver);
    }

    public PageObject insertPrescriptionData(String patient, String drug, String dosage,
                                                     String dateStart, String dateEnd){

        patientSelector.selectByVisibleText(patient);

        drugSelector.selectByVisibleText(drug);

        dosageSelector.click();
        dosageSelector.clear();
        dosageSelector.sendKeys(dosage);

        // Note: datepicker supports sendKeys only if date is
        // sent in standard ISO format (yyyy-MM-dd), independently
        // of how it's displayed in page (for us, dd/MM/yyyy)
        // (I might have lost quite a bit of time on this...)
        dateStartSelector.click();
        dateStartSelector.sendKeys(dateStart);

        dateEndSelector.click();
        dateEndSelector.sendKeys(dateEnd);

        submitButton.click();

        try{
            Date dateStartD = DateUtils.parseDate(dateStart, "yyyy-MM-dd");
            Date dateEndD = DateUtils.parseDate(dateEnd, "yyyy-MM-dd");


            if(dateStartD.compareTo(dateEndD) > 0 || drug == null || patient == null || dosage.equals(""))
                return new PrescriptionCreatePO(driver);
            else
                return new PrescriptionListPO(driver);


        } catch(ParseException e){

        }

        return null;
    }

    public String getErrorMessage(){return errorMessage.getText();}
}
