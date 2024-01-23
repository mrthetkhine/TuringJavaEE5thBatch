package com.turing.mongo.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.turing.mongo.demo.model.Role;
import com.turing.mongo.demo.model.User;
import com.turing.mongo.demo.repository.UserRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Rollback(false)
public class SecurityUtil {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Test
	void testAddUser()
	{
		System.out.println("Start test");
		User user = new User();
		user.setUsername("admin");
		user.setPassword(this.passwordEncoder.encode("admin"));
		user.setEmail("admin@gmail.com");
		
		Role role = new Role();
		role.setRole("ADMIN");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		this.userRepository.save(user)
			.subscribe(data->{
				System.out.println("User saved "+data);
			});
		
		this.userRepository.findByUsername("admin")
			.subscribe(data->{
				System.out.println("Admin user found");
			});
	
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
