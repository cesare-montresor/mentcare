package it.univr.efcgang.mentcare.unittest;

import it.univr.efcgang.mentcare.models.Prescription;
import it.univr.efcgang.mentcare.repository.PrescriptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PrescriptionUnitTest {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Test
    public void testEmpty(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        List<Prescription> prescriptions = prescriptionRepository.findAll();
    }
}
