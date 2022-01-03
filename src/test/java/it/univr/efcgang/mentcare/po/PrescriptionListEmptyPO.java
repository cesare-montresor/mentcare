package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrescriptionListEmptyPO extends PageObject{

    // TODO there is duplicate code between this and PrescriptionListPO
    @FindBy(tagName = "h1")
    private WebElement message;

    @FindBy(xpath = "/html/body/table/tbody")
    WebElement table;

    @FindBy(id = "createPrescription")
    WebElement createPrescriptionLink;

    public PrescriptionListEmptyPO(WebDriver driver) {
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



}
