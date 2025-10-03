package br.com.springEstudo.SpringSecurity.configs.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.springEstudo.SpringSecurity.infraestructure.models.UserModel;
import br.com.springEstudo.SpringSecurity.infraestructure.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	final UserRepository userRepository;
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel= userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found: "+username));
		return userModel; 
	}

}
