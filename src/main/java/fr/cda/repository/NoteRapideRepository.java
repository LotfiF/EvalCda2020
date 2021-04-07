package fr.cda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cda.entities.User;
import fr.cda.entities.NoteRapide;

public interface NoteRapideRepository extends CrudRepository<NoteRapide, Long> {
    
    public Iterable<NoteRapide> findByAuteurId(Long id)
    
    @Query(value = "SELECT n from NoteRapide n INNER JOIN User u ON n.auteur.id = u.id WHERE n.auteur.id = ?1" )
    public Iterable<NoteRapide> getByIdAuteur(Long id)
    
    @Query(value = "SELECT n from NoteRapide n WHERE n.publique = true")
    public Iterable<NoteRapide> getNotePubliqueTrue(Long id)
    
    @Query(value = "SELECT n from NoteRapide n WHERE n.publique = false")
    public Iterable<NoteRapide> getNotePubliqueFalse(Long id)
    
    
    
    
}
