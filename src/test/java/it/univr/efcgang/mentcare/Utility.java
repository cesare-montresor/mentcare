package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.InitDatabasePO;
import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.UtilsPO;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Utility {
    public static void initializeDatabase(WebDriver driver) {
        MenuPO menu = new MenuPO(driver);
        UtilsPO utils = menu.goToUtilsPage();

        // Check if I'm in Utils page
        assertEquals("Utils",utils.getTitle());

        // Click on database initialization utility
        InitDatabasePO initdatabase = utils.initDatabase();

        // Check if I'm in post-initialization page
        assertEquals("InitDatabase",initdatabase.getTitle());

        // Goes back to home page
        // TODO


    }
}
