package CDG.GestionEvent;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;

import CDG.GestionEvent.model.Groupe;
import CDG.GestionEvent.model.Role;
import CDG.GestionEvent.model.User;
import CDG.GestionEvent.repository.GroupeRepository;
import CDG.GestionEvent.repository.RoleRepository;
import CDG.GestionEvent.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired 
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupeRepository groupeRepository;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setNom("El Bakbachi");
		user.setPrenom("Wassim");
		user.setSexe("Homme");
		user.setEmail("wassim@gmail.com");
		user.setTelephone("0645319396");
		user.setPassword("$2a$10$beXQpfgVfeIBPmufWGeIMewGQrjypoiYrcMAOSmoUVPI.2vkw42au"); 
		user.setDateN("1999-03-10");
		user.setEnabled(true);
		Groupe groupeUser = groupeRepository.findGrByName("Administration");
		Role roleUser = roleRepository.findByName("Super Admin");
		user.addRole(roleUser);
		
		User savedUser = userRepository.save(user);
		assertThat(savedUser.getRoles().size()).isEqualTo(1);
		groupeUser.addUser(savedUser);
		groupeUser.addAdmin(savedUser);
		groupeRepository.save(groupeUser);
		
	}
}
