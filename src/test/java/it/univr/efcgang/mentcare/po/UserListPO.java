package it.univr.efcgang.mentcare.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListPO extends PageObject{

    @FindBy(tagName = "h1")
    WebElement title;


    @FindBy(id = "user-table")
    WebElement table;


    @FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]/td[2]")
    WebElement firstUsername;

    @FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]/td[3]")
    WebElement firstName;

    @FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]/td[4]")
    WebElement firstRole;

    @FindBy(xpath = "//table[@id='user-table']/tbody/tr[1]/td[5]")
    WebElement firstActive;


    public UserListPO(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getFirstUsername(){
        return firstUsername.getText();
    }

    public String getFirstName(){
        return firstName.getText();
    }

    public String getFirstRole(){
        return firstRole.getText();
    }

    public String getFirstActive(){
        return firstActive.getText();
    }
}
