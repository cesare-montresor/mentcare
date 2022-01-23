package it.univr.efcgang.mentcare.ui;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.po.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PrescriptionControllerTest extends BrowserTest {

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
    void testDeletePrescription404(){

        driver.get(baseUrl);
        // Login
        browserLogin("maria","maria");

        driver.get(baseUrl + "/prescription/delete?id=0");
        assertEquals(driver.findElement(By.tagName("h1")).getText(),"404 - Not found");

    }


    @Test
    public void testAddPrescription(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Get to Create page
        PrescriptionCreatePO prescriptionCreate = prescriptionList.clickNewPrescription();

        //Insert data
        prescriptionList = (PrescriptionListPO) prescriptionCreate.insertPrescriptionData("Giovanni Rossi","drug A","Once per day",
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
    public void testAddPrescriptionWrongDate(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Get to Create page
        PrescriptionCreatePO prescriptionCreate = prescriptionList.clickNewPrescription();

        //Insert data
         prescriptionCreate = (PrescriptionCreatePO) prescriptionCreate.insertPrescriptionData("Giovanni Rossi",
                "drug A",
                "Once per day",
                "2023-11-01",
                "2023-01-01");

        // Check that system didn't accept this date
        assertEquals("End date cannot be before start date.",prescriptionCreate.getErrorMessage());



    }

    @Test
    public void testAddPrescriptionWrongDosage(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Get to Create page
        PrescriptionCreatePO prescriptionCreate = prescriptionList.clickNewPrescription();

        //Insert data
        PrescriptionCreatePO prescription404 = (PrescriptionCreatePO) prescriptionCreate.insertPrescriptionData(
                "Giovanni Rossi",
                "drug A",
                "",
                "2023-11-01",
                "2023-11-01");

        // Check that system didn't accept this
        assertEquals("Dosage is not set. ",prescription404.getErrorMessage());



    }



    @Test
    public void testEditPrescription(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Click on edit link
        PrescriptionEditPO prescriptionEdit = prescriptionList.clickEditPrescription();


        // Enter edits and submit
        prescriptionEdit.editDosage("Twice a day");
        prescriptionEdit.editStartDate(generateTodayNextMonthDates(new SimpleDateFormat("yyyy-MM-dd"))[0]);
        prescriptionEdit.editEndDate(generateTodayNextMonthDates(new SimpleDateFormat("yyyy-MM-dd"))[1]);
        prescriptionList = (PrescriptionListPO) prescriptionEdit.confirmEdit(true);

        // Check results

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

    @Test
    public void testEditPrescriptionWrongDate(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Click on edit link
        PrescriptionEditPO prescriptionEdit = prescriptionList.clickEditPrescription();

        // Enter edits and submit
        prescriptionEdit.editStartDate("2023-11-10");
        prescriptionEdit.editEndDate("2022-11-10");

        prescriptionEdit = (PrescriptionEditPO) prescriptionEdit.confirmEdit(false);

        assertEquals(prescriptionEdit.getErrorMessage(),"End date cannot be before start date.");


    }

    @Test
    public void testEditPrescriptionWrongDosage(){

        // Get to page
        PrescriptionListPO prescriptionList = getToPrescriptionPage();

        // Click on edit link
        PrescriptionEditPO prescriptionEdit = prescriptionList.clickEditPrescription();

        // Enter edits and submit
        prescriptionEdit.editDosage("");

        prescriptionEdit = (PrescriptionEditPO) prescriptionEdit.confirmEdit(false);

        assertEquals(prescriptionEdit.getErrorMessage(),"Dosage is not set. ");


    }


    // Utilites


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
