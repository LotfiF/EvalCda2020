package fr.cda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cda.repository.UserRepository;
import fr.cda.entities.User;

@RestController
public class UserRest {
	
	@Autowired
	private NoteRapideRepository noteRapRepo;
	
	@GetMapping("/note/user/{id}")
	public Iterable<NoteRapide> getNoteByUser(@PathVariable Long id) {
		return noteRapRepo.findByAuteurId(id);
	}
	
	@GetMapping("/note")
	public Iterable<NoteRapide> getAllNote() {
		return noteRapRepo.findAll();
	}
	
	@GetMapping("/note/publique")
	public Iterable<NoteRapide> getAllNotePublic() {
		return noteRapRepo.getNotePubliqueTrue();
	}
	
	
	@GetMapping("/note/privee")
	public Iterable<NoteRapide> getAllNotePrived() {
		return noteRapRepo.getNotePubliqueFalse();
	}
	
}
