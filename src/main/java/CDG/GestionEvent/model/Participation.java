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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "participation")
public class Participation {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "participation_id")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinTable(name="particip_event", joinColumns = @JoinColumn(name = "participation_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
	private Set<Event> events =new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Participation() {
		super();
	}

	public Participation(User user) {
		super();
		this.user = user;
	}

	public Participation(User user, Set<Event> events) {
		super();
		this.user = user;
		this.events = events;
	}
	
	
}
