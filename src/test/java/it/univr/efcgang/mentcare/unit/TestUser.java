package it.univr.efcgang.mentcare.unit;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.models.User;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * Unit test class of User class in model
 * that test all the methods of that class
 */
public class TestUser extends BaseTest {

    @Test
    public void testGetUsername(){
        User user = new User();
        String username = "mariorossi";
        user.setUsername(username);
        assertEquals(username, user.getUsername() );
    }

    @Test
    public void testGetPassword(){
        User user = new User();
        String password = "verysecret";
        user.setPassword(password);
        assertEquals(password, user.getPassword() );
    }

    @Test
    public void testGetName(){
        User user = new User();
        String name = "mario";
        user.setName(name);
        assertEquals(name, user.getName() );
    }

    @Test
    public void testGetRoles(){
        User user = new User();
        String roles = "DOCTOR,OFFICE";
        user.setRoles(roles);
        assertEquals(roles, user.getRoles() );
    }

    @Test
    public void testGetActive(){
        User user = new User();
        boolean active = false;
        user.setActive(active);
        assertEquals(active, user.getActive() );
    }

    @Test
    public void testGetPatients(){
        User user = new User();
        Collection<Patient> patients = new HashSet<>();
        user.setPatients(patients);
        assertEquals(patients, user.getPatients() );
    }

    @Test
    public void testGetPrescriptions(){
        User user = new User();
        Collection<Prescription> patients = new HashSet<>();
        user.setPrescriptions(patients);
        assertEquals(patients, user.getPrescriptions() );
    }
}
