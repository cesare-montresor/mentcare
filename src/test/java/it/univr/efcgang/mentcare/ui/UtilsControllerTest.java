package it.univr.efcgang.mentcare.ui;

import it.univr.efcgang.mentcare.controller.UtilsController;
import it.univr.efcgang.mentcare.po.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UtilsControllerTest extends BrowserTest {

    @Test
    public void testDBStats(){

        driver.get(baseUrl);

        browserLogin("admin", "admin");

        MenuPO menu = new MenuPO(driver);
        UtilsPO utilsPage = menu.goToUtilsPage();

        //Check I'm on correct page
        assertEquals("Utils",utilsPage.getTitle());

        // Go to stats
        DBStatPO dbStat = utilsPage.goToDBStat();

        //Check I'm on correct page
        assertEquals(dbStat.getTitle(),"Database Stats");

        assertEquals("Drugs: 8",dbStat.getStatDrug());
        assertEquals("Users: 5",dbStat.getStatUser());
        assertEquals("Patients: 5",dbStat.getStatPatient());
        assertEquals("Prescription: 1",dbStat.getStatPrescription());



    }
}
