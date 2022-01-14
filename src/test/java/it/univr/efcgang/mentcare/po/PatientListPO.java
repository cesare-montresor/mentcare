package it.univr.efcgang.mentcare.po;

import it.univr.efcgang.mentcare.po.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PatientListPO extends PageObject {

    @FindBy(tagName = "/html/body/div[1]/div/h1")
    private WebElement title;

    @FindBy(css="patient-table")
    private WebElement table;

    //@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
    @FindBy(xpath = "//table[@id='patient-table']/tbody[1]/tr[1]/td[2]")
    private WebElement patientName;

    @FindBy(xpath ="//table[@id='patient-table']/tbody[1]/tr[1]/td[3]")
    private WebElement doctorId;
    /*INDEX*/
    @FindBy(css="page-patient-index-edit")
    WebElement indexEdit;
    @FindBy(css="page-patient-index-delete")
    WebElement indexDelete;
    @FindBy(css="page-patient-index-create")
    WebElement indexCreate;

    public PatientListPO(WebDriver driver) {
        super(driver);
    }


    public String getTitle() {
        return title.getText();
    }
    public Integer getRowNum(){
        return table.findElements(By.tagName("tr")).size();
    }
    public String getFirstPatient(){
        return patientName.getText();
    }
    public Integer getFirstDoctor(){
        return Integer.parseInt(doctorId.getText());
    }
}
