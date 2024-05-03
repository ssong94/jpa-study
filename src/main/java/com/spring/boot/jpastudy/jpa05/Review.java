package com.spring.boot.jpastudy.jpa05;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private int year;
	@Enumerated(EnumType.STRING)
	private Grade grade;
	private LocalDateTime created;
	private LocalDateTime lastModified;

	protected Review() { // 인자 없는 기본 생성자. 접근 제어자는 protected 권장

	}

}
