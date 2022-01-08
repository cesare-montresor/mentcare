package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PrescriptionListEmptyPO;
import it.univr.efcgang.mentcare.po.PrescriptionListPO;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PrescriptionControllerTest extends BaseTest{



    @Test
    public void tableIsInitState(){
        driver.get(baseUrl);

        // Login
        browserLogin("maria","maria");

        // Go to Prescription list page
        MenuPO menu = new MenuPO(driver);
        PrescriptionListPO prescriptionlist = menu.goToPrescriptionPage();

        // Check that it's the right page
        assertEquals("Prescriptions",prescriptionlist.getTitle());

        // Check that entries are as expected

            // Patient
        assertEquals("Andrea Andrei",prescriptionlist.getFirstPatient(),
                "Patient in first row is different than expected");

            // Drug
        assertEquals("drug A",prescriptionlist.getFirstDrug(),
                "Drug in first row is different than expected");

            // Dosage
        assertEquals("3 dia",prescriptionlist.getFirstDosage(),
                "Dosage in first row is different than expected");

        String today = generateDates()[0];
        String nextMonth = generateDates()[1];

            // Start date
        assertEquals(today,prescriptionlist.getFirstDateStart(),
                "Start date in first row is "+ prescriptionlist.getFirstDateStart() +" instead of"+ today);

            // End date
        assertEquals(nextMonth,prescriptionlist.getFirstDateEnd(),
                "Start date in first row is "+ prescriptionlist.getFirstDateEnd() +" instead of"+ nextMonth);

            // Physician
        assertEquals("maria",prescriptionlist.getTreatingPhysician(),
                "Start date in first row is "+ prescriptionlist.getTreatingPhysician() +"instead of \"maria\"");

    }

    // This is horrible but I don't have better ideas atm. Calculates (and formats to correct string)
    // today and next month date dynamically (as it's done in DemoData)
    private String[] generateDates(){
        Calendar cal = Calendar.getInstance();

        Date today = new Date();
        cal.setTime(today);
        cal.add(Calendar.MONTH, 1);
        Date nextMonth = cal.getTime();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        String[] result = new String[2];
        result[0] = dateFormat.format(today);
        result[1] = dateFormat.format(nextMonth);
        return result;
    }
}
