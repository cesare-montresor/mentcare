package it.univr.efcgang.mentcare.unit;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test class of User class in model
 * that test all the methods of that class
 */
public class TestUser extends BaseTest {

    User testUser = new User(
            Long.parseLong("1"),
            "TestUser",
            "password",
            "Test",
            "DOCTOR",
            true,
            null,
            null );


    @Test
    public void testSetGetUsername(){
        testUser.setUsername("TestUser2");
        assertEquals("TestUser2", testUser.getUsername()); }

    @Test
    public void testSetGetPassword() {
        testUser.setPassword("password2");
        assertEquals("password2", testUser.getPassword()); }


    @Test
    public void testSetGetName() {
        testUser.setName("Test2");
        assertEquals("Test2", testUser.getName()); }


    @Test
    public void testSetGetRoles() {
        testUser.setRoles("DOCTOR2");
        assertEquals("DOCTOR2", testUser.getRoles()); }


    @Test
    public void testSetGetActive(){
        testUser.setActive(false);
        assertEquals(false, testUser.getActive()); }


    @Test
    public void testSetGetPatients(){
        final Patient patient = new Patient("Andrea Andrei",testUser);
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        testUser.setPatients(patientList);
        assertEquals(testUser.getPatients(),patientList);
    }

    @Test
    public void testSetGetPrescriptions(){

        final Prescription prescription = new Prescription();
        ArrayList<Prescription> prescriptionList = new ArrayList<Prescription>();
        testUser.setPrescriptions(prescriptionList);
        assertEquals(testUser.getPrescriptions(),prescriptionList);

    }
}
