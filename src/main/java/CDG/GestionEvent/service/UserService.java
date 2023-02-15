package CDG.GestionEvent.service;



import java.util.List;

import CDG.GestionEvent.dto.UserRegistrationDto;

import CDG.GestionEvent.model.User;

public interface UserService{
	User getUserById(long id);
	List<User> getUsersG();
	List<User> getAllUsers();
	User save(UserRegistrationDto registrationDto);
}