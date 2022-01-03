package it.univr.efcgang.mentcare.repository;

import it.univr.efcgang.mentcare.models.Patient;
import it.univr.efcgang.mentcare.models.Prescription;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrescriptionRepository  extends CrudRepository<Prescription, Long> {
    List<Prescription> findAll();
    Prescription findById(long id);
    List<Prescription> findByPatient(Patient patient);
}
