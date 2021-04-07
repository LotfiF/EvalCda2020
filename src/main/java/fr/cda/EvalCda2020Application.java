package fr.cda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cda.repository.UserRepository;
import fr.cda.entities.User;
import fr.cda.entities.NoteRapide;

@SpringBootApplication
public class PrimoCdaSpApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private NoteRapideRepository noteRapRepo;

	public static void main(String[] args) {
		SpringApplication.run(PrimoCdaSpApplication.class, args);
		
		System.out.println("********************Lancement terminé****************************");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("********************Lancement du projet*************************");
		
		User u1 = new Person(null, "FATHI", "Lotfi", 29, "log1", "pass1");
		User u2 = new Person(null, "SALAA", "Rim", 26, "log2", "pass2");
		User u3 = new Person(null, "nom3", "prenom3", 23, "log3", "pass3");
		User u4 = new Person(null, "nom4", "prenom4", 20, "log4", "pass4");
		
		Stream.of(u1, u2, u3, u4).forEach(u-> {
			userRepo.save(u)	
		});
		
		NoteRapide n1 = new NoteRapide(null, "Le vie est belle", true, u1, null);
		NoteRapide n2 = new NoteRapide(null, "Maman avant tout", false, u2, u1);
		NoteRapide n3 = new NoteRapide(null, "Le dev travaille chaque jour", true, u1, null );
		NoteRapide n4 = new NoteRapide(null, "La terre n'est pas plate", false, u1, null );
		NoteRapide n5 = new NoteRapide(null, "Covid est un cauchemar", false, u2, u4);
		NoteRapide n6 = new NoteRapide(null, "Hello Barcelone", true, u3, u1);
		
		Stream.of(n1, n2, n3, n4, n5, n6).forEach(n-> {
			userRepo.save(n)	
		});
	}

}
