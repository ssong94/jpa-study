package com.spring.boot.jpastudy.jpa04;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "hotel_info")
public class Hotel {

	@Id
	@Column(name = "hotel_id")
	private String id;
	@Column(name = "nm")
	private String name;
	private int year;
	@Enumerated(EnumType.STRING)
	private String grade;
	private LocalDateTime created;
	@Column(name = "modified")
	private LocalDateTime lastModified;

	protected Hotel() { // 인자 없는 기본 생성자. 접근 제어자는 protected 권장

	}

}
