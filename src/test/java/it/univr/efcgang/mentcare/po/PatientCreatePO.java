package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * This class is used for testing method testCreatePatient of class PatientControllerTest
 */
public class PatientCreatePO extends PageObject{
    @FindBy(css ="#page-patient-create-title")
    WebElement createTitle;
    /*CREATE*/
    @FindBy(css="#page-patient-create-name")
    WebElement createName;
    @FindBy(css="#page-patient-create-doctor")
    WebElement createDoctor;

    Select select;
    @FindBy(css="#page-patient-create-submit")
    WebElement createSubmit;

    public PatientCreatePO(WebDriver driver) {
        super(driver);
        select = new Select(createDoctor);
    }

    //TODO
    public void addPatient() {
        createName.sendKeys("Luca Bianchi");
        select.getFirstSelectedOption();
        //oppure
        //select.selectByVisibleText("maria");

    }


    public String getTitle() {
        return createTitle.getText();
    }

    public PatientListPO createPatient() {
        createSubmit.click();
        return new PatientListPO(driver);
    }
}
