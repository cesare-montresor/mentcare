package it.univr.efcgang.mentcare.repository;

import it.univr.efcgang.mentcare.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends CrudRepository<User, Long> {
    List<User> findAll();
    User findById(long id);
    List <User> findByRolesContains(String roles);
    Optional<User> findByUsername(String username);
}
