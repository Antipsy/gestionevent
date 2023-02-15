package CDG.GestionEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import CDG.GestionEvent.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
	@Query("SELECT e from Event e Where e.id = :id")
	public Event getEventByid(@Param("id") long id);
	@Query("SELECT e FROM Event e WHERE e.nom = :nom")
	public Event findEventByName(@Param("nom")String nom);
}
