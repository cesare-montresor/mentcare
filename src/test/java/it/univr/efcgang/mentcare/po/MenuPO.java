package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPO extends PageObject{


    @FindBy(xpath = "//*[@id=\"main-menu\"]/div/div[1]/span[1]/a")
    WebElement home;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/div/div[1]/span[4]/a")
    WebElement prescriptions;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/div/div[1]/span[5]/a")
    WebElement utils;

    public MenuPO(WebDriver driver) {
        super(driver);
    }

    public PrescriptionListEmptyPO goToPrescriptionPageEmpty(){
        prescriptions.click();
        return new PrescriptionListEmptyPO(driver);
    }

    public PrescriptionListPO goToPrescriptionPage(){
        prescriptions.click();
        return new PrescriptionListPO(driver);
    }

    public UtilsPO goToUtilsPage(){
        utils.click();
        return new UtilsPO(driver);
    }
    public void goToHome(){
        //TODO
    }


}
