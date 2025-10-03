package br.com.springEstudo.SpringSecurity.infraestructure.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springEstudo.SpringSecurity.infraestructure.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

	Optional<UserModel> findByUsername(String username);
	
}
