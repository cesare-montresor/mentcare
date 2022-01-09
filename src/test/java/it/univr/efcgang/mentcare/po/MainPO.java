package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPO extends PageObject {

    /* LOGIN */
    @FindBy(css = "#page-login h1")
    public WebElement loginTitle;
    @FindBy(css = "#page-login-username")
    public WebElement loginUsername;
    @FindBy(css = "#page-login-password")
    public WebElement loginPassword;
    @FindBy(css = "#page-login-submit")
    public WebElement loginSubmit;

    public void loginPerform(){
        loginSubmit.click();
    }
    public void loginSetUsername(String username){
        loginUsername.clear();
        loginUsername.sendKeys(username);
    }
    public void loginSetPassword(String password){
        loginPassword.clear();
        loginPassword.sendKeys(password);
    }



    /* PROFILE */
    @FindBy(css = "#page-content h1")
    public WebElement profileTitle;
    @FindBy(css = "#page-profile-username")
    public WebElement profileUsername ;
    @FindBy(css = "#page-profile-password")
    public WebElement profilePassword;
    @FindBy(css = "#page-profile-roles")
    public WebElement profileRoles;
    @FindBy(css = "#page-profile-active")
    public WebElement profileActive;

    public MainPO(WebDriver driver) {super(driver);}
}