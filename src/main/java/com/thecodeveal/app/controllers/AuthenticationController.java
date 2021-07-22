package com.thecodeveal.app.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thecodeveal.app.entities.Authority;
import com.thecodeveal.app.gcc.Models.Sermon;
import com.thecodeveal.app.gcc.exceptions.ResourceNotFoundException;
import com.thecodeveal.app.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.thecodeveal.app.config.JWTTokenHelper;
import com.thecodeveal.app.entities.User;
import com.thecodeveal.app.requests.AuthenticationRequest;
import com.thecodeveal.app.responses.LoginResponse;
import com.thecodeveal.app.responses.UserInfo;

@CrossOrigin(value = {"http://localhost:3000","https://master.d1zaj6z68k0ehd.amplifyapp.com", "https://gcc-app-ug.herokuapp.com/", "https://main.d2ia5wwug43lbw.amplifyapp.com"})
@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenHelper jWTTokenHelper;

	@Qualifier("customUserService")
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user=(User)authentication.getPrincipal();
		String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
		
		LoginResponse response=new LoginResponse();
		response.setToken(jwtToken);
		

		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/auth/userinfo")
	public ResponseEntity<?> getUserInfo(Principal user){
		User userObj=(User) userDetailsService.loadUserByUsername(user.getName());

		UserInfo userInfo=new UserInfo();
		userInfo.setUserName(userObj.getUsername());
		userInfo.setRoles(userObj.getAuthorities().toArray());

		return ResponseEntity.ok(userInfo);
	}

	//Delete Administrator
	@DeleteMapping("/auth/admin/{id}")
	public Map<String, Boolean> deleteSermon(@PathVariable(value = "id") Long sermonId)
			throws ResourceNotFoundException {

		User sermon = userDetailsRepository.findById(sermonId)
				.orElseThrow(() -> new ResourceNotFoundException("sermon not Found for id: " + sermonId));

		this.userDetailsRepository.delete(sermon);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

	//Save New Donations Mobile Money
	@PostMapping("/addUSer")
	public ResponseEntity<?> createDonateM(@RequestBody User user) {

		List<Authority> authorityList=new ArrayList<>();

		authorityList.add(createAuthority("USER","User role"));
		authorityList.add(createAuthority("ADMIN","Admin role"));
//		authorityList.add(createAuthority("MASTER-ADMIN","Master Admin role"));

//		User user = new User();

//		user.setUserName("Allan");

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		user.setAuthorities(authorityList);

		return ResponseEntity.ok(userDetailsRepository.save(user));
	}

	@GetMapping("/auth/allUsers")
	public ResponseEntity<?> getUsers(Principal p){

		return ResponseEntity.ok(userDetailsRepository.findAll());
	}

	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
}
