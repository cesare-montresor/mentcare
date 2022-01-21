package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientControllerTest extends BaseTest{

    /**
     * Test for checking the list of patient in the index page after the call of the method addDemoData
     * that initialize the list of patient with 2 patients
     */
    @Test
    public void testInitListPatients(){

        PatientListPO patientListPO = getToPatientPage();
        assertEquals(2, patientListPO.getRowNum());
        assertEquals("Giovanni Rossi", patientListPO.getFirstPatient());
        assertEquals(3, patientListPO.getFirstDoctor());

    }

    /**
     * Test for adding a new patient into the list and
     * checking if the patient is added
     *
     */

    //TODO
    @Test
    public void testCreatePatient(){
        // Get to index page
        PatientListPO patientListPO = getToPatientPage();

        //Deleting the first 2 patients
        //NON FUNZIONANO
        patientListPO.deleteFirstPatient();
        patientListPO.deleteFirstPatient();

        // Get to create page
        PatientCreatePO patientCreatePO = patientListPO.clickNewPatient();
        patientCreatePO.addPatient();
        assertEquals("Create a new patient", patientCreatePO.getTitle());
        patientListPO = patientCreatePO.createPatient();

        assertEquals("Patients", patientListPO.getTitle());
        assertEquals(3, patientListPO.getRowNum());

        //forse devo usare un modo diverso
        assertEquals("Luca", patientListPO.getFirstPatient());

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
        assertEquals(" Updating a patient", patientEditPO.getTitle());
        patientListPO = patientEditPO.updatePatient();

        assertEquals("Patients", patientListPO.getTitle());
        assertEquals(3, patientListPO.getRowNum());

        //forse devo usare un modo diverso
        assertEquals(1, patientListPO.getFirstPatientDoctor());

    }

    /**
     * Test for deleting a patient that is already in the list and
     * checking if the list of patients is updated
     */
    //TODO
    @Test
    public void testDeletePatient(){
        PatientListPO patientListPO = getToPatientPage();

        patientListPO.deleteFirstPatient();

        assertEquals("Patients", patientListPO.getTitle());
        assertEquals(1, patientListPO.getRowNum());

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
        assertEquals("Patients",patientList.getTitle());
        return patientList;
    }
}
