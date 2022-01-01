package it.univr.efcgang.mentcare.repository;

import it.univr.efcgang.mentcare.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository  extends CrudRepository<User, Long> {
    List<User> findAll();
    User findById(long id);
    List <User> findByRole(String role);
}
