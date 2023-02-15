package CDG.GestionEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CDG.GestionEvent.model.Participation;
@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long>{

}
