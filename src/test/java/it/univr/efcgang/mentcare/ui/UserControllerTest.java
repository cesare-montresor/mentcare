package it.univr.efcgang.mentcare.ui;

import it.univr.efcgang.mentcare.po.DrugListPO;
import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.UserListPO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserControllerTest extends BrowserTest {



    @Test
    public void testDrugViewInit(){

        driver.get(baseUrl);

        browserLogin("admin", "admin");

        MenuPO menu = new MenuPO(driver);
        UserListPO userList = menu.goToUsersPage();

        // Check that it's the right page
        assertEquals("User list",userList.getTitle());

        // Check that there is the correct data
        assertEquals("guest",userList.getFirstUsername());
        assertEquals("guest",userList.getFirstName());
        assertEquals("GUEST",userList.getFirstRole());
        assertEquals("true",userList.getFirstActive());

    }
}
