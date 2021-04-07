package fr.cda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cda.repository.UserRepository;
import fr.cda.entities.User;

@RestController
public class UserRest {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/connexion")
	public Optional<User> connexion(@RequestBody User u) {
		return userRepo.findByLoginAndPassword(u.getLogin(), u.getPassword());
	}
	
}
