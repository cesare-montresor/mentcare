package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PrescriptionCreatePO;
import it.univr.efcgang.mentcare.po.PrescriptionEditPO;
import it.univr.efcgang.mentcare.po.PrescriptionListPO;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PrescriptionControllerTest extends BaseTest{

    @Test
    public void testTableInitState(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

            // Patient
        assertEquals("Andrea Andrei",prescriptionList.getFirstPatient(),
                "Patient in first row is different than expected");

            // Drug
        assertEquals("drug A",prescriptionList.getFirstDrug(),
                "Drug in first row is different than expected");

            // Dosage
        assertEquals("3 dia",prescriptionList.getFirstDosage(),
                "Dosage in first row is different than expected");

        String today = generateTodayNextMonthDates(new SimpleDateFormat("dd-MM-yyyy"))[0];
        String nextMonth = generateTodayNextMonthDates(new SimpleDateFormat("dd-MM-yyyy"))[1];

            // Start date
        assertEquals(today,prescriptionList.getFirstDateStart(),
                "Start date in first row is "+ prescriptionList.getFirstDateStart() +" instead of"+ today);

            // End date
        assertEquals(nextMonth,prescriptionList.getFirstDateEnd(),
                "Start date in first row is "+ prescriptionList.getFirstDateEnd() +" instead of"+ nextMonth);

            // Physician
        assertEquals("maria",prescriptionList.getTreatingPhysician(),
                "Start date in first row is "+ prescriptionList.getTreatingPhysician() +"instead of \"maria\"");

    }


    @Test
    public void testDeletePrescription(){
        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Check table is not empty
        assertEquals(2,prescriptionList.getRowsNumber(),
                "Table wasn't initialized correctly");

        // Delete first entry
        prescriptionList.deleteFirstEntry();

        // Check that entry was deleted
        assertEquals(1,prescriptionList.getRowsNumber(),"Entry wasn't deleted correctly");

    }


    @Test
    public void testAddPrescription(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Get to Create page
        PrescriptionCreatePO prescriptionCreate = prescriptionList.clickNewPrescription();

        //Insert data
        prescriptionList = prescriptionCreate.insertPrescriptionData("Giovanni Rossi","drug A","Once per day",
                generateTodayNextMonthDates(new SimpleDateFormat("yyyy-MM-dd"))[0],
                generateTodayNextMonthDates(new SimpleDateFormat("yyyy-MM-dd"))[1]);

        // Check if data was inserted correctly

        // TODO: for now, I delete the first row in order to reuse getFirstX function. Is this ok?
        prescriptionList.deleteFirstEntry();

        // Patient
        assertEquals("Giovanni Rossi",prescriptionList.getFirstPatient(),
                "Patient in first row is different than expected");

        // Drug
        assertEquals("drug A",prescriptionList.getFirstDrug(),
                "Drug in first row is different than expected");

        // Dosage
        assertEquals("Once per day",prescriptionList.getFirstDosage(),
                "Dosage in first row is different than expected");

        String today = generateTodayNextMonthDates(new SimpleDateFormat("dd-MM-yyyy"))[0];
        String nextMonth = generateTodayNextMonthDates(new SimpleDateFormat("dd-MM-yyyy"))[1];

        // Start date
        assertEquals(today,prescriptionList.getFirstDateStart(),
                "Start date in first row is "+ prescriptionList.getFirstDateStart() +" instead of"+ today);

        // End date
        assertEquals(nextMonth,prescriptionList.getFirstDateEnd(),
                "Start date in first row is "+ prescriptionList.getFirstDateEnd() +" instead of"+ nextMonth);

        // Physician
        assertEquals("maria",prescriptionList.getTreatingPhysician(),
                "Start date in first row is "+ prescriptionList.getTreatingPhysician() +"instead of \"maria\"");


    }

    @Test
    public void testEditPrescription(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Click on edit link //TODO: button would be prettier!
        PrescriptionEditPO prescriptionEdit = prescriptionList.clickEditPrescription();

        // Enter edits and submit
        prescriptionEdit.editDosage("Twice a day");
        prescriptionEdit.editStartDate(generateTodayNextMonthDates(new SimpleDateFormat("yyyy-MM-dd"))[0]);
        prescriptionEdit.editEndDate(generateTodayNextMonthDates(new SimpleDateFormat("yyyy-MM-dd"))[1]);
        prescriptionList = prescriptionEdit.confirmEdit();

        // Check results

        // TODO: for now, I delete the first row in order to reuse getFirstX function. Is this ok?
        prescriptionList.deleteFirstEntry();

        // Dosage
        assertEquals("Twice a day",prescriptionList.getFirstDosage(),
                "Dosage in first row is different than expected");

        String today = generateTodayNextMonthDates(new SimpleDateFormat("dd-MM-yyyy"))[0];
        String nextMonth = generateTodayNextMonthDates(new SimpleDateFormat("dd-MM-yyyy"))[1];

        // Start date
        assertEquals(today,prescriptionList.getFirstDateStart(),
                "Start date in first row is "+ prescriptionList.getFirstDateStart() +" instead of"+ today);

        // End date
        assertEquals(nextMonth,prescriptionList.getFirstDateEnd(),
                "Start date in first row is "+ prescriptionList.getFirstDateEnd() +" instead of"+ nextMonth);


    }

    /***
     * Every one of the above test must get to the Prescription list page to start. Hence,
     * I moved relative code here to avoid repeating it in each function
     * @return PrescriptionListPO of curerntly visualized prescription list page.
     */
    private PrescriptionListPO getToPrescriptionPage(){

        driver.get(baseUrl);
        // Login
        browserLogin("maria","maria");

        // Go to Prescription list page
        MenuPO menu = new MenuPO(driver);
        PrescriptionListPO prescriptionList = menu.goToPrescriptionPage();

        // Check that it's the right page
        assertEquals("Prescriptions",prescriptionList.getTitle());
        return prescriptionList;
    }

    /***
     * This is horrible but I don't have better ideas atm. Calculates (and formats to correct string)
     * today and next month date dynamically (as it's done in DemoData)
     * @param dateFormat  a DateFormat object with the desired format.
     * @return Array of two strings: [0] for today's date and [1] for next month's date.
     */
    private String[] generateTodayNextMonthDates(DateFormat dateFormat){
        Calendar cal = Calendar.getInstance();

        Date today = new Date();
        cal.setTime(today);
        cal.add(Calendar.MONTH, 1);
        Date nextMonth = cal.getTime();

        String[] result = new String[2];
        result[0] = dateFormat.format(today);
        result[1] = dateFormat.format(nextMonth);
        return result;
    }
}
