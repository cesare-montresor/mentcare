package it.univr.efcgang.mentcare.repository;

import it.univr.efcgang.mentcare.models.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PatientRepository  extends CrudRepository<Patient, Long> {
    List<Patient> findAll();
    Patient findById(long id);
}
