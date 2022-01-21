package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PatientListPO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientControllerTest extends BaseTest{

    /**
     * Test for checking the list of patient in the index page after the call of the method addDemoData
     * that initialize the list of patient with 2 patients
     */
    @Test
    public void testInitListPatients(){
        //ha bisogno di ulteriore testing

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

    @Test
    public void testCreatePatient(){
        PatientListPO patientListPO = getToPatientPage();

    }

    /**
     * Test for editing a patient that is already in the list and
     * checking if its information are updated
     */
    @Test
    public void testEditPatient(){
        PatientListPO patientListPO = getToPatientPage();

    }

    /**
     * Test for deleting a patient that is already in the list and
     * checking if the list of patients is updated
     */
    @Test
    public void testDeletePatient(){
        PatientListPO patientListPO = getToPatientPage();

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
