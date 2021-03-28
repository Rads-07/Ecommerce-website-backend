package com.blueconch.EcommerceWebsite.controller;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blueconch.EcommerceWebsite.DTO.ApiResponse;
import com.blueconch.EcommerceWebsite.DTO.UserDTO;
import com.blueconch.EcommerceWebsite.DTO.Login.UserLoginRequestDTO;
import com.blueconch.EcommerceWebsite.DTO.Login.UserLoginResponseDTO;
import com.blueconch.EcommerceWebsite.repository.UsersRepo;
import com.blueconch.EcommerceWebsite.model.User;
import com.blueconch.EcommerceWebsite.security.JwtTokenUtil;
import com.blueconch.EcommerceWebsite.services.UsersService;

@RestController
@RequestMapping("EcommerceAPI/public")
public class UserSignUpAndSignInController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UsersService userService;
	@Autowired
	private UsersRepo userRepo;

	@PostMapping("/signin")
	public ResponseEntity<UserLoginResponseDTO> login(@RequestBody @Validated UserLoginRequestDTO request) {
		try {

			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			//User user = (User) authenticate.getPrincipal();
			
	        String jwt =  jwtTokenUtil.generateToken(authenticate);
	        return ResponseEntity.ok(new UserLoginResponseDTO(jwt));
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	
	@PostMapping("/signup")
	public ResponseEntity<?> register(@RequestBody @Validated UserDTO request) {
		User user = convertToEntity(request);
		
		if(userRepo.existsByUsername(user.getUsername())) {
            return new ResponseEntity<>(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
		
		User result = userService.addUser(user);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));

	}
	
	private User convertToEntity(UserDTO userDTO) {
		User user = new ModelMapper().map(userDTO, User.class);

		return user;

	}

}
