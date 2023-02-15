package CDG.GestionEvent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "event_id")
	private Long id;
	
	@Column(name = "Nom")
	private String nom;
	
	private String description;
	
	private String type;
	
	private String Date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Event() {
		super();
	}
	
	
	public Event(Long id) {
		super();
		this.id = id;
	}

	public Event(String nom) {
		super();
		this.nom = nom;
	}

	public Event(String nom, String description, String type) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
	}

	public Event(String nom, String description, String type, String date) {
		super();
		this.nom = nom;
		this.description = description;
		this.type = type;
		this.Date = date;
	}
	@Override
	public String toString() {
		return this.nom;
	}
	
	
}
