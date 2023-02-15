package CDG.GestionEvent.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import CDG.GestionEvent.dto.UserRegistrationDto;
import CDG.GestionEvent.model.Groupe;
import CDG.GestionEvent.model.Role;
import CDG.GestionEvent.model.User;
import CDG.GestionEvent.repository.GroupeRepository;
import CDG.GestionEvent.repository.RoleRepository;
import CDG.GestionEvent.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private GroupeRepository groupeRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getUsersG() {
		return userRepository.findAll();
		
	}
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException(" User not found for id :: " + id);
		}
		return user;
	}
	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User();
		user.setNom(registrationDto.getNom());
		user.setPrenom(registrationDto.getPrenom());
		user.setEmail(registrationDto.getEmail());
		user.setSexe(registrationDto.getSexe());
		user.setTelephone(registrationDto.getTelephone());
		user.setDateN(registrationDto.getDateN());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword())); 
		user.setEnabled(true);
		
		long grpId = registrationDto.getGroupe().getId();
		Groupe groupe = groupeRepository.getGrByid(grpId);
		
		Role roleUser = roleRepository.findByName("Employee");
		user.addRole(roleUser);
		userRepository.save(user);
		groupe.addUser(user);
		groupeRepository.save(groupe);
		
		return userRepository.save(user);
	}

	
}