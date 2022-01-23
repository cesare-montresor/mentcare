package it.univr.efcgang.mentcare.unit;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.models.Drug;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test class of Patient class in model
 * that test all the methods of that class
 */
public class TestPatient extends BaseTest  {


    @Test
    public void testGetterSetter() throws ParseException {
        String name = "Mario Rossi";
        User user = new User("pietro", "pietro", "Pietro Verdi", "DOCTOR");
        Patient p = new Patient(name, user);
        p.setId(40L);
        assertEquals(40L, p.getId(), "Patient id wasn't updated");
        p.setName("Bruno Rossi");
        assertEquals("Bruno Rossi", p.getName(), "Patient name wasn't updated" );
        User doctor = new User("paolo", "paolo","Paolo Franchi", "DOCTOR");
        p.setMainDoctor(doctor);
        assertEquals(doctor, p.getMainDoctor(), "Patient doctor wasn't updated");
        List prescriptions = new ArrayList();
        Calendar cal = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        cal.setTime(today);
        cal.add(Calendar.MONTH, 1);
        Date nextMonth = cal.getTime();

        String start = dateFormat.format(today);
        String end = dateFormat.format(nextMonth);
        Date d1 = dateFormat.parse(start);
        Date d2 = dateFormat.parse(end);

        Prescription prescription = new Prescription(new Drug("Aspirine"), p, doctor, "Every day after breakfast", d1, d2 );
        prescriptions.add(prescription);
        p.setPrescriptions(prescriptions);
        assertEquals(prescriptions, p.getPrescriptions(), "Patient's prescription weren't updated");
    }

    @Test
    public void testContructorValidity(){
        Patient p = new Patient(null, null);
        assertNull(p.getName(), "Patient Name is not null");
        assertNull(p.getMainDoctor(), "Patient doctor is not null");
        User user = new User("pietro", "pietro", "Pietro Verdi", "DOCTOR");
        assertNull(new Patient("", user).getName(), "Patient name is not null");
        assertNull(new Patient("Mario Rossi", null).getMainDoctor(), "Patient doctor is not null");
    }
}
