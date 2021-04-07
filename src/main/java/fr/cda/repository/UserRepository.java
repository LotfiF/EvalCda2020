package fr.cda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.cda.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
	public Optional<User> findByLoginAndPassword(String login, String password);
    
}
