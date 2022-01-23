package it.univr.efcgang.mentcare.ui;

import it.univr.efcgang.mentcare.po.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DrugControllerTest extends BrowserTest {



    @Test
    public void testDrugViewInit(){

        driver.get(baseUrl);

        browserLogin("maria", "maria");

        MenuPO menu = new MenuPO(driver);
        DrugListPO drugList = menu.goToDrugsPage();

        // Check that it's the right page
        assertEquals("Drugs",drugList.getTitle());

        // Check that there is the correct data
        assertEquals("drug A",drugList.getFirstDrugName());
        assertEquals("1",drugList.getFirstPrescriptionAmount());

    }
}
