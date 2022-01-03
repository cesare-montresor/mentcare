package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrescriptionListPO extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement message;

    @FindBy(xpath = "/html/body/table/tbody")
    WebElement table;

    @FindBy(id = "createPrescription")
    WebElement createPrescriptionLink;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[2]")
    WebElement firstPatient;
    @FindBy(xpath = "/html/body/table/tbody/tr/td[3]")
    WebElement firstDrug;
    @FindBy(xpath = "/html/body/table/tbody/tr/td[4]")
    WebElement firstDosage;
    @FindBy(xpath = "/html/body/table/tbody/tr/td[5]")
    WebElement firstDateStart;
    @FindBy(xpath = "/html/body/table/tbody/tr/td[6]")
    WebElement firstDateEnd;

    public PrescriptionListPO(WebDriver driver) {
        super(driver);
    }

    public PrescriptionCreatePO clickNewPrescription(){
        createPrescriptionLink.click();
        return new PrescriptionCreatePO(driver);
    }

    public String getTitle(){
        return message.getText();
    }

    public int getRowsNumber(){
        try{
            return table.findElements(By.tagName("tr")).size();
        }catch(Exception e){
            return 0;
        }
    }

    public String getFirstPatient(){
        return firstPatient.getText();
    }
    public String getFirstDrug(){
        return firstDrug.getText();
    }
    public String getFirstDosage(){
        return firstDosage.getText();
    }
    public String getFirstDateStart(){
        return firstDateStart.getText();
    }
    public String getFirstDateEnd(){
        return firstDateEnd.getText();
    }



}
