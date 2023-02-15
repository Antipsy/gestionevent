package CDG.GestionEvent.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import CDG.GestionEvent.model.Groupe;
import CDG.GestionEvent.model.User;
import CDG.GestionEvent.repository.GroupeRepository;
@Service
public class GroupeServiceImpl implements GroupeService{

	@Autowired
	private GroupeRepository groupeRepository;
	
	@Override
	public List<Groupe> getAllGroupes() {
		return groupeRepository.findAll();
		
	}
	@Override
	public void saveGroupe(Groupe groupe) {
		this.groupeRepository.save(groupe);
	}

	@Override
	public Groupe getGroupeById(long id) {
		Optional<Groupe> optional = groupeRepository.findById(id);
		Groupe groupe = null;
		if(optional.isPresent()) {
			groupe = optional.get();
		}else {
			throw new RuntimeException(" Groupe not found for id :: " + id);
		}
		return groupe;
	}
	@Override
	public void deleteGroupeById(long id) {
		this.groupeRepository.deleteById(id);
		
	}
	@Override
	public Set<User> getGroupeUsers(long id) {
		
		Optional<Groupe> optional = groupeRepository.findById(id);
		Groupe groupe = null;
		if(optional.isPresent()) {
			groupe = optional.get();
		}else {
			throw new RuntimeException(" Groupe not found for id :: " + id);
		}
		return groupe.getUsers();
	}

}
