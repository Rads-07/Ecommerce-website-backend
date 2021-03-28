package com.blueconch.EcommerceWebsite.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueconch.EcommerceWebsite.model.User;
import com.blueconch.EcommerceWebsite.repository.UsersRepo;

@Service(value = "userService")
@Transactional
public class UsersService implements UserDetailsService {

	@Autowired
	private UsersRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		for(User user: repo.findAll()) {
			users.add(user);
		}
		return users;
	}
	
	@Transactional
	public User getUser(int userId) {
		return repo.findById(userId).get();
	}
	
	@Transactional
	public User addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repo.save(user);
	}
	
	@Transactional
	public User updateUser(User user) {
		return repo.save(user);
	}
	@Transactional
	public void deleteUser(int userId) {
		repo.deleteById(userId);
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user= repo.findByUsername(userName)
                .orElseThrow(
                        () -> new UsernameNotFoundException(format("User with username - %s, not found", userName))
                );
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
            //authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
		
	}
	
}
