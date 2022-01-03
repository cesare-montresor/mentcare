package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPO extends PageObject{


    @FindBy(xpath = "//*[@id=\"main-menu\"]/div/div[1]/span[4]/a")
    WebElement prescriptions;

    public MenuPO(WebDriver driver) {
        super(driver);
    }

    public PrescriptionEmptyPO goToPrescriptionPageEmpty(){
        prescriptions.click();
        return new PrescriptionEmptyPO(driver);
    }


}
