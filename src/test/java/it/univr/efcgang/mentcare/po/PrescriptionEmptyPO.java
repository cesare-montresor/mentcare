package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrescriptionEmptyPO extends PageObject{

    @FindBy(tagName = "h1")
    private WebElement message;

    @FindBy(xpath = "/html/body/table/tbody")
    WebElement table;

    @FindBy(id = "createPrescription")
    WebElement createPrescriptionLink;

    public PrescriptionEmptyPO(WebDriver driver) {
        super(driver);
    }

    public CreatePrescriptionPO clickNewPrescription(){
        createPrescriptionLink.click();
        return new CreatePrescriptionPO(driver);
    }


}
