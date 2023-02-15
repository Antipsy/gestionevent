package CDG.GestionEvent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import CDG.GestionEvent.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u from User u Where u.email = :email")
	public User getUserByUsername(@Param("email") String email);
	
	@Query("SELECT u from User u Where u.id = :id")
	public User getUserByid(@Param("id") String id);
}