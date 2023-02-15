package CDG.GestionEvent;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import CDG.GestionEvent.model.Role;
import CDG.GestionEvent.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {
	@Autowired 
	RoleRepository roleRepository;
	
	@Test
	public void testCreateRoles() {
		Role superAdmin = new Role("Super Admin");
		Role adminG = new Role("Admin groupe");
		Role employe = new Role("Employee");
		roleRepository.saveAll(List.of(superAdmin, adminG, employe));
		List<Role> listRoles = roleRepository.findAll();
		assertThat(listRoles.size()).isEqualTo(3);
	}
}
