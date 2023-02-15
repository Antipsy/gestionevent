package CDG.GestionEvent;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import CDG.GestionEvent.model.Groupe;
import CDG.GestionEvent.repository.GroupeRepository;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class GroupeRepositoryTest {
	@Autowired 
	GroupeRepository groupeRepository;
	
	@Test
	public void testCreateRoles() {
		Groupe Admin = new Groupe("Administration");
		Groupe rh = new Groupe("Ressources humaines");
		Groupe marketing = new Groupe("Marketing");
		Groupe logistique = new Groupe("Logistique");
		groupeRepository.saveAll(List.of(Admin,rh, marketing, logistique));
		
	}
	
}
