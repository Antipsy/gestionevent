package CDG.GestionEvent.service;

import java.util.List;
import java.util.Set;

import CDG.GestionEvent.model.Event;
import CDG.GestionEvent.model.Participation;


public interface ParticipationService {
	List<Participation> getAllParticipations();
	void saveParticipation(Participation participation);
	Participation getParticipationById(long id);
	void deleteParticipationById(long id);
	Set<Event> getParticipationEvents(long id);
}
