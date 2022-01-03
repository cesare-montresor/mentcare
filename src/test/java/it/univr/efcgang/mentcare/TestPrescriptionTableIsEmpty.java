package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PrescriptionEmptyPO;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrescriptionTableIsEmpty extends BaseTest{
    @Test
    public void testPrescriptionTableIsEmpty(){

        MenuPO menuPage = new MenuPO(driver);

        // Go to prescription page
        PrescriptionEmptyPO prescriptionEmptyPage = menuPage.goToPrescriptionPageEmpty(driver);

        // Check I'm in correct page
        assertEquals("prescription",prescriptionEmptyPage.getMessage());


    }
}
