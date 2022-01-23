package it.univr.efcgang.mentcare.unit;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test class of Drug class in model
 * that test all the methods of that class
 */
public class TestDrug extends BaseTest {

    private final Drug drug = new Drug("Drug A");

    private final User doctor = new User(
            "DocMaria","Password", "Nome", "DOCTOR");

    private final Patient patient = new Patient("Andrea Andrei",doctor);

    Date dateStart = DateUtils.parseDate("11-03-2000", "yyyy-MM-dd");
    Date dateEnd = DateUtils.parseDate("11-03-2000", "yyyy-MM-dd");

    Prescription p = new Prescription(drug,patient,doctor, "Daily", dateStart, dateEnd);

    public TestDrug() throws ParseException {
    }


    @Test
    public void testGetName(){
        assertEquals("Drug A",drug.getName());
    }
    @Test
    public void testSetName(){
        Drug drug2 = new Drug("Drug A");
        drug2.setName("Drug B");
        assertEquals("Drug B",drug2.getName());
    }

    @Test
    public void testSetGetPrescription(){
        ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
        prescriptions.add(p);

        drug.setPrescriptions(prescriptions);

        assertEquals(prescriptions,drug.getPrescriptions());

    }

}
