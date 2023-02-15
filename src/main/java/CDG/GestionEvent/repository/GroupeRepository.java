package CDG.GestionEvent.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import CDG.GestionEvent.model.Groupe;



@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long>{
	@Query("SELECT g from Groupe g Where g.id = :id")
	public Groupe getGroupeByid(@Param("id") String id);
	@Query("SELECT g from Groupe g Where g.id = :id")
	public Groupe getGrByid(@Param("id") long id);
	@Query("SELECT g FROM Groupe g WHERE g.nom = :nom")
	public Groupe findGrByName(@Param("nom")String nom);
}
