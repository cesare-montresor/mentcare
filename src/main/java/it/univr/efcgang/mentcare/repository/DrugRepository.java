package it.univr.efcgang.mentcare.repository;

import it.univr.efcgang.mentcare.models.Drug;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DrugRepository extends CrudRepository<Drug, Long> {
    List<Drug> findAll();
    Drug findById(long id);
}
