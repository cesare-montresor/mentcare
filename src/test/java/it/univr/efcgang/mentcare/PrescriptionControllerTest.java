package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PrescriptionListPO;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PrescriptionControllerTest extends BaseTest{

    @Test
    public void tableIsInitState(){
        driver.get(baseUrl);

        // Go to Prescription list page
        MenuPO menu = new MenuPO(driver);
        PrescriptionListPO prescriptionlist = menu.goToPrescriptionPage();

        // Check that it's the right pqge
        assertEquals("Prescription list",prescriptionlist.getTitle());

        // Check that entries are as expected

        assertEquals("Andrea Andrei",prescriptionlist.getFirstPatient(),
                "Patient in first row is different than expected");

        assertEquals("drug A",prescriptionlist.getFirstDrug(),
                "Drug in first row is different than expected");

        assertEquals("3 dia",prescriptionlist.getFirstDosage(),
                "Dosage in first row is different than expected");

        /*
        // TODO mi sa che questa data è dinamica
        assertEquals("04-01-2022",prescriptionlist.getFirstDateStart(),
                "Start date in first row is different than expected");
        // TODO mi sa che questa data è dinamica
        assertEquals("04-02-2022",prescriptionlist.getFirstDateEnd(),
                "End date in first row is different than expected");
        */
    }

    @Test
    public void SystemOnline() {
        driver.get(baseUrl);
        driver.manage().window().setSize(new Dimension(300,300));
    }
}
