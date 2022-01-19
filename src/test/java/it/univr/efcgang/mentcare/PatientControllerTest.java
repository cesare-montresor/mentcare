package it.univr.efcgang.mentcare;

import it.univr.efcgang.mentcare.po.MenuPO;
import it.univr.efcgang.mentcare.po.PatientListPO;
import it.univr.efcgang.mentcare.po.PatientPO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientControllerTest extends BaseTest{
    @Test
    public void testListEmptyPatients(){
        /*if(browserLogin("maria", "maria"))
            ;
        */
    }

    @Test
    public void testInitListPatients(){
        //ha bisogno di ulteriore testing
        /*
        PatientListPO patientListPO = getToPatientPage();
        assertEquals(2, patientListPO.getRowNum());
        assertEquals("Giovanni Rossi", patientListPO.getFirstPatient());
        assertEquals(3, patientListPO.getFirstDoctor());
             */
    }


    @Test
    public void testCreatePatient(){

    }
    @Test
    public void testEditPatient(){

    }
    @Test
    public void testDeletePatient(){

    }
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
