package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrescriptionListPO extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement message;

    @FindBy(css = "#prescription-table")
    WebElement table;

    @FindBy(id = "createPrescription")
    WebElement createPrescriptionLink;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody[1]/tr[1]/td[2]")
    WebElement firstPatient;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody[1]/tr[1]/td[3]")
    WebElement firstDrug;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody[1]/tr[1]/td[4]")
    WebElement firstDosage;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody[1]/tr[1]/td[5]")
    WebElement firstDateStart;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody[1]/tr[1]/td[6]")
    WebElement firstDateEnd;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody[1]/tr[1]/td[7]")
    WebElement treatingPhysician;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody/tr/td[8]/a")
    WebElement editFirstEntryLink;

    @FindBy(xpath = "//table[@id='prescription-table']/tbody/tr/td[9]/a")
    WebElement deleteFirstEntryLink;



    public PrescriptionListPO(WebDriver driver) {
        super(driver);
    }


    public PrescriptionCreatePO clickNewPrescription(){
        createPrescriptionLink.click();
        return new PrescriptionCreatePO(driver);
    }

    public PrescriptionEditPO clickEditPrescription(){
        editFirstEntryLink.click();
        return new PrescriptionEditPO(driver);
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
    public String getTreatingPhysician(){
        return treatingPhysician.getText();
    }

    public void deleteFirstEntry(){
        deleteFirstEntryLink.click();
    }




}
