package com.sit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sit.exception.UserNotFoundException;
import com.sit.model.User;
import com.sit.repository.UserRepository;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	User getUserById(@PathVariable Long id) {
	    return userRepository.findById(id)
	            .orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@PutMapping("/users/{id}")
	User updateUser(@RequestBody User newUser,@PathVariable Long id) {
		return userRepository.findById(id)
				.map(user ->{
					user.setusername(newUser.getusername());
					user.setname(newUser.getname());
					user.setemail(newUser.getemail());
					
					return userRepository.save(user);
					
				}).orElseThrow(()-> new UserNotFoundException(id));
	}
					
    @DeleteMapping("/users/{id}")
			String deletUser(@PathVariable Long id) {
				if(!userRepository.existsById(id)) {
							throw new UserNotFoundException(id);
						}
				userRepository.deleteById(id);
				return "User with id "+id+" has been deleted success.";
					}
	}


