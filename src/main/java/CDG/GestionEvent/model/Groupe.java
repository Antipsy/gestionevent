package CDG.GestionEvent.model;



import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "groupe")
public class Groupe {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "groupe_id")
	private Long id;
	
	@Column(name = "Nom")
	private String nom;
	
	@OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinTable(name="Gr_user", joinColumns = @JoinColumn(name = "groupe_id"), inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
	private Set<User> users =new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinTable(name="Gr_admin", joinColumns = @JoinColumn(name = "groupe_id"), inverseJoinColumns = @JoinColumn(name = "auth_user_id"))
	private Set<User> admins =new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinTable(name="Gr_event", joinColumns = @JoinColumn(name = "groupe_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private Set<Event> events =new HashSet<>();
	
	
	public Set<User> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<User> admins) {
		this.admins = admins;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

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
	

	public Groupe() {
		super();
	}

	public Groupe(String nom) {
		super();
		this.nom = nom;
	}

	
	
	public void addUser(User user) {
		this.users.add(user);
		
	}
	public void addAdmin(User user) {
		this.admins.add(user);
		
	}
	public void addEvent(Event event) {
		this.events.add(event);
		
	}
	
	
}
