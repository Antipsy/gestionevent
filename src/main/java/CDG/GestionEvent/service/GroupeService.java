package CDG.GestionEvent.service;

import java.util.List;
import java.util.Set;

import CDG.GestionEvent.model.Groupe;
import CDG.GestionEvent.model.User;

public interface GroupeService {
	List<Groupe> getAllGroupes();
	void saveGroupe(Groupe groupe);
	Groupe getGroupeById(long id);
	void deleteGroupeById(long id);
	Set<User> getGroupeUsers(long id);
}
