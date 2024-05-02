package com.spring.boot.jpastudy.jpa01;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

	@Id
	private String email;
	private String name;
	@Column(name = "create_date")
	private LocalDateTime createDate;

	public void changeName(String name) {
		this.name = name;
	}



}
