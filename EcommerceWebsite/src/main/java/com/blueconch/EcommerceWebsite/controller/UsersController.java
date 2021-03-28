package com.blueconch.EcommerceWebsite.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueconch.EcommerceWebsite.DTO.ApiResponse;
import com.blueconch.EcommerceWebsite.DTO.UserDTO;
import com.blueconch.EcommerceWebsite.model.User;
import com.blueconch.EcommerceWebsite.services.UsersService;

@RestController
@RequestMapping("/EcommerceAPI")
public class UsersController {

	@Autowired
	private UsersService service;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/users/admin")	
	public List<UserDTO> getUsers(){
		List<User>users = service.getUsers();
		return users.stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());			
	}
	
	@PreAuthorize("hasanyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/{userId}")
	public UserDTO getUser(@PathVariable int userId) {
		User user = service.getUser(userId);
		UserDTO  userDTO = convertToDto(user);
		return userDTO;
				
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("users/admin")
	public UserDTO addUser(@RequestBody UserDTO userDTO) {
		User user = convertToEntity(userDTO);
		return convertToDto(service.addUser(user));
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("users/admin/{userId}")
	public UserDTO updateUser(@RequestBody UserDTO userDTO) {
		User user = convertToEntity(userDTO);
		return convertToDto(service.updateUser(user));

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("users/admin/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId) {
		service.deleteUser(userId);
		return new ResponseEntity<>(new ApiResponse(true, "User Deleted Successfully!"),HttpStatus.ACCEPTED);
	}
	
	
	private UserDTO convertToDto(User user) {
        UserDTO userDTO = new ModelMapper().map(user, UserDTO.class);
        return userDTO;
    }
	
	private User convertToEntity(UserDTO userDTO) {
		User user = new ModelMapper().map(userDTO, User.class);
        return user;
    }
	
}
