package it.univr.efcgang.mentcare.ui;

import it.univr.efcgang.mentcare.po.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientControllerTest extends BrowserTest {

    /**
     * Test for checking the list of patient in the index page after the call of the method addDemoData
     * that initialize the list of patient with 2 patients
     */
    @Test
    public void testInitListPatients(){

        PatientListPO patientListPO = getToPatientPage();
        assertEquals(5, patientListPO.getRowNum(), "The table wasn't initialized correcty");
        assertEquals("Giovanni Rossi", patientListPO.getFirstPatient(), "Patient name was different");
        assertEquals("maria", patientListPO.getFirstDoctor(), "DoctorName of the patient was different");
        /*logout();
        resetDb();*/
    }

    /**
     * Test for adding a new patient into the list and
     * checking if the patient is added
     *
     */

    @Test
    public void testCreatePatient(){
        // Get to index page
        PatientListPO patientListPO = getToPatientPage();

        // Get to create page
        PatientCreatePO patientCreatePO = patientListPO.clickNewPatient();
        patientCreatePO.addPatient();
        assertEquals("Create a new patient", patientCreatePO.getTitle(), "Page title of create.html is different than expected");
        patientListPO = patientCreatePO.createPatient();

        assertEquals("Patients", patientListPO.getTitle(),"Page title of patient index.html is different than expected");
        //The new patient is the third in the list (because there was already other 2 patient
        assertEquals(6, patientListPO.getRowNum(), "Entry wasn't added to the list");

        assertEquals("Mario Rossi", patientListPO.getThirdPatient(), "Name of the new patient is different");

    }
    @Test
    public void testCreatePatientWrongInput(){
        // Get to index page
        PatientListPO patientListPO = getToPatientPage();

        // Get to create page
        PatientCreatePO patientCreatePO = patientListPO.clickNewPatient();
        patientCreatePO.addPatientWithWrongData();

        assertEquals("Create a new patient", patientCreatePO.getTitle(), "Page title of create.html is different than expected");
        assertEquals("Patient name is not set.", patientCreatePO.getErrorMsg());
    }

    @Test
    public void testEditPatientWrongInput(){
        // Get to index page
        PatientListPO patientListPO = getToPatientPage();

        // Get to create page
        PatientEditPO patientEditPO = patientListPO.editFirstPatient();
        patientEditPO.editPatientWithWrongData();

        assertEquals("Updating a patient", patientEditPO.getTitle(), "Page title of edit.html is different than expected");
        assertEquals("Patient name is not set.", patientEditPO.getErrorMsg());

    }

    /**
     * Test for editing a patient that is already in the list and
     * checking if its information are updated
     */
    //TODO
    @Test
    public void testEditPatient(){
        // Get to patient page
        PatientListPO patientListPO = getToPatientPage();
        // Get to edit page
        PatientEditPO patientEditPO = patientListPO.editFirstPatient();

        patientEditPO.editPatient();
        assertEquals("Updating a patient", patientEditPO.getTitle(), "Page title of edit.html is different than expected");
        //in this case the method change the doctor of the patient
        patientListPO = patientEditPO.updatePatient();

        assertEquals("Patients", patientListPO.getTitle(), "Page title of patient index.html is different than expected");
        assertEquals(5, patientListPO.getRowNum(), "Row number of table is different than expected");

        //The updated patient becomes the second patient of the list,
        // although before the update it was the first
        assertEquals("maria", patientListPO.getSecondPatientDoctor(), "Doctor wasn't updated correctly");

    }

    /**
     * Test for checking that is impossible to edit a patient that doesn't exists in the list
     */
    @Test
    public void testEditPatientNotFound(){
        // Get to patient page
        PatientListPO patientListPO = getToPatientPage();
        String url = baseUrl + "/patient/edit?id=400";
        //trying to edit a patient with an non exiting id
        PatientNotFoundPO patientEditNotFoundPO = patientListPO.notFoundPatient(url);
        assertEquals("ERROR: Patient not found", patientEditNotFoundPO.getTitle(), "Page title of patient error.html is different than expected");
    }

    /**
     * Test for checking that is impossible to update information of a patient that doesn't exists in the list
     */
    @Test
    public void testUpdatePatientNotFound(){
        // Get to patient page
        PatientListPO patientListPO = getToPatientPage();
        String url = baseUrl + "/patient/update?id=400&name=Debora&doctor_id=1000";
        //trying to edit a patient with an non exiting id
        PatientNotFoundPO patientUpdateNotFoundPO = patientListPO.notFoundPatient(url);
        assertEquals("ERROR: Patient not found", patientUpdateNotFoundPO.getTitle(), "Page title of patient error.html is different than expected");
    }

    /**
     * Test for deleting a patient that is already in the list and
     * checking if the list of patients is updated
     */
    @Test
    public void testDeletePatient(){
        PatientListPO patientListPO = getToPatientPage();
        //check table is not empty
        assertEquals(5, patientListPO.getRowNum(),"The table wasn't initialized correcty");


        patientListPO.deleteFirstPatient();

        assertEquals("Patients", patientListPO.getTitle(), "Page title of patient index.html is different than expected");
        assertEquals(4, patientListPO.getRowNum(), "Entry wasn't deleted correctly");
    }

    /**
     * Test for checking that is impossible to delete a patient that doesn't exists in the list
     */
    @Test
    public void testDeletePatientNotFound(){
        // Get to patient page
        PatientListPO patientListPO = getToPatientPage();
        String url = baseUrl + "/patient/delete?id=400";
        //trying to edit a patient with an non exiting id
        PatientNotFoundPO patientUpdateNotFoundPO = patientListPO.notFoundPatient(url);
        assertEquals("ERROR: Patient not found", patientUpdateNotFoundPO.getTitle(), "Page title of patient error.html is different than expected");
    }


    /**
     * Every test in this class start from the patient index page. Instead of writing every time the
     * same lines of code is better calling this function
     * @return PatientListPO
     */
    private PatientListPO getToPatientPage(){

        driver.get(baseUrl);

        // Login
        browserLogin("maria","maria");

        // Go to Patient list page
        MenuPO menu = new MenuPO(driver);
        PatientListPO patientList = menu.goToPatientPage();

        // Check that it's the right page
        assertEquals("Patients",patientList.getTitle(), "Page title of patient index.html is different than expected");
        return patientList;
    }
}
