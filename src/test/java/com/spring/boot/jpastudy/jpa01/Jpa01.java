package com.spring.boot.jpastudy.jpa01;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Jpa01 {

	private String userId = "user";
	private final User newUser = new User(userId, "user", LocalDateTime.now());
	@Autowired
	private UserRepo repo;

	@BeforeEach
	void before() {
		repo.save(newUser);
	}

	@Test
	void test() {
		User savedUser = repo.findById(userId)
				.orElseThrow(() -> new RuntimeException("아이디가 없습니다."));

		Assertions.assertEquals(newUser.getEmail(), savedUser.getEmail());
	}

	@Test
	void changeUserTest() {
		User savedUser = repo.findById(userId)
				.orElseThrow(() -> new RuntimeException("아이디가 없습니다."));

		savedUser.changeName("아무개");

		Assertions.assertEquals("아무개", savedUser.getName());
	}

	@AfterEach
	void after() {
//		repo.deleteById(userId);
		repo.deleteAll();
		List<User> users = repo.findAll();
		Assertions.assertEquals(0, users.size());
	}
}
