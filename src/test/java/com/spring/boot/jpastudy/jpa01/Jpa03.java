package com.spring.boot.jpastudy.jpa01;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class Jpa03 {

	private String userId = "user";
	private final User newUser = new User(userId, "user", LocalDateTime.now());


	@Autowired
	private UserRepo repo;

	@BeforeEach
	@DisplayName("생성")
	void save() {
		repo.save(newUser);
		User user = findUser();
		Assertions.assertEquals("user", user.getEmail());
	}

	@DisplayName("조회")
	@Test
	@Order(2)
	void read() {
		User user = findUser();
		Assertions.assertNotNull(user);
	}

	@DisplayName("수정")
	@Test
	@Order(3)
	@Transactional
	void update() {
		User user = findUser();
		user.changeName("변경함니다.");
		User researchUser = findUser();

		Assertions.assertEquals("변경함니다.", researchUser.getName());
	}

	@Transactional
	@DisplayName("삭제")
	@Test
	@Order(4)
	void delete() {
		User user = findUser();
		repo.delete(user);

		Optional<User> byId = repo.findById(userId);

		User researchUser = byId.orElse(null);

		Assertions.assertNull(researchUser);
	}

	User findUser() {
		return repo.findById(userId)
				.orElseThrow(() -> new RuntimeException("아이디가 없습니다."));
	}


	@AfterEach
	void after() {
		repo.deleteAll();
		List<User> users = repo.findAll();
		Assertions.assertEquals(0, users.size());
	}

}
