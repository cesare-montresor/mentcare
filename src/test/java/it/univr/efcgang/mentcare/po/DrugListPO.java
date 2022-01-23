package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DrugListPO extends PageObject{

    @FindBy(tagName = "h1")
    WebElement title;


    @FindBy(id = "drug-table")
    WebElement table;


    @FindBy(xpath = "//table[@id='drug-table']/tbody/tr[1]/td[2]")
    WebElement firstDrugName;

    @FindBy(xpath = "//table[@id='drug-table']/tbody/tr[1]/td[3]")
    WebElement firstPrescriptionAmount;


    public DrugListPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getFirstDrugName(){
        return firstDrugName.getText();
    }

    public String getFirstPrescriptionAmount(){
        return firstPrescriptionAmount.getText();
    }
}
