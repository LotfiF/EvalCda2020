package fr.cda.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class NoteRapide {
	
	@Id @GeneratedValue
	private Long id;
	
	private String contenue;
	
	@ManyToOne
	private User auteur;
	
	@ManyToOne
	private User destinataire;
	
	private boolean publique;
	
}
