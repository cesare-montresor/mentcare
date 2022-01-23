package it.univr.efcgang.mentcare.unit;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.text.ParseException;
import java.util.Date;

/**
 * Unit test class of Patient class in model
 * that test all the methods of that class
 */
public class TestPrescription extends BaseTest {

    private final Drug drug = new Drug("Drug A");

    private final User doctor = new User(
            "DocMaria","Password", "Nome", "DOCTOR");

    private final Patient patient = new Patient("Andrea Andrei",doctor);

    Date dateStart = DateUtils.parseDate("11-03-2000", "yyyy-MM-dd");
    Date dateEnd = DateUtils.parseDate("11-03-2000", "yyyy-MM-dd");

    Prescription p = new Prescription(drug,patient,doctor, "Daily", dateStart, dateEnd);

    public TestPrescription() throws ParseException {
    }

        // Getters

    @Test
    public void testGetDrug() { assertEquals(drug,p.getDrug());    }

    @Test
    public void testGetDoctor(){ assertEquals(doctor, p.getDoctor());    }

    @Test
    public void testGetPatient(){ assertEquals(patient,p.getPatient());    }

    @Test
    public void testGetDosage(){assertEquals("Daily",p.getDosage());    }

    @Test
    public void testGetDateStart(){assertEquals(dateStart,p.getDateStart());    }

    @Test
    public void testGetDateEnd(){assertEquals(dateEnd,p.getDateEnd());    }


    @Test
    public void testGetValid(){assertEquals(p.isValid(),true );   }

    // Validity NULL

    @Test
    public void testNullDrug(){
        Prescription p = new Prescription(null,patient,doctor, "Daily", dateStart, dateEnd);
        assertEquals(false,p.getValidity());
        assertEquals("Drug is not set. ",p.getValidDescription());
    }

    @Test
    public void testNullPatient(){
        Prescription p = new Prescription(drug,null,doctor, "Daily", dateStart, dateEnd);
        assertEquals(false,p.getValidity());
        assertEquals("Patient is not set. ",p.getValidDescription());
    }

    @Test
    public void testNullDoctor(){
        Prescription p = new Prescription(drug,patient,null, "Daily", dateStart, dateEnd);
        assertEquals(false,p.getValidity());
        assertEquals("User is not set; something went wrong in authentication. ",p.getValidDescription());
    }

    @Test
    public void testEmptyDosage(){
        Prescription p = new Prescription(drug,patient,doctor, "", dateStart, dateEnd);
        assertEquals(false,p.getValidity());
        assertEquals("Dosage is not set. ",p.getValidDescription());
    }

    @Test
    public void testNullDateStart(){
        Prescription p = new Prescription(drug,patient,doctor, "Daily", null, dateEnd);
        assertEquals(false,p.getValidity());
        assertEquals("Start date is not set. ",p.getValidDescription());
    }

    @Test
    public void testNullDateEnd(){
        Prescription p = new Prescription(drug,patient,doctor, "Daily", dateStart, null);
        assertEquals(false,p.getValidity());
        assertEquals("End date is not set. ",p.getValidDescription());
    }

    @Test
    public void testInvalidDates() throws ParseException {
        Prescription p = new Prescription(drug,patient,doctor, "Daily",
                DateUtils.parseDate("11-03-2010", "yyyy-MM-dd"),
                DateUtils.parseDate("11-03-2000", "yyyy-MM-dd"));

        assertEquals(false,p.getValidity());
        assertEquals("End date cannot be before start date.", p.getValidDescription());
    }




}
