package CDG.GestionEvent.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CDG.GestionEvent.model.Event;

import CDG.GestionEvent.model.Participation;



import CDG.GestionEvent.repository.ParticipationRepository;

@Service
public class ParticipationServiceImpl implements ParticipationService{
	@Autowired
	private ParticipationRepository participationRepository;
	
	
	@Override
	public List<Participation> getAllParticipations() {
		return participationRepository.findAll();
		
	}
	@Override
	public void saveParticipation(Participation participation) {
		this.participationRepository.save(participation);
	}

	@Override
	public Participation getParticipationById(long id) {
		Optional<Participation> optional = participationRepository.findById(id);
		Participation participation = null;
		if(optional.isPresent()) {
			participation = optional.get();
		}else {
			throw new RuntimeException(" Participation not found for id :: " + id);
		}
		return participation;
	}
	@Override
	public void deleteParticipationById(long id) {
		this.participationRepository.deleteById(id);
		
	}
	@Override
	public Set<Event> getParticipationEvents(long id) {
		
		Optional<Participation> optional = participationRepository.findById(id);
		Participation participation = null;
		if(optional.isPresent()) {
			participation = optional.get();
		}else {
			throw new RuntimeException(" Participation not found for id :: " + id);
		}
		return participation.getEvents();
	}
}
